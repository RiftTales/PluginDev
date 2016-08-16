package me.tonayy;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class CmdSudo implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length < 2) return false;
		Player p = sender.getServer().getPlayer(args[0]);
		if ( null == p ) return false;
		String msg = args[1];
		for (int i = 2; i < args.length; ++i)
			msg += " " + args[i];
		p.chat(msg);
		return true;
	}
}