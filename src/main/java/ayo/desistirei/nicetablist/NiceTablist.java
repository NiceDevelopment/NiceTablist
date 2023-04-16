package ayo.desistirei.nicetablist;

import ayo.desistirei.nicetablist.adapter.TablistAdapter;
import ayo.desistirei.nicetablist.command.TablistCommand;
import io.github.thatkawaiisam.ziggurat.Ziggurat;
import io.github.thatkawaiisam.ziggurat.ZigguratTablist;
import lombok.Getter;
import lombok.Setter;
import me.andyreckt.sunset.Sunset;
import org.bukkit.plugin.java.JavaPlugin;

public class NiceTablist extends JavaPlugin {

    @Getter @Setter
    public static NiceTablist instance;

    @Override
    public void onEnable() {
        new Ziggurat(this, new TablistAdapter());
        setInstance(this);

        // Command Framework initialization
        Sunset sunset = new Sunset(this);
        sunset.registerCommands(new TablistCommand());
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }
}