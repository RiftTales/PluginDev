package me.tonayy;

import java.util.List;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.permissions.PermissionAttachment;

public class DevTestingListener implements Listener {

	public DevTestingPlugin plugin;

	public DevTestingListener(DevTestingPlugin plugin) {

		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	private void addPermissionAttachment(Player p) {
		plugin.attachments.put(p.getUniqueId(), p.addAttachment(plugin));
	}

	private void removePermissionAttachment(Player p) {

		UUID uuid = p.getUniqueId();
		if (plugin.attachments.containsKey(uuid)) {

			PermissionAttachment attachment = plugin.attachments.get(uuid);
			p.removeAttachment(attachment);
			plugin.attachments.remove(uuid);
		}
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {

		String message = e.getMessage().toLowerCase();
		if (plugin.msgReps.containsKey(message)) {
			e.setMessage(plugin.msgReps.get(message));
		}
		else {

			String[] words = message.split(" ");
			for (int i = 0; i < words.length; ++i) {
				if (plugin.wordReps.containsKey(words[i])) {
					words[i] = plugin.wordReps.get(words[i]);
				}
			}
			e.setMessage(String.join(" ", words));
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {

		Player p = e.getPlayer();
		String name = p.getName();

		removePermissionAttachment(p);

		if (name.equalsIgnoreCase("tonyboyangie3")) {
			e.setQuitMessage(ChatColor.RED + "Val has been terminated!");
		}
		else if (name.equalsIgnoreCase("bsparkz")) {
			e.setQuitMessage(ChatColor.DARK_GREEN + "Our favorite hero Spud has left us forever :(");
		}
		else if (name.equalsIgnoreCase("lukecreative") || name.equalsIgnoreCase("lukesurvival")) {
			e.setQuitMessage(ChatColor.LIGHT_PURPLE + "Byee Luke");
		}
		else if (name.equalsIgnoreCase("b1oodwing")) {
			e.setQuitMessage(ChatColor.BLUE + "Chris is gone");
		}
		else if (name.equalsIgnoreCase("sc_pikachu")) {
			e.setQuitMessage(ChatColor.GRAY + "The Pikachu broke free!");
		}
		else if(name.equalsIgnoreCase("general_jaxter")) {
			e.setQuitMessage(e.getQuitMessage().replaceAll("General_Jaxter", "Jax"));
		}
	}

	@EventHandler
	public void onPlayerKick(PlayerKickEvent e) {

		removePermissionAttachment(e.getPlayer());
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {

		Player p = e.getPlayer();
		String name = p.getName();
		if (name.equalsIgnoreCase("tonyboyangie3")) {

			e.setJoinMessage(ChatColor.DARK_RED + "Beware! Val has entered the game.");
			p.setDisplayName(ChatColor.DARK_RED + "Val");
		}
		else if (name.equalsIgnoreCase("bsparkz")) {

			e.setJoinMessage(ChatColor.GREEN + "Spud is here to save the day!");
			p.setDisplayName(ChatColor.GREEN + "Spud");
		}
		else if (name.equalsIgnoreCase("lukecreative") || name.equalsIgnoreCase("lukesurvival")) {
			e.setJoinMessage(ChatColor.DARK_PURPLE + "Yay! Luke is here!");
		}
		else if (name.equalsIgnoreCase("b1oodwing")) {
			e.setJoinMessage(ChatColor.BLUE + "Hey there Chris! You're a Awesome..");
		}
		else if (name.equalsIgnoreCase("sc_pikachu")) {

			e.setJoinMessage(ChatColor.YELLOW + "PIKACHU!");
			p.performCommand("kek");
		}
		else if(name.equalsIgnoreCase("general_jaxter")) {

			p.setDisplayName(ChatColor.DARK_AQUA + "JAXTER");
			p.setPlayerListName(ChatColor.DARK_AQUA + "JAXTER");
		}

		addPermissionAttachment(p);
	}

	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent e) {
		e.getPlayer().sendMessage("You dropped something :O");
	}

	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		if(!plugin.allowRain) {
			if (e.toWeatherState()) {
				e.setCancelled(true);
				List<Entity> entities = e.getWorld().getEntities();
				if(entities.size()>0) {
					entities.get(0).getServer().getLogger().info("Weather change to RAIN was cancelled. To allow rain, use /allowrain true.");
				}
			}
		}
	}
}