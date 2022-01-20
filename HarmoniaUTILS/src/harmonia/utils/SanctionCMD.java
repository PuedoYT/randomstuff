package harmonia.utils;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SanctionCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {
        Player p = (Player) s;
        OfflinePlayer target = Bukkit.getOfflinePlayer(a[0]);
        if(s instanceof Player){
            if(a[0] != null && a[2] != null){
                switch(a[1].toLowerCase()){
                    case "kick":
                        target.getPlayer().kickPlayer(a[2]);
                        break;
                    case "ban":
                        Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), "§cBanned.", null, null);
                        break;
                }
            }
        }
        return false;
    }
}
