package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdGiveperm extends CmdBase {
	
	public CmdGiveperm() {
		
		this.commandName = "Giveperm";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return true;
	}
}