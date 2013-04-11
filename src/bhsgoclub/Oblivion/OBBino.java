package bhsgoclub.Oblivion;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_5_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

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
    		EventHandler eplayer = (EventHandler) ((CraftPlayer) (CraftPlayer)this.player).getHandle();
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
	