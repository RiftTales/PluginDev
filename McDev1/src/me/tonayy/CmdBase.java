package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdBase implements CommandExecutor {

	public String commandName = "Base";
	public String permissionName = "me.tonayy.DevTestingPlugin.cmdBase";
	public DevTestingPlugin plugin;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}
	
	@Override
	public String toString() {
		return commandName;
	}
}