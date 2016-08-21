package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdShowhof extends CmdBase {
	
	public CmdShowhof(DevTestingPlugin plugin) {
		
		this.commandName = "Showhof";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		this.plugin.hofRep = true;
		return true;
	}
}