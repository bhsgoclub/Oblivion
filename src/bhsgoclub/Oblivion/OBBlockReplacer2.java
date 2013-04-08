package bhsgoclub.Oblivion;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Item;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.*;

public class OBBlockReplacer2 implements Runnable
{

    public Oblivion plugin;
    public Material mat;
    public Block block;
    public OBBlockReplacer2(Oblivion p, Block b)
    {
        this.plugin = p;
        this.block = b;
        this.mat = b.getType();
    }
    

    public void sendGlobalBlockChange(Location loc, Material type, byte dat)
    {
    	 for (Player player : Bukkit.getServer().getOnlinePlayers())
         {
    		 player.sendBlockChange(loc, type, dat);
         }
    }
    
    @Override
    public void run()
    {
    	sendGlobalBlockChange(this.block.getLocation(), this.mat, this.block.getData());
    	//this.block.setType(this.mat);
    }
}
