package me.leshroomz.voidescape;

import com.earth2me.essentials.spawn.EssentialsSpawn;
import lombok.Getter;
import me.leshroomz.voidescape.Listeners.VoidDrop;
import me.leshroomz.voidescape.Util.ConfigUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class Voidescape extends JavaPlugin {

    @Getter
    private static Voidescape plugin;
    @Getter
    private ConfigUtil configuration;

    public static Boolean essentialsFound = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        saveDefaultConfig();
        configuration = new ConfigUtil(getConfig());
        checkEssentialsSpawn();
        getServer().getPluginManager().registerEvents(new VoidDrop(), this);
    }

    public void checkEssentialsSpawn(){
        if(getServer().getPluginManager().getPlugin("EssentialsSpawn") != null){
            essentialsFound = true;
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
