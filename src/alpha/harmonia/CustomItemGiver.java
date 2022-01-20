package alpha.harmonia;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import alpha.harmonia.CustomItems;

public class CustomItemGiver implements CommandExecutor {
    public void itemReceived(String sender, String player, String itemReceived, String color){
        sender.toString();
        player.toString();
        itemReceived.toString();
        color.toString();
        Bukkit.getPlayer(player).sendMessage("§" + color + "You received a " + itemReceived);
        Bukkit.getPlayer(sender).sendMessage("§" + color + player + " received a " + itemReceived);
    }
    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {
        Player p = (Player) s;
        OfflinePlayer target = Bukkit.getOfflinePlayer(a[0]);
        CustomItems ci = new CustomItems();

            if(a.length != 0)
            {
                try{
                    switch(a[1]){
                        case "rop":
                            target.getPlayer().getInventory().addItem(ci.RodOfPower());
                            target.getPlayer().sendMessage("§aYou received a " + ci.RodOfPower().getItemMeta().getDisplayName());
                            s.sendMessage("§a" + target.getPlayer().getDisplayName() + " received their item(s)!");
                    }
                }catch(Exception e) { e.printStackTrace(); }
            }else{ p.sendMessage("§cArguments must not be null"); }
        return false;
    }
}
