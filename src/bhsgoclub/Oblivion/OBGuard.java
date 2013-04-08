package bhsgoclub.Oblivion;


import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

public class OBGuard implements Runnable
{

	public Player player;
    public Oblivion plugin;
    public Monster ai_player;
    public int state;
    
    public OBGuard(Player tochange, Oblivion p, Monster ai)
    {
        this.player = tochange;
        this.plugin = p;
        this.ai_player = ai;
    }
    
    @Override
    public void run()
    {
        //do your stuff here
    	
    	if (this.ai_player.isDead())
    	{
    		return;
    	}

    	if (this.player.isDead())
    	{
    		this.ai_player.setHealth(0);
    		this.ai_player.damage(1000);
    	}
    	else
    	{
    		this.ai_player.setTarget(this.player);
    	}
 	
    	//Who hurt master? D:
    	
    	
    	

    	
    }
}
