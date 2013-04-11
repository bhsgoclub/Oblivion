package bhsgoclub.Oblivion;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CitadelTeleport implements Runnable
{

    public Oblivion plugin;
    public Player player;
    public CitadelTeleport(Oblivion p, Player t)
    {
        this.plugin = p;
        this.player = t;
    }
    
    @Override
    public void run()
    {
        //do your stuff here
    	this.player.teleport(new Location(this.player.getWorld(), 66, 80, 263));
    	
    	((ConfigUtil) plugin.playerConfig(player)).setProperty("lastCitadelTiming", String.valueOf(System.currentTimeMillis()));

    }
}
