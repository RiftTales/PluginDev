package me.tonayy;
//import java.util.Collection;

//import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
//import org.bukkit.entity.Player;
public class CmdPkmngo implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		//Server s = sender.getServer();
		//Collection<? extends Player> players = s.getOnlinePlayers();

		if(sender instanceof Player){
			Player p = (Player)sender;
			if(p.hasPermission("me.tonayy.DevTestingPlugin.cmdPkmngo")){
				p.sendMessage("yes");
			}
			else{
				p.sendMessage("no");
			}
			return true;
		}
		
		return false;
	}
}