package org.royaldev.royalcommands;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigUtil {
	
	static RoyalCommands plugin;
	
	public ConfigUtil(RoyalCommands instance){
		plugin = instance;
	}
	
	public static YamlConfiguration getConfig(String confName){
		if(confName == null) return null;
		File file = new File(plugin.getDataFolder() + File.separator + confName + ".yml");
		if(file.exists()){
			YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
			return conf;
		}
		return null;
	}
	
	public static void saveConfig(YamlConfiguration conf, String confName){
		if(confName == null) return;
		File file = new File(plugin.getDataFolder() + File.separator + confName + ".yml");	
		if(file.exists()){
			try {
				conf.save(file);
			} catch (IOException e) {

			}
		}
	}
	
	public static void loadConfig(String confName){
		if(confName == null) return;
		
		File dataFolder = new File(plugin.getDataFolder().toString());
		File file = new File(plugin.getDataFolder() + File.separator + confName + ".yml");
		
		if(!dataFolder.exists()){
			try {
                boolean success = new File(plugin.getDataFolder().toString()).mkdir();
                if (success) {
                }
            } catch (Exception e) {
            }
		}
		
		if(dataFolder.exists() && !file.exists()){
			try {
                boolean success = false;
                
                file.createNewFile();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
	}
}