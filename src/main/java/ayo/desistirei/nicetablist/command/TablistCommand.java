package ayo.desistirei.nicetablist.command;

import ayo.desistirei.nicetablist.NiceTablist;
import me.andyreckt.sunset.annotations.Command;
import me.andyreckt.sunset.annotations.Param;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static java.lang.Thread.sleep;

public class TablistCommand {

    @Command(names = "nicetablist", permission = "nicetablist.user")
    public void command(CommandSender sender, @Param(name = "help/reload") String args) throws InterruptedException {
        Player player = (Player) sender;
        FileConfiguration config = NiceTablist.getInstance().getConfig();

        if (args.equals("help")) {
            for (String line : config.getStringList("messages.help")) {
                line = line.replace("&", "§");
                player.sendMessage(line);
            }
        }
        else if (args.equals("reload")) {
            for (String line : config.getStringList("messages.reload"))
            {
                line = line.replace("&", "§");
                player.sendMessage(line);
            }

            NiceTablist.getInstance().reloadConfig();
            sleep(300);

            for (String line : config.getStringList("messages.reloaded"))
            {
                line = line.replace("&", "§");
                player.sendMessage(line);
            }
        }
    }
}
