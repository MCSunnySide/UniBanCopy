package com.mcsunnyside.unibancopy.module;

import java.util.Set;
import java.util.UUID;

public interface BanManager {
    Set<UUID> fetchBanList();
}
