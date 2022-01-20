package harmonia.utils.moderation;

import harmonia.utils.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class SSInventory {
    public static void GUI_MENU(final Player player) {
        final Inventory principalGUI = Bukkit.createInventory((InventoryHolder)null, 36, "§7S\u00e9lectionnez un jeu");
        final ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short)14).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).lore("lore1", "", "").build();
        principalGUI.setItem(28, glass);
        player.openInventory(principalGUI);
    }
}
