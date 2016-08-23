package me.tonayy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class DevTestingPlugin extends JavaPlugin {

	public boolean hofRep = false;
	public boolean allowRain = true;
	public DevTestingListener listener;
	public HashMap<String, String> wordReps = new HashMap<String, String>();
	public HashMap<String, String> msgReps = new HashMap<String, String>();

	private PluginCommand setupCommand(CmdBase command) {

		PluginCommand c = this.getCommand(command.commandName.toLowerCase());
		getServer().getPluginManager().addPermission(new Permission(command.permissionName));
		c.setExecutor(command);
		c.setPermission(command.permissionName);
		c.setPermissionMessage(ChatColor.DARK_RED + "You do not have permission to use this. (" + command.permissionName + ')');

		return c;
	}

	public void addMsgRep(String original, String replacement) {

		msgReps.put(original.toLowerCase(), replacement.toLowerCase());
		this.getConfig().createSection("reps.msgreps", msgReps);
		this.saveConfig();
	}

	public void addWordRep(String original, String replacement) {

		wordReps.put(original.toLowerCase(), replacement.toLowerCase());
		this.getConfig().createSection("reps.wordreps", wordReps);
		this.saveConfig();
	}

	private HashMap<String, String> getHashMap(Map<String, Object> map) {

		HashMap<String, String> hashmap = new HashMap<String, String>();
		Object[] mapArr = map.entrySet().toArray();
		for (int i = 0; i < mapArr.length; ++i) {

			Entry<?, ?> entry = (Entry<?, ?>)(mapArr[i]);
			hashmap.put((String)entry.getKey(), (String)entry.getValue());
		}
		return hashmap;
	}

	private void readConfigFile() {

		this.saveDefaultConfig();
		wordReps = getHashMap(this.getConfig().getConfigurationSection("reps.wordreps").getValues(false));
		msgReps = getHashMap(this.getConfig().getConfigurationSection("reps.msgreps").getValues(false));
	}

	private void writeConfigFile() {

		this.getConfig().createSection("reps.wordreps", wordReps);
		this.getConfig().createSection("reps.msgreps", msgReps);
		this.saveConfig();
	}

	@Override
	public void onEnable() {

		readConfigFile();

		this.setupCommand(new CmdHello(this));
		this.setupCommand(new CmdSpud(this));
		this.setupCommand(new CmdHof(this));
		this.setupCommand(new CmdPkmngo(this));
		this.setupCommand(new CmdKek(this));
		this.setupCommand(new CmdStahp(this));
		this.setupCommand(new CmdShowhof(this));
		this.setupCommand(new CmdLolz(this));
		this.setupCommand(new CmdTony(this));
		this.setupCommand(new CmdUntony(this));
		this.setupCommand(new CmdSudocmd(this));
		this.setupCommand(new CmdSudo(this));
		this.setupCommand(new CmdAllowrain(this));
		this.setupCommand(new CmdRep(this));
		this.setupCommand(new CmdDevtestingreloadconfig(this));

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

		listener = new DevTestingListener(this);
	}

	@Override
	public void onDisable() {

		writeConfigFile();
		wordReps.clear();
		msgReps.clear();
	}

	public void reloadConfig() {

		wordReps.clear();
		msgReps.clear();
		readConfigFile();
	}
}