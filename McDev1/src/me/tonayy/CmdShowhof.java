package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdShowhof extends CmdBase {
	
	public CmdShowhof() {
		
		this.commandName = "Showhof";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		DevTestingPlugin.hofRep = true;
		return true;
	}
}