package com.panjaco.snowballspleef.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.BlockIterator;

import net.md_5.bungee.api.ChatColor;

public class projectileThrow implements Listener {
	
	public Location targetBlockLocation;
	public Block targetBlock;
	
	@EventHandler
	public void onProjectileThrowEvent(ProjectileLaunchEvent event){
		if(event.getEntity() instanceof Snowball){
			
			Bukkit.broadcastMessage("AHAHAHAHA");
			
			Player shooter = (Player) event.getEntity().getShooter();
			
			//A snowball has been thrown
			targetBlock = event.getEntity().getLocation().getBlock();
			targetBlockLocation = event.getEntity().getLocation();
			
			//Bukkit.getServer().getPlayer("iPanja").teleport(event.getEntity().getLocation());
		}
	}
	
	public static List<String> lore;
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event){
		Projectile projectile = event.getEntity();
		
		if(projectile instanceof Snowball){
			
			
			   Snowball snowball = (Snowball)event.getEntity();
			   World world = snowball.getWorld();
			   Player p = (Player) snowball.getShooter();
			   BlockIterator bi = new BlockIterator(world, snowball.getLocation().toVector(), snowball.getVelocity().normalize(), 0, 4);
			   Block hit = null;
			   
			   while(bi.hasNext()){
				   hit = bi.next();
				   if(hit.getTypeId()!=0){
					   break;
				   }
			   }
			   
				ItemStack comparisonSpleefBlock = new ItemStack(Material.SNOW_BLOCK);
				setLore(comparisonSpleefBlock, "Spleef Block", ChatColor.RED);
			   
			   int x = snowball.getLocation().getBlockX();
			   int y = snowball.getLocation().getBlockY();
			   int z = snowball.getLocation().getBlockZ();
			   
			   //ItemStack hitBlock = (ItemStack) hit;
			   
			   if(hit.getType() == Material.SNOW_BLOCK){
				   hit.setType(Material.AIR);
			   }
			   
			
		}else{
			Bukkit.broadcastMessage("Some other projectile has hit something");
		}
		
	}
	
	public ItemStack setName(ItemStack itemStack, String name){
        ItemMeta m = itemStack.getItemMeta();
        m.setDisplayName(name);
        itemStack.setItemMeta(m);
        return itemStack;
    }
	
	public static ItemStack setLore(ItemStack itemStack, String name, ChatColor chatColor){
		
		ItemMeta im = itemStack.getItemMeta();
		
		im.setDisplayName(chatColor + name);
		
		lore = im.getLore();
		
		im.setLore(lore);
		
		itemStack.setItemMeta(im);
		
		return itemStack;
	}
	
}
