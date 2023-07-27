package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class DwarvenHudConfig {
    public static class DwarvenHud {
        public boolean enabled = true;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        @ConfigEntry.Gui.Tooltip(count = 3)
        public SkyblockerConfig.Style style = SkyblockerConfig.Style.SIMPLE;
        public boolean enableBackground = true;
        public int x = 10;
        public int y = 10;
    }
}