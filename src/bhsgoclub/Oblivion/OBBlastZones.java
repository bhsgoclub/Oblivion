package bhsgoclub.Oblivion;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.*;

public class OBBlastZones implements Runnable
{

    public Oblivion plugin;
    public String title;
    public OBBlastZones(Oblivion p, String t)
    {
        this.plugin = p;
        this.title = t;
    }
    
    @Override
    public void run()
    {
        //do your stuff here
    	plugin.getCon().removeProperty("TempMagic."+this.title);
		
		//plugin.getConfig().setProperty("TempMagic", loaded_spells);
    }
}
