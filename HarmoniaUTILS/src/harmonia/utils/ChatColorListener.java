package harmonia.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

public class ChatColorListener implements Listener {

    public void cmd(PlayerCommandPreprocessEvent e){
        Player p = e.getPlayer();
        String cmd = e.getMessage();

    }

    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(p.isBanned()){
            p.kickPlayer("§cBanned.");
        }
    }

    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Action a = e.getAction();
        ItemStack it = e.getItem();
        if(it != null && it.getType() == Material.BLAZE_ROD && it.getItemMeta().getDisplayName().equalsIgnoreCase("Power")){
            if(a == Action.RIGHT_CLICK_AIR){
                Bukkit.broadcastMessage(p.getDisplayName() + " §cused §4§lTHE ROD OF POWER");
            }
        }
    }
}
