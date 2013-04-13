package bhsgoclub.Oblivion;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class OBProtip implements Runnable
{

    public Oblivion plugin;
    public OBProtip(Oblivion p)
    {
        this.plugin = p;
    }
    
    @Override
    public void run()
    {
        //do your stuff here

    	
    	
    	int ptip = plugin.getCon().getInt("CurrentProtip", 1);
    	
    	
    	if (ptip == 1)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"Got a gray/grey name? Apply on the forums (Link) and receive your citizenship!");
    	}
    	else if (ptip == 2)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"Don't annoy moderators for teleports or items. Their big, scary and have bad tempers.");
    	}
    	else if (ptip == 3)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"Hi. The Server Is run on donations");
    	}
    	else if (ptip == 4)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"Donators get access to a variety of perks! They also receive a private chest in the bank. ");
    	}
    	else if (ptip == 5)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"DO NOT ASK FOR RANK UP...GERR");
    	}
    	else if (ptip == 6)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"Hug a Creeper they need the love.");
    	}
    	else if (ptip == 7)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"Hey and welcome to the new (server name goes here) run by Plasimus");
    	}
    	else if (ptip == 8)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"Need help? Ask a guide! Guides have green names and one is usually on.");
    	}
    	else if (ptip == 9)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"There are many exits from (spawn name).");
    	}
    	else if (ptip == 10)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"Stuck somewhere? Ask sarah for help!");
    	}
    	else if (ptip == 11)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"Use the citadel perk to instantly be teleported to spawn. It can be purchased from Plas.");
    	}
    	else if (ptip == 12)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"Use the music perk to create song detectors! It can be purchased from Plas.");
    	}
    	else if (ptip == 13)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"Want portals? Donators keep the server going and also receive perks!");
    	}
    	else if (ptip == 14)
    	{
    		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Protip]"+ChatColor.YELLOW+"Kill me, and Yes do not go together, trust me.");
    		ptip = 0;
    	}
    	
    	
    	
    	((Oblivion) plugin.getCon()).setProperty("CurrentProtip", ptip+1);
    	
    	 }
}
