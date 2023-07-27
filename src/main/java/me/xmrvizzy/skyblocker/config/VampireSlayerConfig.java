package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class VampireSlayerConfig {
    public static class VampireSlayer {
        public boolean enableEffigyWaypoints = true;
        public boolean compactEffigyWaypoints;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
        @ConfigEntry.Gui.Tooltip()
        public int effigyUpdateFrequency = 5;
        public boolean enableHolyIceIndicator = true;
        public int holyIceIndicatorTickDelay = 10;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
        @ConfigEntry.Gui.Tooltip()
        public int holyIceUpdateFrequency = 5;
        public boolean enableHealingMelonIndicator = true;
        public float healingMelonHealthThreshold = 4F;
        public boolean enableSteakStakeIndicator = true;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
        @ConfigEntry.Gui.Tooltip()
        public int steakStakeUpdateFrequency = 5;
        public boolean enableManiaIndicator = true;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
        @ConfigEntry.Gui.Tooltip()
        public int maniaUpdateFrequency = 5;
    }
}