package me.tonayy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class CmdSpud implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player)sender;
			p.setHealth(0.0);
			p.sendMessage(ChatColor.DARK_RED + "Team Rocket Strikes Again!");
			return true;
		}
		return false;
	}
}