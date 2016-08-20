package me.tonayy;

import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class DevTestingPlugin extends JavaPlugin {

	public static boolean hofRep = false;
	public static boolean allowRain = false;
	private PluginCommand setupCommand(CmdBase command) {

		PluginCommand c = this.getCommand(command.commandName.toLowerCase());
		getServer().getPluginManager().addPermission(new Permission(command.permissionName));
		c.setExecutor(command);
		c.setPermission(command.permissionName);
		c.setPermissionMessage(ChatColor.DARK_RED + "You do not have permission to use this. (" + command.permissionName + ')');
		
		return c;
	}
	
	@Override
	public void onEnable() {
		
		this.setupCommand(new CmdHello());
		this.setupCommand(new CmdSpud());
		this.setupCommand(new CmdHof());
		this.setupCommand(new CmdPkmngo());
		this.setupCommand(new CmdKek());
		this.setupCommand(new CmdStahp());
		this.setupCommand(new CmdShowhof());
		this.setupCommand(new CmdLolz());
		this.setupCommand(new CmdTony());
		this.setupCommand(new CmdUntony());
		this.setupCommand(new CmdSudocmd());
		this.setupCommand(new CmdSudo());
		this.setupCommand(new CmdAllowrain());
		this.setupCommand(new CmdGiveperm());
		this.setupCommand(new CmdTakeperm());

		BukkitScheduler scheduler = getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
            	if (hofRep) {
            		
            		getServer().broadcastMessage(ChatColor.AQUA + "Each inductee into the Hall of Fame has dedicated more than a decade to the fields of entertainment, media, and the arts.");
            		getServer().broadcastMessage(ChatColor.AQUA + "Advancing their careers while consistently giving back to the students and the graduates of Full Sail University.");
            	}
            }
        }, 200L, 3600L);
		
		new DevTestingListener(this);
	}
}