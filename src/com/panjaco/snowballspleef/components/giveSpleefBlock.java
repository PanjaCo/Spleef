package com.panjaco.snowballspleef.components;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.panjaco.snowballspleef.events.projectileThrow;

import net.md_5.bungee.api.ChatColor;

public class giveSpleefBlock implements CommandExecutor {

	ItemStack spleefBlock = new ItemStack(Material.SNOW_BLOCK, 64);

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		projectileThrow.setLore(spleefBlock, "Spleef Block", ChatColor.RED);
		
		if(sender instanceof Player){
			sender.sendMessage(ChatColor.GREEN + "Here is a spleef block!");
			sender.sendMessage(ChatColor.GREEN + "You can destroy it by throwing a snowball at it!");
			
			((Player) sender).getInventory().addItem(spleefBlock);
			
		}else{
			
		}
		
		
		return true;
	}

}
