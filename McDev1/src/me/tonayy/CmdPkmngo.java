package me.tonayy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdPkmngo extends CmdBase {

	public CmdPkmngo(DevTestingPlugin plugin) {

		this.commandName = "Pkmngo";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {

			Player p = (Player)sender;
			if (p.hasPermission(this.permissionName)) {
				p.sendMessage("yes");
			}
			else {
				p.sendMessage("no");
			}
			return true;
		}
		return false;
	}
}