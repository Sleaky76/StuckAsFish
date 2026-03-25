package sleaky.stuckAsFish;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class WaterBreathingMechanic {

    public StuckAsFish plugin;

    WaterBreathingMechanic(StuckAsFish plugin) {
        this.plugin = plugin;
    }

    public boolean isUnderWater(Player p) {
        Location loc = p.getLocation();
        if (!p.isSwimming()) {
            loc.setY(loc.getY() + 1);
        }
        Block block = loc.getBlock();
        return block.getType() == Material.WATER;
    }

    public void damagePlayer(Player p, double damage) {
        p.damage(damage);
    }
}
