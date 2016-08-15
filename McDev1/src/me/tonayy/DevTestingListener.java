package me.tonayy;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
		
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		
		String name = e.getPlayer().getName();
		if (name.equalsIgnoreCase("tonyboyangie3")) {
			//e.setQuitMessage(e.getQuitMessage().replaceFirst("tonyboyangie3", "Notch"));
			e.getPlayer().getServer().broadcastMessage(ChatColor.RED + "Val has been terminated!");
		}
		else if (name.equalsIgnoreCase("BSparkz")) {
			//e.setQuitMessage(e.getQuitMessage().replaceFirst("BSparkz", "Nobody"));
			e.getPlayer().getServer().broadcastMessage(ChatColor.DARK_GREEN + "Our favorite hero Spud has left us forever :(");
		}
		else if (name.equalsIgnoreCase("LukeCreative") || name.equalsIgnoreCase("LukeSurvival")) {
			e.getPlayer().getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "Byee Luke");
		}
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		
		String name = e.getPlayer().getName();
		if (name.equalsIgnoreCase("tonyboyangie3")) {
			//e.setJoinMessage(e.getJoinMessage().replaceFirst("tonyboyangie3", "Notch"));
			e.getPlayer().getServer().broadcastMessage(ChatColor.DARK_RED + "Beware! Val has entered the game.");
			e.getPlayer().setDisplayName(ChatColor.DARK_RED + "Val");
		}
		else if (name.equalsIgnoreCase("BSparkz")) {
			//e.setJoinMessage(e.getJoinMessage().replaceFirst("BSparkz", "Nobody"));
			e.getPlayer().getServer().broadcastMessage(ChatColor.GREEN + "Spud is here to save the day!");
			e.getPlayer().setDisplayName(ChatColor.GREEN + "Spud");
		}
		else if (name.equalsIgnoreCase("LukeCreative") || name.equalsIgnoreCase("LukeSurvival")) {
			e.getPlayer().getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Yay! Luke is here!");
		}
		
	}

}