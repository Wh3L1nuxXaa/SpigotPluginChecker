package org.bukkit.plugin;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;

public interface Plugin {
    public File getDataFolder();
    public InputStream getResource(String var1);

    public void saveConfig();

    public void saveDefaultConfig();

    public void saveResource(String var1, boolean var2);

    public void reloadConfig();

    public boolean isEnabled();

    public void onDisable();

    public void onLoad();

    public void onEnable();

    public boolean isNaggable();

    public void setNaggable(boolean var1);
    public Logger getLogger();
    public String getName();
}
