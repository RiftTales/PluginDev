package me.tonayy;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
public class CmdAllowrain implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (args.length > 0) {
			String arg = args[0].toLowerCase();
			if(arg.equalsIgnoreCase("true") ||arg.equalsIgnoreCase("1") ||arg.equalsIgnoreCase("on") ){
				DevTestingPlugin.allowRain = true;
				sender.sendMessage("Raining is enabled.");
				return true;
			}
			else if(arg.equalsIgnoreCase("false") ||arg.equalsIgnoreCase("0") ||arg.equalsIgnoreCase("off") ){
				DevTestingPlugin.allowRain = false;
				sender.sendMessage("Raining is disabled.");
				return true;
			}
		}
		return false;
	}
}