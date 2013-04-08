package bhsgoclub.Oblivion;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.*;

public class OBRegen implements Runnable
{

	public Block block;
    public Oblivion plugin;
    public Material m;
    public OBRegen(Block tochange, Material g, Oblivion p)
    {
        this.block = tochange;
        this.plugin = p;
        this.m = g;
    }
    
    @Override
    public void run()
    {
        //do your stuff here
    	this.block.setType(this.m);
    	
    	//this.player.setExperience(1);
    	//this.player.setLevel(1);
    }
}
