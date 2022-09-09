package me.leshroomz.voidescape.Util;

import lombok.AccessLevel;
import lombok.Getter;
import me.leshroomz.voidescape.Voidescape;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;
import java.util.logging.Level;

public class ConfigUtil {

    @Getter(AccessLevel.NONE)
    private static ConfigurationSection configuration = null;

    public ConfigUtil(ConfigurationSection section){
        configuration = section;

        if(configuration.getList("worlds").isEmpty()){
            Voidescape.getPlugin().getLogger().log(Level.WARNING, "Worlds list in configuration is empty, VoidEscape will not function.");

        }
    }

    public static boolean checkWorld(String worldName){
        List<?> configWorlds = configuration.getList("worlds");
        return configWorlds.contains(worldName);
    }
}
