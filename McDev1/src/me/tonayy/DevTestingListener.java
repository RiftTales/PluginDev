package me.tonayy;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class DevTestingListener implements Listener {

	public DevTestingListener(DevTestingPlugin plugin) {
		
		plugin.getServer().getPluginManager().registerEvents(this,plugin);
		
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		
		String message = e.getMessage();
		if(message.equalsIgnoreCase("hey")){
			
			e.setMessage("KONNICHIWA");
			
		}

		String[] words = e.getMessage().split(" ");
		for (String s : words) {
			if(s.equalsIgnoreCase("yes")) {
				s = "nOpE";
			}
			else if (s.equalsIgnoreCase("the")) {
				s = "tEh";
			}
			else if (s.equalsIgnoreCase("what")) {
				s = "wAhT";
			}
			else if (s.equalsIgnoreCase("nerd")) {
				s = "nUbB";
			}
			else if (s.equalsIgnoreCase("nerds")) {
				s = "nUbBz";
			}
			else if (s.equalsIgnoreCase("fuck")) {
				s = "fUdGe";
			}
		}
		e.setMessage(String.join(" ", words).toLowerCase());
		
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		
		String name = e.getPlayer().getName();
		if (name.equalsIgnoreCase("tonyboyangie3")) {
			//e.setQuitMessage(e.getQuitMessage().replaceFirst("tonyboyangie3", "Notch"));
			//e.getPlayer().getServer().broadcastMessage(ChatColor.RED + "Val has been terminated!");
			e.setQuitMessage(ChatColor.RED + "Val has been terminated!");
		}
		else if (name.equalsIgnoreCase("bsparkz")) {
			//e.setQuitMessage(e.getQuitMessage().replaceFirst("BSparkz", "Nobody"));
			//e.getPlayer().getServer().broadcastMessage(ChatColor.DARK_GREEN + "Our favorite hero Spud has left us forever :(");
			e.setQuitMessage(ChatColor.DARK_GREEN + "Our favorite hero Spud has left us forever :(");
		}
		else if (name.equalsIgnoreCase("lukecreative") || name.equalsIgnoreCase("lukesurvival")) {
			//e.getPlayer().getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "Byee Luke");
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
			//e.setJoinMessage(e.getJoinMessage().replaceFirst("tonyboyangie3", "Notch"));
			//e.getPlayer().getServer().broadcastMessage(ChatColor.DARK_RED + "Beware! Val has entered the game.");
			e.setJoinMessage(ChatColor.DARK_RED + "Beware! Val has entered the game.");
			e.getPlayer().setDisplayName(ChatColor.DARK_RED + "Val");
		}
		else if (name.equalsIgnoreCase("bsparkz")) {
			//e.setJoinMessage(e.getJoinMessage().replaceFirst("BSparkz", "Nobody"));
			//e.getPlayer().getServer().broadcastMessage(ChatColor.GREEN + "Spud is here to save the day!");
			e.setJoinMessage(ChatColor.GREEN + "Spud is here to save the day!");
			e.getPlayer().setDisplayName(ChatColor.GREEN + "Spud");
		}
		else if (name.equalsIgnoreCase("lukecreative") || name.equalsIgnoreCase("lukesurvival")) {
			//e.getPlayer().getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Yay! Luke is here!");
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
	public void onPlayerDropItemEvent(PlayerDropItemEvent e) {
		e.getPlayer().sendMessage("You dropped something :O");
	}
}