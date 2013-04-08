package bhsgoclub.Oblivion;
import net.minecraft.server.EntityPlayer;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.*;

public class OBBino implements Runnable
{

	public Player player;
    public Oblivion plugin;
    public OBBino(Player tochange, Oblivion p)
    {
        this.player = tochange;
        this.plugin = p;
    }
    
    @Override
    public void run()
    {
    	String binoculars = plugin.playerConfig(this.player).getString("Binoculars", "");
    	if (binoculars.equalsIgnoreCase("true"))
    	{
    		EntityPlayer eplayer = ((Player) (Player)this.player).getHandle();
    		plugin.doEffect(eplayer, 2, (float)10.0, 11);
    	}
    	else
    	{
    		//Cancel this?
    		int cancel = plugin.playerConfig(this.player).getInt("BScheduler", -1);
    		Bukkit.getServer().getScheduler().cancelTask(cancel);
    	}
    }
}
	