package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class BarPositionsConfig {
    public static class BarPositions {
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public SkyblockerConfig.BarPosition healthBarPosition = SkyblockerConfig.BarPosition.LAYER1;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public SkyblockerConfig.BarPosition manaBarPosition = SkyblockerConfig.BarPosition.LAYER1;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public SkyblockerConfig.BarPosition defenceBarPosition = SkyblockerConfig.BarPosition.LAYER1;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public SkyblockerConfig.BarPosition experienceBarPosition = SkyblockerConfig.BarPosition.LAYER1;

    }
}