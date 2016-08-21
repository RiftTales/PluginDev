package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdUntony extends CmdBase {
	
	public CmdUntony(DevTestingPlugin plugin) {
		
		this.commandName = "Untony";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player p = (Player)sender;
			p.setPlayerListName(null);
			return true;
		}
		return false;
	}
}