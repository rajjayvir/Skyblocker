package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class BarsConfig {
    public static class Bars {
        public boolean enableBars = true;

        @ConfigEntry.Category("barpositions")
        @ConfigEntry.Gui.CollapsibleObject()
        public SkyblockerConfig.BarPositions barpositions = new SkyblockerConfig.BarPositions();
    }

    public static class Shortcuts {
        @ConfigEntry.Gui.Tooltip()
        public boolean enableShortcuts = true;
        @ConfigEntry.Gui.Tooltip()
        public boolean enableCommandShortcuts = true;
        @ConfigEntry.Gui.Tooltip()
        public boolean enableCommandArgShortcuts = true;
    }
}