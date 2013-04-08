package bhsgoclub.Oblivion;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class OBBolt implements Runnable
{

    public Oblivion plugin;
    public Location loc;
    public Player player;
    public OBBolt(Legends p, Location l, Player pl)
    {
        this.plugin = p;
        this.loc = l;
        this.player = pl;
    }
    
    @Override
    public void run()
    {
    	this.player.getWorld().strikeLightning(this.loc);
    }
}
