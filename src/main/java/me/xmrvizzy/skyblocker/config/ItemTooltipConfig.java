package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ItemTooltipConfig {
    public static class ItemTooltip {
        public boolean enableNPCPrice = true;
        @ConfigEntry.Gui.Tooltip
        public boolean enableMotesPrice = true;
        public boolean enableAvgBIN = true;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        @ConfigEntry.Gui.Tooltip()
        public SkyblockerConfig.Average avg = SkyblockerConfig.Average.THREE_DAY;
        public boolean enableLowestBIN = true;
        public boolean enableBazaarPrice = true;
        public boolean enableMuseumDate = true;
    }
}