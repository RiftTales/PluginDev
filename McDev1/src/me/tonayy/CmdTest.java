package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdTest extends CmdBase {

	public CmdTest(DevTestingPlugin plugin) {

		this.commandName = "Test";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return true;
	}
}