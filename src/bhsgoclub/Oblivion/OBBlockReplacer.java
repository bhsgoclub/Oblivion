package bhsgoclub.Oblivion;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class OBBlockReplacer implements Runnable
{

    public Oblivion plugin;
    public Material mat;
    public Block block;
    public OBBlockReplacer(Oblivion p, Block b)
    {
        this.plugin = p;
        this.block = b;
        this.mat = b.getType();
    }
    
    @Override
    public void run()
    {
    	this.block.setType(this.mat);
    }
}
