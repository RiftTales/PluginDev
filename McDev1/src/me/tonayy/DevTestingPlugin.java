package me.tonayy;
import org.bukkit.ChatColor;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
public class DevTestingPlugin extends JavaPlugin{
	public static boolean hofRep = false;
	@Override
	public void onEnable(){
		getServer().getPluginManager().addPermission(new Permission("me.tonayy.cmdPkmngo"));
		
		this.getCommand("hello").setExecutor(new CmdHello());
		this.getCommand("spud").setExecutor(new CmdSpud());
		this.getCommand("hof").setExecutor(new CmdHof());
		this.getCommand("pkmngo").setExecutor(new CmdPkmngo());
		this.getCommand("kek").setExecutor(new CmdKek());
		this.getCommand("stahp").setExecutor(new CmdStahp());
		this.getCommand("showhof").setExecutor(new CmdShowhof());
		this.getCommand("lolz").setExecutor(new CmdLolz());
		this.getCommand("tony").setExecutor(new CmdTony());
		this.getCommand("untony").setExecutor(new CmdUntony());
		this.getCommand("sudocmd").setExecutor(new CmdSudocmd());
		this.getCommand("sudo").setExecutor(new CmdSudo());
		
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
		
		
		new DevTestingListener(this);
	}
}