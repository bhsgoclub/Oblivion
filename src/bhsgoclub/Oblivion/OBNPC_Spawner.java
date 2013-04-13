package bhsgoclub.Oblivion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.server.v1_5_R2.Packet20NamedEntitySpawn;
import net.minecraft.server.v1_5_R2.Packet29DestroyEntity;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_5_R2.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

public class OBNPC_Spawner implements Runnable
{

    public Oblivion plugin;
    List<Monster> npc_list;
    Map<String, LivingEntity> npc_dict;
    
    public OBNPC_Spawner(Oblivion p)
    {
        this.plugin = p;
        this.npc_dict = new HashMap<String, LivingEntity>();
    }
    
    
    public void run()
    {
    	List<String> NPCS = plugin.getTelepad().getKeys("NPCS");
    	
		if (NPCS!=null)
		{
			int i;
			for (i=0; i < NPCS.size(); i++)
			{
	
					String loc = NPCS.get(i);
					String t = plugin.getTelepad().getString("NPCS"+"."+loc+".Type", "Villager");
					
					try
					{
					if (loc.split(" ").length < 3)
						continue;
					
					LivingEntity piggy = (LivingEntity) this.npc_dict.get(loc);
					if (piggy == null || piggy.isDead())
					{
						//Respawn
						
						//Delete the old piggy
						EntityType type = EntityType.VILLAGER;
						String e = plugin.getTelepad().getString("NPCS"+"."+loc+".Equipment", "0");
						

						/*if (!t.equalsIgnoreCase("wolf"))
						{
							if (piggy != null && piggy.isDead())
							{
								Packet29DestroyEntity p29 = new Packet29DestroyEntity(piggy.getEntityId()); //Must destroy, don't want doubles lololololol
			                    
			                    for (Player p2 : Bukkit.getServer().getOnlinePlayers())
			                    {
			                        ((CraftPlayer) p2).getHandle().netServerHandler.sendPacket(p29);
			                    }
							}
						}*/
						
						Location locat = new Location(Bukkit.getServer().getWorld("world"), Integer.valueOf(loc.split(" ")[0]), Integer.valueOf(loc.split(" ")[1])+2, Integer.valueOf(loc.split(" ")[2]));
						
						//Is there a sign at the loc?
						if (Bukkit.getServer().getWorld("world").getBlockAt(locat).getRelative(0, -2, 0).getType()!=Material.SIGN_POST)
						{
							continue;
						}
						
					
						
						if (t.equalsIgnoreCase("villager"))
						   type = EntityType.VILLAGER;
						else if (t.equalsIgnoreCase("pigzombie"))
							   type = EntityType.PIG_ZOMBIE;
						else if (t.equalsIgnoreCase("zombie"))
							   type = EntityType.ZOMBIE;
						else if (t.equalsIgnoreCase("creeper"))
							   type = EntityType.CREEPER;
						else if (t.equalsIgnoreCase("pig"))
							   type = EntityType.PIG;
						else if (t.equalsIgnoreCase("wolf"))
							   type = EntityType.WOLF;
						else if (t.equalsIgnoreCase("spider"))
							   type = EntityType.SPIDER;
						else if (t.equalsIgnoreCase("skeleton"))
							   type = EntityType.SKELETON;
						
						LivingEntity actual_wolf = Bukkit.getServer().getWorld("world").spawnCreature(locat, type);
	                    
						
						
	                    Packet20NamedEntitySpawn p20 = plugin.packetMaker(actual_wolf, plugin.getTelepad().getString("NPCS"+"."+loc+".Name", "Anonymous"), e);
	                    Packet29DestroyEntity p29 = new Packet29DestroyEntity(actual_wolf.getEntityId()); //Must destroy, don't want doubles lololololol
	                    for (Player p2 : Bukkit.getServer().getOnlinePlayers())
	                    {
	                    	if (!t.equalsIgnoreCase("wolf"))
	                    		((CraftPlayer) p2).getHandle().playerConnection.sendPacket(p29);
	                        ((CraftPlayer) p2).getHandle().playerConnection.sendPacket(p20);
	                    }
	                    
						this.npc_dict.put(loc, actual_wolf);
					}
					else
					{
						
						String e = plugin.getTelepad().getString("NPCS"+"."+loc+".Equipment", "0");
						Packet20NamedEntitySpawn p20 = plugin.packetMaker(piggy, plugin.getTelepad().getString("NPCS"+"."+loc+".Name", "Anonymous"), e);
	                    Packet29DestroyEntity p29 = new Packet29DestroyEntity(piggy.getEntityId()); //Must destroy, don't want doubles lololololol
	                    
	                    for (Player p2 : Bukkit.getServer().getOnlinePlayers())
	                    {
	                    	if (!t.equalsIgnoreCase("wolf"))
	                    		((CraftPlayer) p2).getHandle().playerConnection.sendPacket(p29);
	                    	
	                        ((CraftPlayer) p2).getHandle().playerConnection.sendPacket(p20);
	                    }
						continue;
					}
			}
					catch (Exception e)
					{
						continue;
					}

			}
		}
		else
		{
			System.out.println("No NPC villagers?");
		}
    }
}
