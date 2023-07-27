package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class DwarvenMinesConfig {
    public static class DwarvenMines {
        public boolean enableDrillFuel = true;
        public boolean solveFetchur = true;
        public boolean solvePuzzler = true;
        @ConfigEntry.Gui.CollapsibleObject()
        public DwarvenHudConfig.DwarvenHud dwarvenHud = new DwarvenHudConfig.DwarvenHud();
    }
}