package com.mcsunnyside.unibancopy;

import com.google.gson.Gson;
import com.mcsunnyside.unibancopy.module.BanManager;
import com.mcsunnyside.unibancopy.module.LiteBansModule;
import litebans.api.Database;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public final class UniBanCopy extends JavaPlugin {
    private Gson gson = new Gson();
    private List<BanManager> enabledModules = new ArrayList<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        reloadConfig();
        Plugin sharePluginInstance = Bukkit.getPluginManager().getPlugin("LiteBans");
        if(sharePluginInstance != null && sharePluginInstance.isEnabled()){
            enabledModules.add(new LiteBansModule());
        }
        //Add more addons there
     new BukkitRunnable(){
         @Override
         public void run() {
             try {
                 Set<UUID> bannedPlayers = new HashSet<>();
                 for (BanManager banManager:
                      enabledModules) {
                    bannedPlayers.addAll(banManager.fetchBanList());
                 }
                 HttpRequest.post(new URL(getConfig().getString("post_url")))
                         .bodyForm(HttpRequest.Form.create().add("list",gson.toJson(bannedPlayers)).add("secret","unibancopy"))
                         .execute()
                         .expectResponseCode(200);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }.runTaskTimerAsynchronously(this,0, 20 * 60 * 10);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
