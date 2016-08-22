package me.tonayy;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdKek extends CmdBase {

	public CmdKek(DevTestingPlugin plugin) {

		this.commandName = "Kek";
		this.permissionName = "me.tonayy.DevTestingPlugin.cmd" + commandName;
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {

			Player p = (Player)sender;
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			p.setFlying(false);
			p.teleport(new Location(p.getWorld(),0.0,300.0,0.0));
		}
		return true;
	}
}