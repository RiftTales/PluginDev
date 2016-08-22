package me.tonayy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdHof extends CmdBase {

	public CmdHof(DevTestingPlugin plugin) {

		this.commandName = "Hof";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		sender.getServer().broadcastMessage(ChatColor.AQUA + "Each inductee into the Hall of Fame has dedicated more than a decade to the fields of entertainment, media, and the arts.");
		sender.getServer().broadcastMessage(ChatColor.AQUA + "Advancing their careers while consistently giving back to the students and the graduates of Full Sail University.");
		return true;
	}
}