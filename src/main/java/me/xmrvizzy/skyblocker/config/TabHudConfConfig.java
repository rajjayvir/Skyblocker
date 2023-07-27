package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class TabHudConfConfig {
    @ConfigEntry.Category("quickNav")
    @ConfigEntry.Gui.TransitiveObject
    public QuickNavConfig.QuickNav quickNav = new QuickNavConfig.QuickNav();

    public TabHudConfConfig() {
    }

    public static class TabHudConf {
        public boolean tabHudEnabled = true;

        @ConfigEntry.BoundedDiscrete(min = 10, max = 200)
        @ConfigEntry.Gui.Tooltip()
        public int tabHudScale = 100;
        @ConfigEntry.Gui.Tooltip
        public boolean plainPlayerNames = false;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        @ConfigEntry.Gui.Tooltip
        public SkyblockerConfig.NameSorting nameSorting = SkyblockerConfig.NameSorting.DEFAULT;

    }
}