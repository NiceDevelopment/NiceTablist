package ayo.desistirei.nicetablist.adapter;

import ayo.desistirei.nicetablist.NiceTablist;
import ayo.desistirei.nicetablist.utils.CC;
import ayo.desistirei.nicetablist.utils.Ping;
import ayo.desistirei.nicetablist.utils.PlayerCount;
import io.github.thatkawaiisam.ziggurat.ZigguratAdapter;
import io.github.thatkawaiisam.ziggurat.ZigguratCommons;
import io.github.thatkawaiisam.ziggurat.utils.BufferedTabObject;
import io.github.thatkawaiisam.ziggurat.utils.TabColumn;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class TablistAdapter implements ZigguratAdapter {

    @Override
    public Set<BufferedTabObject> getSlots(Player player) {
        Set<BufferedTabObject> layoutSet = new HashSet<>();
        FileConfiguration config = NiceTablist.getInstance().getConfig();
        int i = 1;
        for (String text : config.getStringList("tablist.far_right").stream()
                .map(a -> a.replace("{online}", String.valueOf(PlayerCount.PLAYER_COUNT)).replace("{ping}", String.valueOf(Ping.getPing(player))).replace("{player}", player.getName()))
                .collect(Collectors.toList())) {
            layoutSet.add(new BufferedTabObject().column(TabColumn.FAR_RIGHT).slot(i).text(CC.translate(text)).ping(Ping.getPing(player)));
            i++;
        }
        i = 1;
        for (String text : config.getStringList("tablist.right").stream()
                .map(a -> a.replace("{online}", String.valueOf(PlayerCount.PLAYER_COUNT)).replace("{ping}", String.valueOf(Ping.getPing(player))).replace("{player}", player.getName()))
                .collect(Collectors.toList())) {
            layoutSet.add(new BufferedTabObject().column(TabColumn.RIGHT).slot(i).text(CC.translate(text)).ping(Ping.getPing(player)));
            i++;
        }
        i = 1;
        for (String text : config.getStringList("tablist.middle").stream()
                .map(a -> a.replace("{online}", String.valueOf(PlayerCount.PLAYER_COUNT)).replace("{ping}", String.valueOf(Ping.getPing(player))).replace("{player}", player.getName()))
                .collect(Collectors.toList())) {
            layoutSet.add(new BufferedTabObject().column(TabColumn.MIDDLE).slot(i).text(CC.translate(text)).ping(Ping.getPing(player)));
            i++;
        }
        i = 1;
        for (String text : config.getStringList("tablist.left").stream()
                .map(a -> a.replace("{online}", String.valueOf(PlayerCount.PLAYER_COUNT)).replace("{ping}", String.valueOf(Ping.getPing(player))).replace("{player}", player.getName()))
                .collect(Collectors.toList())) {
            layoutSet.add(new BufferedTabObject().column(TabColumn.LEFT).slot(i).text(CC.translate(text)).ping(Ping.getPing(player)));
            i++;
        }
        return layoutSet;
    }

    @Override
    public String getHeader() {
        return NiceTablist.instance.getConfig().getString("header").replace("&", "§");
    }

    @Override
    public String getFooter() {
        return NiceTablist.instance.getConfig().getString("footer").replace("&", "§");
    }
}
