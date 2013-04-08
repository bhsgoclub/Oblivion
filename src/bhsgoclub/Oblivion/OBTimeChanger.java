package bhsgoclub.Oblivion;
import org.bukkit.World;

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
