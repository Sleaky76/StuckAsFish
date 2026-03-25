package sleaky.stuckAsFish;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class reverseBreathingCommand implements CommandExecutor {

    public static List<UUID> fishPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Not a player !");
            return true;
        }

        UUID playerUUID = Bukkit.getPlayerUniqueId(commandSender.getName());
        fishPlayers.add(playerUUID);
        return true;
    }
}
