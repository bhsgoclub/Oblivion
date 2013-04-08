/*
package bhsgoclub.Oblivion;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.*;

public class OrbDeleter implements Runnable
{

    public Oblivion plugin;
    public OrbDeleter(Oblivion p)
    {
        this.plugin = p;
    }
    
    @Override
    public void run()
    {
    	
    	List <World> world = Bukkit.getServer().getWorlds();
    	
    	int w;
    	for (w=0; w < world.size(); w++)
		{
    		
	    	List<Entity> entities = world.get(w).getEntities();
			 int o;
			 for (o=0; o < entities.size(); o++)
			 {
				 Entity entity = entities.get(o);
				 
				 if (entity instanceof ExperienceOrb)
				 {
					// entity.remove();
					 entity.setFireTicks(300);
					 entity.remove();
					 
				 }
			 }
		 }
    }
}
*/