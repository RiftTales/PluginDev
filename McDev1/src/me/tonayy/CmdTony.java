package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdTony implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player)sender;
			p.setPlayerListName(p.getDisplayName());
			return true;
		}
		return false;
	}
}