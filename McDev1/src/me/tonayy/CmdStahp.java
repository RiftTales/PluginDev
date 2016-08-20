package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdStahp extends CmdBase {
	
	public CmdStahp() {
		
		this.commandName = "Stahp";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		DevTestingPlugin.hofRep = false;
		return true;
	}
}