package me.tonayy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
public class CmdHof implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		sender.getServer().broadcastMessage(ChatColor.GRAY + "Each inductee into the Hall of Fame has dedicated more than a decade to the fields of entertainment, media, and the arts.");
		sender.getServer().broadcastMessage(ChatColor.GRAY + "Advancing their careers while consistently giving back to the students and the graduates of Full Sail University.");
		return true;
	}
}