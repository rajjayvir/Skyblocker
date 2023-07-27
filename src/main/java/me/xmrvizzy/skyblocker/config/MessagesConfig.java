package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.xmrvizzy.skyblocker.chat.ChatFilterResult;

public class MessagesConfig {
    public static class Messages {
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public ChatFilterResult hideAbility = ChatFilterResult.PASS;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public ChatFilterResult hideHeal = ChatFilterResult.PASS;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public ChatFilterResult hideAOTE = ChatFilterResult.PASS;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public ChatFilterResult hideImplosion = ChatFilterResult.PASS;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public ChatFilterResult hideMoltenWave = ChatFilterResult.PASS;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public ChatFilterResult hideAds = ChatFilterResult.PASS;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public ChatFilterResult hideTeleportPad = ChatFilterResult.PASS;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public ChatFilterResult hideCombo = ChatFilterResult.PASS;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public ChatFilterResult hideAutopet = ChatFilterResult.PASS;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        @ConfigEntry.Gui.Tooltip
        public ChatFilterResult hideShowOff = ChatFilterResult.PASS;
        @ConfigEntry.Gui.Tooltip()
        public boolean hideMana = false;
    }
}