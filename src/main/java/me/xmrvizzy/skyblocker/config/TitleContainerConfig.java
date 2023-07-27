package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class TitleContainerConfig {
    public static class TitleContainer {
        @ConfigEntry.BoundedDiscrete(min = 30, max = 140)
        public float titleContainerScale = 100;
        public int x = 540;
        public int y = 10;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public SkyblockerConfig.Direction direction = SkyblockerConfig.Direction.HORIZONTAL;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.DROPDOWN)
        public SkyblockerConfig.Alignment alignment = SkyblockerConfig.Alignment.MIDDLE;
    }
}