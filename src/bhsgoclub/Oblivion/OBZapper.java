package bhsgoclub.Oblivion;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class OBZapper implements Runnable
{

    public Oblivion plugin;
    public Block ee;
    public OBPlayerListener sender;
    public Player pe;
    public OBZapper(Oblivion p, Block e, OBPlayerListener sender, Player pe)
    {
        this.plugin = p;
        this.ee = e;
        this.sender = sender;
        this.pe = pe;
    }
    
    @Override
    public void run()
    {
    	this.sender.zapBlock(this.ee, this.pe, 20);
    }
}
