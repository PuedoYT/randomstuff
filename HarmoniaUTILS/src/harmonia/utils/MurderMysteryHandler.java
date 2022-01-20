package harmonia.utils;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class MurderMysteryHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {
        Player p = (Player) s;
        Map<String, String> mmhandler = new HashMap<>();

        String innocent = "§aInnocent";
        String murder = "§cMurder";
        OfflinePlayer target = Bukkit.getOfflinePlayer(a[0]);
        if(s instanceof Player){
            switch (a[1].toLowerCase()){

                case "setrole":
                    switch (a[2].toLowerCase()){
                        case "murder":
                            break;
                        case "innocent":
                            mmhandler.put(target.getName(), innocent);
                            break;
                    }

                case "getrole":
                    if(mmhandler.containsKey(target.getName())){
                        s.sendMessage("Role: " + mmhandler.get(target.getName()));
                        break;
                    }
                    break;

                case "removerole":
                    switch (a[1].toLowerCase()){
                        case "murder":
                        case "detective":
                    }

            }
        }
        return false;
    }
}
