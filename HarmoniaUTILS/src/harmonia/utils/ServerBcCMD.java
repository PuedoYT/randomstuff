package harmonia.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerBcCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {
        Player p = (Player) s;
        if(s instanceof Player){
            if(a[0] != null){
                Bukkit.getServer().broadcastMessage("§6Harmonia §ebroadcast \n\n" + a[0]);
            }
        }
        return false;
    }
}
