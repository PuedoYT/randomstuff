package alpha.harmonia;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import alpha.harmonia.utils.moderation.Kick;
import org.bukkit.entity.Player;

public class ModCommands implements CommandExecutor {
    Kick kick = new Kick();

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {
        Player p = (Player) s;

        if(cmd.getName().equalsIgnoreCase("kick")){
            kick.onCommand(s, cmd, st, a);
        }
        return false;
    }
}
