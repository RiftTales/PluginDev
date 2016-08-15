package me.tonayy;

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
	public void onPlayerJoin(PlayerJoinEvent e) {
		
		String name = e.getPlayer().getName();
		if (name.equalsIgnoreCase("tonyboyangie3")) {
			e.setJoinMessage(e.getJoinMessage().replaceFirst("tonyboyangie3", "Notch"));
		}
		else if (name.equalsIgnoreCase("BSparkz")) {
			e.setJoinMessage(e.getJoinMessage().replaceFirst("BSparkz", "Nobody"));
		}
		
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		
		String name = e.getPlayer().getName();
		if (name.equalsIgnoreCase("tonyboyangie3")) {
			e.setQuitMessage(e.getQuitMessage().replaceFirst("tonyboyangie3", "Notch"));
		}
		else if (name.equalsIgnoreCase("BSparkz")) {
			e.setQuitMessage(e.getQuitMessage().replaceFirst("BSparkz", "Nobody"));
		}
		
	}

}