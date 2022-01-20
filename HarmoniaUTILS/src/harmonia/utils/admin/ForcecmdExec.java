package harmonia.utils.admin;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ForcecmdExec implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {
        Player p = (Player) s;
        OfflinePlayer target = Bukkit.getOfflinePlayer(a[0]);
        if(s instanceof Player){
            Bukkit.getConsoleSender().sendMessage(((Player) s).getDisplayName() + " forced ");
            for(Player player : Bukkit.getOnlinePlayers()){
                if(player.hasPermission("Permission.Node.Here")) {
                    p.sendMessage(((Player) s).getDisplayName() + " §cforced §f" + target.getName() + " §cto execute §f/" + a[1]);
                }
            }
            try{
                switch(a[1]){
                    case "disconnect":
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "kick " + target.getName() + " Disconnected due to an error");
                        break;
                    case "spamchat":
                        for(int i = 0; i < 10000; i++){
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
                                @Override
                                public void run() {
                                    target.getPlayer().sendMessage("§c§lBOLOSSED BY §r" + ((Player) s).getDisplayName());
                                }
                                // The stuff which should be accomplished after the timer runs out goes here.
                                // Example:

                            }, 10L); //20L = 1 seconde || 40L = 2 secondes
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "kick " + target.getName() + " cheh.");
                        break;
                }
            }
            catch(Exception e){ e.printStackTrace(); }
            Bukkit.getServer().dispatchCommand(target.getPlayer(), a[1]);
        }
        return false;
    }
}
