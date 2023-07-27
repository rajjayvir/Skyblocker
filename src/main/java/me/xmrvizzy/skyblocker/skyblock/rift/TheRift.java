package me.xmrvizzy.skyblocker.skyblock.rift;

import me.xmrvizzy.skyblocker.SkyblockerMod;
import me.xmrvizzy.skyblocker.config.getConfig;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;

public class TheRift {
    /**
     * @see me.xmrvizzy.skyblocker.utils.Utils#isInTheRift() Utils#isInTheRift().
     */
    public static final String LOCATION = "rift";

    public static void init() {
        WorldRenderEvents.AFTER_TRANSLUCENT.register(MirrorverseWaypoints::render);
        WorldRenderEvents.AFTER_TRANSLUCENT.register(EffigyWaypoints::render);
        SkyblockerMod.getInstance().scheduler.scheduleCyclic(EffigyWaypoints::updateEffigies, getConfig.get().slayer.vampireSlayer.effigyUpdateFrequency);
        SkyblockerMod.getInstance().scheduler.scheduleCyclic(TwinClawsIndicator::updateIce, getConfig.get().slayer.vampireSlayer.holyIceUpdateFrequency);
        SkyblockerMod.getInstance().scheduler.scheduleCyclic(ManiaIndicator::updateMania, getConfig.get().slayer.vampireSlayer.maniaUpdateFrequency);
        SkyblockerMod.getInstance().scheduler.scheduleCyclic(StakeIndicator::updateStake, getConfig.get().slayer.vampireSlayer.steakStakeUpdateFrequency);
    }
}
