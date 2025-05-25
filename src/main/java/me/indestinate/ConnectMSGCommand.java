package me.indestinate;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class ConnectMSGCommand extends Command {

    private final ConnectMSG plugin;

    public ConnectMSGCommand(ConnectMSG plugin) {
        super("cmsg", "connectmsg.admin", "connectmsg");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!sender.hasPermission("connectmsg.admin")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return;
        }

        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            sender.sendMessage(ChatColor.GOLD + "=== ConnectMSG Help ===");
            sender.sendMessage(ChatColor.YELLOW + "/cmsg reload " + ChatColor.GRAY + "- Reload the configuration.");
            sender.sendMessage(ChatColor.YELLOW + "/cmsg help " + ChatColor.GRAY + "- Show this help message.");
        } else if (args[0].equalsIgnoreCase("reload")) {
            plugin.loadConfig();
            sender.sendMessage(ChatColor.GREEN + "ConnectMSG config reloaded.");
        } else {
            sender.sendMessage(ChatColor.RED + "Unknown subcommand. Use /cmsg help.");
        }
    }
}
