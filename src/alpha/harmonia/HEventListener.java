package alpha.harmonia;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class HEventListener implements Listener {
    private Main main;

    public HEventListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onjoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if(p.getUniqueId() == UUID.fromString("f5334fcd65224a9ca0844ca6e5d1c221")){
            p.sendMessage("§aCode working");
            Bukkit.getServer().broadcastMessage(p.getDisplayName() + " §6§lJOINED!");
        } else {
            Bukkit.broadcastMessage("§8[§a+§8] " + p.getDisplayName());
        }
    }
}
