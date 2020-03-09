package com.mcsunnyside.unibancopy.module;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BukkitModule implements BanManager {
    @Override
    public Set<UUID> fetchBanList() {
        Set<UUID> uuidCollection = new HashSet<>();
        for (OfflinePlayer offlinePlayer:
             Bukkit.getBannedPlayers()) {
            uuidCollection.add(offlinePlayer.getUniqueId());
        }
        return uuidCollection;
    }
}
