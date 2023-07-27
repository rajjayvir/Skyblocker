package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class LocationsConfig {
    public static class Locations {
        @ConfigEntry.Category("barn")
        @ConfigEntry.Gui.CollapsibleObject()
        public BamConfig.Barn barn = new BamConfig.Barn();

        @ConfigEntry.Category("dungeons")
        @ConfigEntry.Gui.CollapsibleObject()
        public SkyblockerConfig.Dungeons dungeons = new SkyblockerConfig.Dungeons();

        @ConfigEntry.Category("dwarvenmines")
        @ConfigEntry.Gui.CollapsibleObject()
        public SkyblockerConfig.DwarvenMines dwarvenMines = new SkyblockerConfig.DwarvenMines();

        @ConfigEntry.Category("rift")
        @ConfigEntry.Gui.CollapsibleObject()
        public SkyblockerConfig.Rift rift = new SkyblockerConfig.Rift();
    }
}