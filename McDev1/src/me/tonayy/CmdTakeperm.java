package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdTakeperm extends CmdBase {
	
	public CmdTakeperm(DevTestingPlugin plugin) {
		
		this.commandName = "Takeperm";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return true;
	}
}