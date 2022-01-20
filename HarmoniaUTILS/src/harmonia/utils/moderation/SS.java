package harmonia.utils.moderation;

import harmonia.utils.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class SS implements CommandExecutor,Listener {

    Inventory hs = Bukkit.createInventory(null, 27, "hs");
    Inventory hs_triche = Bukkit.createInventory(null, 9, "§7Triche");
    Inventory hs_gameplay = Bukkit.createInventory(null, 9, "§7Gameplay");
    Inventory hs_chat = Bukkit.createInventory(null, 9, "§7Chat");

    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {
        Player p = (Player) s;
        OfflinePlayer target = Bukkit.getOfflinePlayer(a[0]);


        ItemStack triche = new ItemStack(Material.IRON_SWORD);
        ItemMeta tricheM = triche.getItemMeta();
        tricheM.setDisplayName("§cTriche");
        triche.setItemMeta(tricheM);

        ItemStack gameplay = new ItemStack(Material.TNT);
        ItemMeta gameplayM = gameplay.getItemMeta();
        gameplayM.setDisplayName("§cGameplay");
        gameplay.setItemMeta(gameplayM);

        ItemStack chat = new ItemStack(Material.PAPER);
        ItemMeta chatM = gameplay.getItemMeta();
        chatM.setDisplayName("§cChat");
        chat.setItemMeta(chatM);



        if(s instanceof Player){
            hs.setItem(11, triche);
            hs.setItem(13, gameplay);
            hs.setItem(15, chat);

            hs_triche.setItem(0, new ItemStack(Material.DIRT, 1));
            hs_gameplay.setItem(0, new ItemStack(Material.DIRT, 1));
            hs_chat.setItem(0, new ItemStack(Material.DIRT, 1));
            p.openInventory(hs);
        }
        return false;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Inventory inv = e.getInventory();
        Player player = (Player) e.getWhoClicked();
        ItemStack current = e.getCurrentItem();

        if(current == null) return;
        if(inv.getName().equalsIgnoreCase("hs")){
            player.sendMessage("§aOpened inventory: " + hs.getName());
            e.setCancelled(true);

            switch(current.getType()){
                case IRON_SWORD:
                    player.sendMessage("§aClicked on: " + current.getItemMeta().getDisplayName());
                    player.closeInventory();
                    player.openInventory(hs_triche);
                    break;
                case TNT:
                    player.openInventory(hs_gameplay);
                    player.closeInventory();
                    break;
                case PAPER:
                    player.openInventory(hs_chat);
                    player.closeInventory();
                    break;
                default: break;
            }
        }

    }


}
