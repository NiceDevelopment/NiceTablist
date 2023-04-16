package ayo.desistirei.nicetablist.utils;

import lombok.Setter;
import org.bukkit.Bukkit;

public class PlayerCount {

    @Setter
    public static int PLAYER_COUNT = Bukkit.getOnlinePlayers().size();

}
