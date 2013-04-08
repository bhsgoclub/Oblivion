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

public class OBTimeChanger implements Runnable
{

    public Oblivion plugin;

   World the_world;
   private long time_chage;
    
    public OBTimeChanger(Oblivion p, long time, World w)
    {
        this.plugin = p;
        this.time_chage = time;
        this.the_world = w;
    }
    
    @Override
    public void run()
    {
    	this.the_world.setTime(time_chage);
    }
}
