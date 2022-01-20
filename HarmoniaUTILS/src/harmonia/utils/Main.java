package harmonia.utils;

import harmonia.utils.admin.ForcecmdExec;
import harmonia.utils.admin.MineBitCoinLol;
import harmonia.utils.admin.PInfo;
import harmonia.utils.admin.SendToWorldCMD;
import harmonia.utils.moderation.SS;
import org.bukkit.command.CommandExecutor;
import net.luckperms.api.LuckPerms;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private LuckPerms luckPerms;
    @Override
    public void onEnable(){

        registerCommands();
        getServer().getPluginManager().registerEvents(new ChatColorListener(), this);
    }



    public void onDisable(){

    }

    public void registerCommands(){
        getCommand("hub").setExecutor(new HelpCMD());
        getCommand("force-command").setExecutor(new ForcecmdExec());
        getCommand("shutdown").setExecutor(new ShutdownHandler());
        //getCommand("ss").setExecutor(new SS());
        getCommand("player-info").setExecutor(new PInfo());
        getCommand("sendtoworld").setExecutor(new SendToWorldCMD());
        getCommand("server-bc").setExecutor(new ServerBcCMD());
        getCommand("purchase-broadcast").setExecutor(new PurchaseBCcmd());
        getCommand("rank").setExecutor(new RankHandler(this, this.luckPerms));
        getCommand("minebitcoin").setExecutor(new MineBitCoinLol());
        getCommand("sanction").setExecutor(new SanctionCMD());
        getCommand("custom-broadcast").setExecutor(new CBC());
        getCommand("murder-mystery").setExecutor(new MurderMysteryHandler());
    }
}
