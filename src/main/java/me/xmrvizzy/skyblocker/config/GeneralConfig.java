package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

import java.util.ArrayList;
import java.util.List;

public class GeneralConfig {
    public static class General {
        public boolean acceptReparty = true;
        public boolean backpackPreviewWithoutShift = false;
        public boolean hideEmptyTooltips = true;

        @ConfigEntry.Category("tabHud")
        @ConfigEntry.Gui.CollapsibleObject()
        public TabHudConfConfig.TabHudConf tabHud = new TabHudConfConfig.TabHudConf();

        @ConfigEntry.Gui.Excluded
        public String apiKey;

        @ConfigEntry.Category("bars")
        @ConfigEntry.Gui.CollapsibleObject()
        public BarsConfig.Bars bars = new BarsConfig.Bars();

        @ConfigEntry.Category("experiments")
        @ConfigEntry.Gui.CollapsibleObject()
        public ExperimentsConfig.Experiments experiments = new ExperimentsConfig.Experiments();

        @ConfigEntry.Category("fishing")
        @ConfigEntry.Gui.CollapsibleObject()
        public FishingConfig.Fishing fishing = new FishingConfig.Fishing();

        @ConfigEntry.Category("fairySouls")
        @ConfigEntry.Gui.CollapsibleObject()
        public FairySoulsConfig.FairySouls fairySouls = new FairySoulsConfig.FairySouls();

        @ConfigEntry.Category("shortcuts")
        @ConfigEntry.Gui.CollapsibleObject()
        public BarsConfig.Shortcuts shortcuts = new BarsConfig.Shortcuts();

        @ConfigEntry.Category("itemList")
        @ConfigEntry.Gui.CollapsibleObject()
        public SkyblockerConfig.ItemList itemList = new SkyblockerConfig.ItemList();

        @ConfigEntry.Category("itemTooltip")
        @ConfigEntry.Gui.CollapsibleObject()
        public SkyblockerConfig.ItemTooltip itemTooltip = new SkyblockerConfig.ItemTooltip();

        @ConfigEntry.Category("hitbox")
        @ConfigEntry.Gui.CollapsibleObject()
        public HitboxConfig.Hitbox hitbox = new HitboxConfig.Hitbox();

        @ConfigEntry.Gui.Tooltip()
        @ConfigEntry.Category("titleContainer")
        @ConfigEntry.Gui.CollapsibleObject()
        public TitleContainerConfig.TitleContainer titleContainer = new TitleContainerConfig.TitleContainer();

        @ConfigEntry.Gui.Excluded
        public List<Integer> lockedSlots = new ArrayList<Integer>();
    }
}