package harmonia.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CBC implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {
        Player p = (Player) s;
        if(s instanceof Player){
            String oldbc = "";
            String bc = "";
            for(int i = 0; i < a[i].length(); i++){
                if(a[i] == null){
                    return false;
                } else {
                    oldbc = a[i];
                    bc = bc + " " + oldbc;
                    Bukkit.getServer().broadcastMessage("§6Harmoni BROADCAST §8| " + bc);
                }
            }
        }
        return false;
    }
}
