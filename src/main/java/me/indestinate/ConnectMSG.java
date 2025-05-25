package me.indestinate;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import me.indestinate.ConnectMSGCommand;

public class ConnectMSG extends Plugin implements Listener {

    private final HashSet<UUID> connecting = new HashSet<>();
    private Configuration config;

    @Override
    public void onEnable() {
        getLogger().info("[ConnectMessage] Plugin initiating...");
        loadConfig();
        getProxy().getPluginManager().registerListener(this, this);
        getProxy().getPluginManager().registerCommand(this, new ConnectMSGCommand(this));
        getLogger().info("[ConnectMessage] Initiation Complete...");
    }

    public void loadConfig() {
        try {
            // getDataFolder() is already 'plugins/ConnectMSG'
            File folder = getDataFolder();
            if (!folder.exists()) folder.mkdirs();

            File configFile = new File(folder, "config.yml");

            if (!configFile.exists()) {
                Files.copy(getResourceAsStream("config.yml"), configFile.toPath());
            }

            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);

        } catch (IOException e) {
            getLogger().severe("Could not load config.yml!");
            e.printStackTrace();
        }
    }

    @EventHandler
    public void onServerConnect(ServerConnectEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();

        if (connecting.contains(uuid)) {
            ServerInfo target = event.getTarget();
            String serverName = target.getName();

            String rawMessage = config.getString("message", "&b&l(%server%) &r&7You are already connecting to this server!");
            String formatted = rawMessage.replace("%server%", serverName);
            formatted = ChatColor.translateAlternateColorCodes('&', formatted);

            event.getPlayer().sendMessage(TextComponent.fromLegacyText(formatted));
            event.setCancelled(true);
        } else {
            connecting.add(uuid);
            getProxy().getScheduler().schedule(this, () -> connecting.remove(uuid), 3, TimeUnit.SECONDS);
        }
    }
}
