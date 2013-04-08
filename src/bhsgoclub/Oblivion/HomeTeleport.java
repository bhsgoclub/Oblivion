package bhsgoclub.Oblivion;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.*;

public class HomeTeleport implements Runnable
{

    public Oblivion plugin;
    public Player player;
    public HomeTeleport(Oblivion p, Player t)
    {
        this.plugin = p;
        this.player = t;
    }
    
    @Override
    public void run()
    {
        //do your stuff here
    	this.player.teleport(this.player.getBedSpawnLocation().add(0, 1, 0));
    	
    	plugin.playerConfig(player).setProperty("lastTeleportTiming", String.valueOf(System.currentTimeMillis()));

    }
}
