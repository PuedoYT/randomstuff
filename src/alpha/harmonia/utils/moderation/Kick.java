package alpha.harmonia.utils.moderation;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {

        Player p = (Player) s;
        OfflinePlayer target = Bukkit.getOfflinePlayer(a[0]);
        String reason = a[1];
        String message = "§6§lHARMONIA §8- §cKicked: " + reason;

        if(s instanceof Player && p.hasPermission("mod.kick") && target.hasPlayedBefore() && target.isOp() == false){
            Bukkit.getServer().getPlayer(target.getName()).kickPlayer(message);
        } else { p.sendMessage("§cError: Cannot kick §f§l" + target.getPlayer().getDisplayName()); }
        return false;
    }
}
