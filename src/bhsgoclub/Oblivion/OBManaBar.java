package bhsgoclub.Oblivion;
import org.bukkit.entity.Player;

public class OBManaBar implements Runnable
{

	public Player player;
    public Oblivion plugin;
    public OBManaBar(Player tochange, Oblivion p)
    {
        this.player = tochange;
        this.plugin = p;
    }
    
    @Override
    public void run()
    {
        //do your stuff here
    	
    	if (!this.player.isSprinting())
    		this.plugin.gainMana(this.player, 2);
    	
    	//this.player.setExperience(1);
    	//this.player.setLevel(1);
    }
}
