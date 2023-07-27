package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class DungeousConfig {
    public static class Dungeons {
        @ConfigEntry.Gui.Tooltip()
        public boolean croesusHelper = true;
        public boolean enableMap = true;
        public float mapScaling = 1f;
        public int mapX = 2;
        public int mapY = 2;
        public boolean solveThreeWeirdos = true;
        public boolean blazesolver = true;
        public boolean solveTrivia = true;
        @ConfigEntry.Gui.CollapsibleObject
        public LividColorConfig.LividColor lividColor = new LividColorConfig.LividColor();
        @ConfigEntry.Gui.CollapsibleObject()
        public SkyblockerConfig.Terminals terminals = new SkyblockerConfig.Terminals();
    }
}