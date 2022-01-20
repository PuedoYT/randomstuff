package harmonia.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {
        Player p = (Player) s;
        if(s instanceof Player){
            Bukkit.getConsoleSender().sendMessage("§aTP: §fHub §8| §aPlayer: §f" + ((Player) s).getDisplayName());
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mv tp " + s.getName() + " lobby");
        }
        return false;
    }
}
