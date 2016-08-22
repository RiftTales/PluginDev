package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdStahp extends CmdBase {

	public CmdStahp(DevTestingPlugin plugin) {

		this.commandName = "Stahp";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		this.plugin.hofRep = false;
		return true;
	}
}