package me.tonayy;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class DevTestingListener implements Listener {

	public DevTestingListener(DevTestingPlugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(this,plugin);
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		
		String message = e.getMessage();
		if (message.equalsIgnoreCase("hey")) {
			
			e.setMessage("KONNICHIWA");
			return;
		}
		else if (message.equalsIgnoreCase("we")) {
			
			e.setMessage("We are the crystal gems!");
			return;
		}

		String[] words = e.getMessage().split(" ");
		for (int i = 0; i < words.length; ++i) {
			
			String s = words[i];
			if (s.equalsIgnoreCase("yes")) { words[i] = "nope"; }
			else if (s.equalsIgnoreCase("the")) { words[i] = "teh"; }
			else if (s.equalsIgnoreCase("what")) { words[i] = "waht"; }
			else if (s.equalsIgnoreCase("nerd")) { words[i] = "nubb"; }
			else if (s.equalsIgnoreCase("nerds")) { words[i] = "nubbz"; }
			else if (s.equalsIgnoreCase("fuck")) { words[i] = "fudge"; }
			else if (s.equalsIgnoreCase("tony")) { words[i] = "tonayy"; }
			else if (s.equalsIgnoreCase("my")) { words[i] = "me"; }
			else if (s.equalsIgnoreCase("crap")) { words[i] = "feces"; }
			else if (s.equalsIgnoreCase("shit")) { words[i] = "feces"; }
			else if (s.equalsIgnoreCase("hate")) { words[i] = "love"; }
			else if (s.equalsIgnoreCase("love")) { words[i] = "hate"; }
			else if (s.equalsIgnoreCase("you")) { words[i] = "yuo"; }
			else if (s.equalsIgnoreCase("chris")) { words[i] = "kaneki"; }
			else if (s.equalsIgnoreCase("kyle")) { words[i] = "spud"; }
		}
		e.setMessage(String.join(" ", words).toLowerCase());
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		
		String name = e.getPlayer().getName();
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
	public void onPlayerJoin(PlayerJoinEvent e) {
		
		String name = e.getPlayer().getName();
		if (name.equalsIgnoreCase("tonyboyangie3")) {
			
			e.setJoinMessage(ChatColor.DARK_RED + "Beware! Val has entered the game.");
			e.getPlayer().setDisplayName(ChatColor.DARK_RED + "Val");
		}
		else if (name.equalsIgnoreCase("bsparkz")) {
			
			e.setJoinMessage(ChatColor.GREEN + "Spud is here to save the day!");
			e.getPlayer().setDisplayName(ChatColor.GREEN + "Spud");
		}
		else if (name.equalsIgnoreCase("lukecreative") || name.equalsIgnoreCase("lukesurvival")) {
			e.setJoinMessage(ChatColor.DARK_PURPLE + "Yay! Luke is here!");
		}
		else if (name.equalsIgnoreCase("b1oodwing")) {
			e.setJoinMessage(ChatColor.BLUE + "Hey there Chris! You're a nerd..");
		}
		else if (name.equalsIgnoreCase("sc_pikachu")) {
			
			e.setJoinMessage(ChatColor.YELLOW + "PIKACHU!");
			e.getPlayer().performCommand("kek");
		}
		else if(name.equalsIgnoreCase("general_jaxter")) {
			
			e.getPlayer().setDisplayName(ChatColor.DARK_AQUA + "JAXTER");
			e.getPlayer().setPlayerListName(ChatColor.DARK_AQUA + "JAXTER");
		}
	}

	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent e) {
		if(e.getPlayer().getName().equalsIgnoreCase("b1oodwing")) {
			e.setTo(new Location(e.getPlayer().getWorld(),0,300,0));
		}
	}
	
	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent e) {
		e.getPlayer().sendMessage("You dropped something :O");
	}
	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		if(!DevTestingPlugin.allowRain) {
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