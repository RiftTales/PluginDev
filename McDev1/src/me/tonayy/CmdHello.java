package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdHello extends CmdBase {
	
	public CmdHello() {
		
		this.commandName = "Hello";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player p = (Player)sender;
			p.sendMessage("Hello there, " + p.getDisplayName() + '!');
			return true;
		}
		return false;
	}
}