package alpha.harmonia;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItems {
    public ItemStack RodOfPower(){
        ItemStack powerRod = new ItemStack(Material.BLAZE_ROD);
        ItemMeta powerRodMeta = powerRod.getItemMeta();
        powerRodMeta.setDisplayName("§6§lROD OF POWER");
        powerRod.setItemMeta(powerRodMeta);
        return powerRod;
    }
}

