package alpha.harmonia;

import alpha.harmonia.sql.MySQL;
import alpha.harmonia.sql.SQLGetter;
import alpha.harmonia.utils.moderation.Kick;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public class Main extends JavaPlugin implements Listener {

    public MySQL SQL;
    public SQLGetter data;

    @Override
    public void onEnable() {
        this.SQL = new MySQL();
        this.data = new SQLGetter(this);

        try{ SQL.connect(); }
        catch (ClassNotFoundException | SQLException e) {
            //e.printStackTrace();
            Bukkit.getLogger().info("Database not connected.");
        }
        if(SQL.isConnected()) {
            Bukkit.getServer().broadcastMessage("§aDATABASE CONNECTED!");
            Bukkit.getLogger().info("Database connected!");

            data.createTable();
            this.getServer().getPluginManager().registerEvents(this, this);
        }

        registerCommands();
    }

    @Override
    public void onDisable() {
        SQL.disconnect();
        // Plugin shutdown logic
    }

    public void registerCommands(){
        getCommand("kick-user").setExecutor(new Kick());
        getCommand("help").setExecutor(new HelpMsg());
        getCommand("givecustomitem").setExecutor(new CustomItemGiver());
    }

    public void registerListeners(){
        Bukkit.getPluginManager().registerEvents(new HEventListener(this), this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent pje){
        Player p = pje.getPlayer();
        data.createPlayer(p);
    }

    @EventHandler
    public void onChat(PlayerChatEvent pce){
        Player p = pce.getPlayer();
        if(data.getChatPerm(p.getUniqueId())){
            p.sendMessage("§cYou are muted");
        }
        return;
    }

}
