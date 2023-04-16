package ayo.desistirei.nicetablist.utils;


import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class Ping {

    public static int getPing(Player player) {
        CraftPlayer cp = (CraftPlayer) player;
        return cp.getHandle().ping;
    }

}
