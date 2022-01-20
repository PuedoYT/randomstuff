package harmonia.utils;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.InheritanceNode;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;



public class RankHandler implements CommandExecutor {
    private Main plugin;
    private LuckPerms luckPerms;

    public void SetGroupCommand(Main plugin, LuckPerms luckPerms) {
        this.plugin = plugin;
        this.luckPerms = luckPerms;
    }

    public RankHandler(Main plugin, LuckPerms luckPerms) {
        this.plugin = plugin;
        this.luckPerms = luckPerms;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Please specify a player & a group!");
            return true;
        }

        String playerName = args[0];
        String groupName = args[1];

        // Get an OfflinePlayer object for the player
        OfflinePlayer player = this.plugin.getServer().getOfflinePlayer(playerName);
        OfflinePlayer target = this.plugin.getServer().getOfflinePlayer(args[0]);

        // Player not known?
        if (player == null ||!player.hasPlayedBefore()) {
            sender.sendMessage(ChatColor.RED + playerName +  " has never joined the server!");
            return true;
        }

        Group group = this.luckPerms.getGroupManager().getGroup(groupName);

        // Group doesn't exist?
        if (group == null) {
            sender.sendMessage(ChatColor.RED + groupName +  " does not exist!");
            return true;
        }

        // Load, modify & save the user in LuckPerms.
        this.luckPerms.getUserManager().modifyUser(player.getUniqueId(), (User user) -> {

            // Remove all other inherited groups the user had before.
            user.data().clear(NodeType.INHERITANCE::matches);

            // Create a node to add to the player.
            Node node = InheritanceNode.builder(group).build();

            // Add the node to the user.
            user.data().add(node);

            // Tell the sender.
            sender.sendMessage(ChatColor.GREEN + "Set §6" + user.getUsername() + ChatColor.GREEN + "'s rank to §r" + group.getDisplayName());
            target.getPlayer().sendMessage(ChatColor.GREEN + "Your rank is now §r" + group.getDisplayName() );
        });

        return true;
    }
}
