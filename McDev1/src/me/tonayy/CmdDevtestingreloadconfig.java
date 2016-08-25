package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdDevtestingreloadconfig extends CmdBase {

	public CmdDevtestingreloadconfig(DevTestingPlugin plugin) {

		this.commandName = "Devtestingreloadconfig";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		plugin.reloadConfigFile();
		sender.sendMessage("Config Reloaded");
		return true;
	}
}