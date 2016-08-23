package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdRep extends CmdBase {

	public CmdRep(DevTestingPlugin plugin) {

		this.commandName = "Rep";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (2 == args.length) {

			plugin.addWordRep(args[0], args[1]);
			sender.sendMessage("Added rep: \"" + args[0] + "\" -> \"" + args[1] + '\"');
			return true;
		}
		return false;
	}
}