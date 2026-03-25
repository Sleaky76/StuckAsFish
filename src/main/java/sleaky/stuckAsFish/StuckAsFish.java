package sleaky.stuckAsFish;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public final class StuckAsFish extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("reverse-breathing").setExecutor(new reverseBreathingCommand());

        WaterBreathingMechanic WBM = new WaterBreathingMechanic(this);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (UUID player : reverseBreathingCommand.fishPlayers) {
                    if (Bukkit.getPlayer(player) == null) {
                        return;
                    }
                    Player p = Bukkit.getPlayer(player);

                    if (WBM.isUnderWater(p)) {
                        p.setRemainingAir(p.getMaximumAir());
                    } else {
                        p.setRemainingAir(p.getRemainingAir() - 6);
                        if (p.getRemainingAir() <= 0) {
                            WBM.damagePlayer(p, 0.5);
                        }
                    }
                }
            }
        }.runTaskTimer(this, 0, 1);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
