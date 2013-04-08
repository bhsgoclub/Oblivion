package bhsgoclub.Oblivion;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Item;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.*;

public class OBBlockReplacer implements Runnable
{

    public Oblivion plugin;
    public Material mat;
    public Block block;
    public OBBlockReplacer(Oblivion p, Block b)
    {
        this.plugin = p;
        this.block = b;
        this.mat = b.getType();
    }
    
    @Override
    public void run()
    {
    	this.block.setType(this.mat);
    }
}
