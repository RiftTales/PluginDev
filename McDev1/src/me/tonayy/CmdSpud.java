package me.tonayy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdSpud extends CmdBase {
	
	public CmdSpud(DevTestingPlugin plugin) {
		
		this.commandName = "Spud";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player p = (Player)sender;
			p.setHealth(0.0);
			p.sendMessage(ChatColor.DARK_RED + "Team Rocket Strikes Again!");
			return true;
		}
		return false;
	}
}