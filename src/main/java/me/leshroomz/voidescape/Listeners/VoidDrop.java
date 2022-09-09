package me.leshroomz.voidescape.Listeners;

import com.earth2me.essentials.spawn.EssentialsSpawn;
import me.leshroomz.voidescape.Util.ConfigUtil;
import me.leshroomz.voidescape.Voidescape;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class VoidDrop implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void voidDrop(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            World world = e.getEntity().getWorld();
            if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID) && ConfigUtil.checkWorld(world.getName())) {
                e.setCancelled(true);
                p.setInvulnerable(true);
                if(Voidescape.essentialsFound){
                    EssentialsSpawn ess = (EssentialsSpawn) Bukkit.getPluginManager().getPlugin("EssentialsSpawn");
                    p.teleport(ess.getSpawn("default"));
                } else {
                    p.teleport(world.getSpawnLocation());
                }
                new BukkitRunnable() {
                    @Override
                    public void run(){
                        p.setInvulnerable(false);
                    }
                }.runTaskLater(Voidescape.getPlugin(), 20);

            }
        }
    }
}
