package harmonia.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ShutdownHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {
        Player p = (Player) s;
        if(s instanceof Player){
            Bukkit.getServer().broadcastMessage("§cSERVER SHUTDOWN IN 2 SECONDS");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
                @Override
                public void run() {
                    Bukkit.getServer().shutdown();
                }
                // The stuff which should be accomplished after the timer runs out goes here.
            // Example:

            }, 40L); //20L = 1 seconde || 40L = 2 secondes
        }
        return false;
    }
}
