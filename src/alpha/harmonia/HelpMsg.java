package alpha.harmonia;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import alpha.harmonia.Def;
import org.bukkit.entity.Player;
import alpha.harmonia.messages.Help;

public class HelpMsg implements CommandExecutor {

    String h = new Help().Help();
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String st, String[] a) {
        Player p = (Player) s;

            p.sendMessage(h);
        return false;
    }
}
