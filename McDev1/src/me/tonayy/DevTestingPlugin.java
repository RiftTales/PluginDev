package me.tonayy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
public class DevTestingPlugin extends JavaPlugin {
	public static boolean hofRep = false;
	public static boolean allowRain = false;
	private PluginCommand setupCommand(String name, CommandExecutor executor) {
		
		String permissionName = "me.tonayy.DevTestingPlugin.cmd";
		if(name.length()>0)
			permissionName += name.toUpperCase().charAt(0);
		for(int i = 1; i < name.length(); ++i)
			permissionName += name.toLowerCase().charAt(i);
		
		PluginCommand c = this.getCommand(name.toLowerCase());
		getServer().getPluginManager().addPermission(new Permission(permissionName));
		c.setExecutor(executor);
		c.setPermission(permissionName);
		c.setPermissionMessage(
				ChatColor.DARK_RED+"You do not have permission to use this. ("+permissionName+')');
		
		return c;
		
	}
	
	@Override
	public void onEnable(){
		
		// Setup Commands
		this.setupCommand("hello", new CmdHello());
		this.setupCommand("spud", new CmdSpud());
		this.setupCommand("hof", new CmdHof());
		this.setupCommand("pkmngo", new CmdPkmngo());
		this.setupCommand("kek", new CmdKek());
		this.setupCommand("stahp", new CmdStahp());
		this.setupCommand("showhof", new CmdShowhof());
		this.setupCommand("lolz", new CmdLolz());
		this.setupCommand("tony", new CmdTony());
		this.setupCommand("untony", new CmdUntony());
		this.setupCommand("sudocmd", new CmdSudocmd());
		this.setupCommand("sudo", new CmdSudo());
		this.setupCommand("allowrain", new CmdAllowrain());
		this.setupCommand("giveperm", new CmdGiveperm());
		this.setupCommand("takeperm", new CmdTakeperm());

		// Setup Scheduled Tasks
		BukkitScheduler scheduler = getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
            	if(hofRep){
            		getServer().broadcastMessage(ChatColor.AQUA + "Each inductee into the Hall of Fame has dedicated more than a decade to the fields of entertainment, media, and the arts.");
            		getServer().broadcastMessage(ChatColor.AQUA + "Advancing their careers while consistently giving back to the students and the graduates of Full Sail University.");
            	}
            }
        }, 200L, 3600L);
		
		// Setup Event Listeners
		new DevTestingListener(this);
		
	}
}