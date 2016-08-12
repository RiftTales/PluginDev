package me.tonayy;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
public class DevTestingPlugin extends JavaPlugin{
	public static boolean hofRep = false;
	@Override
	public void onEnable(){
		this.getCommand("hello").setExecutor(new CmdHello());
		this.getCommand("spud").setExecutor(new CmdSpud());
		this.getCommand("hof").setExecutor(new CmdHof());
		this.getCommand("pkmngo").setExecutor(new CmdPkmngo());
		this.getCommand("stahp").setExecutor(new CmdStahp());
		this.getCommand("showhof").setExecutor(new CmdShowhof());
		this.getCommand("lolz").setExecutor(new CmdLolz());
		BukkitScheduler scheduler = getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
            	if(hofRep){
            		getServer().broadcastMessage(ChatColor.AQUA + "Each inductee into the Hall of Fame has dedicated more than a decade to the fields of entertainment, media, and the arts.");
            		getServer().broadcastMessage(ChatColor.AQUA + "Advancing their careers while consistently giving back to the students and the graduates of Full Sail University.");
            	}
            }
        }, 200L, 3600L); // 10 seconds, 3 minutes
		//}, 500L, 200L); // 25 seconds, 10 seconds
	}
}