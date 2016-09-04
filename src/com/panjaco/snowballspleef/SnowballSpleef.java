package com.panjaco.snowballspleef;

import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.panjaco.snowballspleef.components.giveSpleefBlock;
import com.panjaco.snowballspleef.events.projectileThrow;

public class SnowballSpleef extends JavaPlugin{
	
	public static Plugin plugin;
	
	public void onEnable(){
		PluginDescriptionFile descFile = getDescription();
		Logger logger = getLogger();
		logger.info("[Snowball Spleef] Enabled");
		
		
		//Register commands
		getCommand("spleefblock").setExecutor(new giveSpleefBlock());
		
		//Register Listeners(EventHandlers)
		getServer().getPluginManager().registerEvents(new projectileThrow(), this);
	}
	
	public void onDisable(){
		PluginDescriptionFile descFile = getDescription();
		Logger logger = getLogger();
		logger.info("[Snowball Spleef] Disabled");
	}
	
}
