package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdTony extends CmdBase {
	
	public CmdTony(){
		this.commandName = "Tony";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player p = (Player)sender;
			p.setPlayerListName(p.getDisplayName());
			return true;
		}
		return false;
	}
}