package bhsgoclub.Oblivion;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class OBBot implements Runnable{

	 public Oblivion plugin;

	   String message;
	   Player p;
	   public OBBot(Oblivion p, String message, Player time)
	    {
	    	this.plugin = p;
	        this.message = message;
	        this.p = time;
	    }
	    
	    @Override
	    public void run()
	    {
	    	String[] messages = message.split(":");
	    	int m = plugin.random_num(messages.length, 1);
	    	
	    	
	    	//Find a slang term for their name
	    	String name = p.getName();
	    	
	    	if (!plugin.playerConfig(p).getString("ChatBot.Name", "").equalsIgnoreCase(""))
	    		name = plugin.playerConfig(p).getString("ChatBot.Name", "");
	    		
	    	String msg = messages[m-1];
	    	msg = msg.replace("<name>", name);
	    	
	    	p.sendMessage(ChatColor.WHITE+"[o] "+ChatColor.GREEN+"[h][0:0:0] Sarah"+ChatColor.WHITE+": " + msg);
	    }
	    
}
