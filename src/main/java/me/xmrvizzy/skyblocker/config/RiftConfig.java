package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class RiftConfig {
    public static class Rift {
        public boolean mirrorverseWaypoints = true;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 5)
        @ConfigEntry.Gui.Tooltip
        public int mcGrubberStacks = 0;
    }
}