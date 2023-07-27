package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class richPresence {
    @ConfigEntry.Category("richPresence")
    @ConfigEntry.Gui.TransitiveObject
    public RichPresenceConfig.RichPresence richPresence = new RichPresenceConfig.RichPresence();

    public richPresence() {
    }
}