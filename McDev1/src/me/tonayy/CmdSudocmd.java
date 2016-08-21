package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdSudocmd extends CmdBase {
	
	public CmdSudocmd(DevTestingPlugin plugin) {
		
		this.commandName = "Sudocmd";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (args.length < 2) return false;
		
		Player p = sender.getServer().getPlayer(args[0]);
		if (null == p) return false;
		
		String command = args[1];
		for (int i = 2; i < args.length; ++i)
			command += " " + args[i];
		
		return p.performCommand(command);
	}
}