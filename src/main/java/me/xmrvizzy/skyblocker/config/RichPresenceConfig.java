package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class RichPresenceConfig {
    public static class RichPresence {
        public boolean enableRichPresence = false;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        @ConfigEntry.Gui.Tooltip()
        public SkyblockerConfig.Info info = SkyblockerConfig.Info.LOCATION;
        public boolean cycleMode = false;
        public String customMessage = "Playing Skyblock";
    }
}