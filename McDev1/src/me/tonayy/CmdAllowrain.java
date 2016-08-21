package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdAllowrain extends CmdBase {
	
	public CmdAllowrain(DevTestingPlugin plugin) {
		
		this.commandName = "Allowrain";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (args.length > 0) {
			
			String arg = args[0];
			if (arg.equalsIgnoreCase("true") || arg.equalsIgnoreCase("1") || arg.equalsIgnoreCase("on") ) {
				
				this.plugin.allowRain = true;
				sender.sendMessage("Raining is enabled.");
				return true;
			}
			else if (arg.equalsIgnoreCase("false") || arg.equalsIgnoreCase("0") || arg.equalsIgnoreCase("off") ) {
				
				this.plugin.allowRain = false;
				sender.sendMessage("Raining is disabled.");
				return true;
			}
		}
		return false;
	}
}