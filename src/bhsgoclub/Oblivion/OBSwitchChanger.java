package bhsgoclub.Oblivion;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class OBSwitchChanger implements Runnable
{

    public Oblivion plugin;
    public Material mat;
    public Block block;
    public OBSwitchChanger(Oblivion p, Block b)
    {
        this.plugin = p;
        this.block = b;
        this.mat = b.getType();
    }
    
    @Override
    public void run()
    {

        byte data = this.block.getData();
        this.block.setData((byte) (data & ~0x8));
        

    }
}
