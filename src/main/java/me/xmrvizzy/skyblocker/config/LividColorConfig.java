package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class LividColorConfig {
    public static class LividColor {
        @ConfigEntry.Gui.Tooltip()
        public boolean enableLividColor = true;
        @ConfigEntry.Gui.Tooltip()
        public String lividColorText = "The livid color is [color]";
    }
}