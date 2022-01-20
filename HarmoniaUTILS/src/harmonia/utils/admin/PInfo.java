package harmonia.utils.admin;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PInfo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {
        Player p = (Player) s;
        OfflinePlayer target = Bukkit.getOfflinePlayer(a[0]);

        String[] player_info = {
                "§cName: §f" + target.getName(),
                "§cRank: §f%vault_prefix%",
                "§cUUID: §f" + target.getUniqueId(),
                "§CIP: §f" + target.getPlayer().getServer().getIp()
        };

        p.sendMessage(player_info);

        return false;
    }
}
