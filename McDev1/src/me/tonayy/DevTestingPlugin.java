package me.tonayy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class DevTestingPlugin extends JavaPlugin {

	public boolean hofRep = false;
	public boolean allowRain = true;
	public DevTestingListener listener;
	public List<DTPermCont> permConts;
	public HashMap<UUID, PermissionAttachment> attachments = new HashMap<UUID, PermissionAttachment>();
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

	public PermissionAttachment getPermissionAttachment(Player p) {

		if (attachments.containsKey(p.getUniqueId())) {
			return attachments.get(p);
		}
		return null;
	}

	public void addMsgRep(String original, String replacement) {
		msgReps.put(original.toLowerCase(), replacement.toLowerCase());
	}

	public void addWordRep(String original, String replacement) {
		wordReps.put(original.toLowerCase(), replacement.toLowerCase());
	}

	private HashMap<String, String> getHashMap(Map<String, Object> map) {

		HashMap<String, String> hashmap = new HashMap<String, String>();
		Set<Entry<String, Object>> entryset = map.entrySet();
		Object[] mapArr = entryset.toArray();
		for (int i = 0; i < mapArr.length; ++i) {

			Entry<?, ?> entry = (Entry<?, ?>)(mapArr[i]);
			hashmap.put((String)entry.getKey(), (String)entry.getValue());
		}
		return hashmap;
	}

	private void readInConfigFile() {

		this.saveDefaultConfig();
		wordReps = getHashMap(this.getConfig().getConfigurationSection("reps.wordreps").getValues(false));
		msgReps = getHashMap(this.getConfig().getConfigurationSection("reps.msgreps").getValues(false));
	}

	private void writeOutConfigFile() {

		this.getConfig().createSection("reps.wordreps", wordReps);
		this.getConfig().createSection("reps.msgreps", msgReps);
		this.saveConfig();
	}

	@Override
	public void onEnable() {

		readInConfigFile();

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
		this.setupCommand(new CmdGiveperm(this));
		this.setupCommand(new CmdTakeperm(this));

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

		writeOutConfigFile();
		attachments.clear();
		wordReps.clear();
		msgReps.clear();
	}
}