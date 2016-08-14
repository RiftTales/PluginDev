package me.tonayy;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

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
		
		e.setJoinMessage(e.getJoinMessage().replaceAll("tonyboyangie3", "Notch"));
		
	}

}