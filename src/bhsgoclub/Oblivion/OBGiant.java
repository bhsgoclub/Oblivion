package bhsgoclub.Oblivion;


import java.util.List;

import org.bukkit.Effect;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class OBGiant implements Runnable
{

    public Oblivion plugin;
    public Monster ai_player;
    public int state;
    
    public OBGiant(Oblivion p, Monster ai)
    {
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
    	//Kaboom!
    	
    	ai_player.getWorld().playEffect(ai_player.getLocation(), Effect.SMOKE, 3);
    	ai_player.getWorld().createExplosion(ai_player.getLocation(), 0);
		
    	List<Entity> list = ai_player.getNearbyEntities(10, 10, 10);
    	
    	int i;
    	for (i=0; i < list.size(); i++)
    	{
    		Entity e = list.get(i);
    		if (e instanceof LivingEntity&&e.getLocation().distance(ai_player.getLocation()) <=8 )
    		{
    			if (e instanceof Player || e instanceof Player)
    			{
    				LivingEntity en = (LivingEntity)e;
    				en.damage(10, ai_player);
    			}
    		}
    	}
    	
    	boolean has_target = false;
    	
    	EntityDamageEvent ev = ai_player.getLastDamageCause();
		if (ev instanceof EntityDamageByEntityEvent)
		{
    		EntityDamageByEntityEvent  e = (EntityDamageByEntityEvent) ev;
    		Entity last_dmg = e.getDamager();
    		if (last_dmg != null)
    		{
    			if (last_dmg instanceof Arrow)
    				last_dmg = ((Arrow) last_dmg).getShooter();
    			
    			if (last_dmg instanceof LivingEntity)
    			{
		    		if (!last_dmg.isDead() && (last_dmg.getLocation().distance(ai_player.getLocation()) < 10)&&last_dmg.getEntityId() != ai_player.getEntityId())
		    		{
		    			//Check distance between player
	
		    				if (last_dmg.getEntityId() == ai_player.getEntityId())
		    					return;
		    				
		    				has_target = true;
			    			ai_player.setTarget((LivingEntity) last_dmg);
		    			
		    		}
		    		else if (!last_dmg.isDead() && (last_dmg.getLocation().distance(ai_player.getLocation()) < 20)&&last_dmg.getEntityId() != ai_player.getEntityId())
		    		{
		    			has_target = true;
		    			ai_player.teleport(last_dmg.getLocation());
		    			ai_player.setTarget((LivingEntity) last_dmg);
		    		}
    			}
    		}
		}
		
		if (!has_target)
		{

	    	list = ai_player.getNearbyEntities(25, 25, 25);
	    	Player closest = null;
	    	float closest_dist = 100;
	
	    	
	    	for (i=0; i < list.size(); i++)
	    	{
	    		Entity e = list.get(i);
	    		if (e instanceof LivingEntity&&e.getLocation().distance(ai_player.getLocation()) <=8 )
	    		{
	    			if (e instanceof Player || e instanceof Player)
	    			{
	    				Player en = (Player)e;
	    				
	    				if (ai_player.getLocation().distance(en.getLocation())<closest_dist)
	    				{
	    					closest_dist = (float) ai_player.getLocation().distance(en.getLocation());
	    					closest = en;
	    				}
	
	    			}
	    		}
	    	}
	    	
			if (closest != null)
			{
				//ai_player.setLastDamageCause((EntityDamageEvent) closest);
				ai_player.setTarget((LivingEntity) closest);
			}
			//Get nearby entities?
		}
		
		
    	
    }
}
