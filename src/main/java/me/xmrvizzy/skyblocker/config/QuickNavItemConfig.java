package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class QuickNavItemConfig {
    public static class QuickNavItem {
        public QuickNavItem(Boolean render, IntemDataConfig.ItemData itemData, String uiTitle, String clickEvent) {
            this.render = render;
            this.item = itemData;
            this.clickEvent = clickEvent;
            this.uiTitle = uiTitle;
        }

        public Boolean render;

        @ConfigEntry.Category("item")
        @ConfigEntry.Gui.CollapsibleObject()
        public IntemDataConfig.ItemData item;

        public String uiTitle;
        public String clickEvent;
    }
}