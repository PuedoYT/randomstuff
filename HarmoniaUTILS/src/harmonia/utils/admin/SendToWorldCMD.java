package harmonia.utils.admin;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendToWorldCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {
        Player p = (Player) s;
        OfflinePlayer target = Bukkit.getOfflinePlayer(a[0]);
        String WorldName = a[1];
        int z = 4; int y = 5; int x = -4;
        if(s instanceof Player){
            if(a[1] == "AdminWorld"){
                if(a[2].equalsIgnoreCase("cheater")){
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mv tp " + target.getName() + " " + WorldName);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tp " + target.getName() + " 4 6 -4");
                    target.getPlayer().sendTitle("§c§lCheating is not good :(", "§cWatch your chat.");
                } else { Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mv tp " + target.getName() + " " + WorldName); }
            } else {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mv tp " + target.getName() + " " + WorldName);
            }
            p.sendMessage(target.getPlayer().getDisplayName() + " §ahas been move to §r" + WorldName + " §abecause they are a cheater");
        }
        return false;
    }
}
