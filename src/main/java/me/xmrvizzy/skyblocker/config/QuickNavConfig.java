package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class QuickNavConfig {
    public static class QuickNav {
        public boolean enableQuickNav = true;

        @ConfigEntry.Category("button1")
        @ConfigEntry.Gui.CollapsibleObject()
        public QuickNavItemConfig.QuickNavItem button1 = new QuickNavItemConfig.QuickNavItem( true, new SkyblockerConfig.ItemData( "diamond_sword" ), "Your Skills", "/skills" );

        @ConfigEntry.Category("button2")
        @ConfigEntry.Gui.CollapsibleObject()
        public QuickNavItemConfig.QuickNavItem button2 = new QuickNavItemConfig.QuickNavItem( true, new SkyblockerConfig.ItemData( "painting" ), "Collections", "/collection" );

        @ConfigEntry.Category("button3")
        @ConfigEntry.Gui.CollapsibleObject()
        public QuickNavItemConfig.QuickNavItem button3 = new QuickNavItemConfig.QuickNavItem( true, new SkyblockerConfig.ItemData( "bone" ), "\\(\\d+/\\d+\\) Pets", "/pets" );

        @ConfigEntry.Category("button4")
        @ConfigEntry.Gui.CollapsibleObject()
        public QuickNavItemConfig.QuickNavItem button4 = new QuickNavItemConfig.QuickNavItem( true, new SkyblockerConfig.ItemData( "leather_chestplate", 1, "tag:{display:{color:8991416}}" ), "Wardrobe \\([12]/2\\)", "/wardrobe" );

        @ConfigEntry.Category("button5")
        @ConfigEntry.Gui.CollapsibleObject()
        public QuickNavItemConfig.QuickNavItem button5 = new QuickNavItemConfig.QuickNavItem( true, new SkyblockerConfig.ItemData( "player_head", 1, "tag:{SkullOwner:{Id:[I;-2081424676,-57521078,-2073572414,158072763],Properties:{textures:[{Value:\"ewogICJ0aW1lc3RhbXAiIDogMTU5MTMxMDU4NTYwOSwKICAicHJvZmlsZUlkIiA6ICI0MWQzYWJjMmQ3NDk0MDBjOTA5MGQ1NDM0ZDAzODMxYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJNZWdha2xvb24iLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODBhMDc3ZTI0OGQxNDI3NzJlYTgwMDg2NGY4YzU3OGI5ZDM2ODg1YjI5ZGFmODM2YjY0YTcwNjg4MmI2ZWMxMCIKICAgIH0KICB9Cn0=\"}]}}}" ), "Sack of Sacks", "/sacks" );

        @ConfigEntry.Category("button6")
        @ConfigEntry.Gui.CollapsibleObject()
        public QuickNavItemConfig.QuickNavItem button6 = new QuickNavItemConfig.QuickNavItem( true, new SkyblockerConfig.ItemData( "ender_chest" ), "Storage", "/storage" );

        @ConfigEntry.Category("button7")
        @ConfigEntry.Gui.CollapsibleObject()
        public QuickNavItemConfig.QuickNavItem button7 = new QuickNavItemConfig.QuickNavItem( true, new SkyblockerConfig.ItemData( "player_head", 1, "tag:{SkullOwner:{Id:[I;-300151517,-631415889,-1193921967,-1821784279],Properties:{textures:[{Value:\"e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdjYzY2ODc0MjNkMDU3MGQ1NTZhYzUzZTA2NzZjYjU2M2JiZGQ5NzE3Y2Q4MjY5YmRlYmVkNmY2ZDRlN2JmOCJ9fX0=\"}]}}}" ), "none", "/hub" );

        @ConfigEntry.Category("button8")
        @ConfigEntry.Gui.CollapsibleObject()
        public QuickNavItemConfig.QuickNavItem button8 = new QuickNavItemConfig.QuickNavItem( true, new SkyblockerConfig.ItemData( "player_head", 1, "tag:{SkullOwner:{Id:[I;1605800870,415127827,-1236127084,15358548],Properties:{textures:[{Value:\"e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg5MWQ1YjI3M2ZmMGJjNTBjOTYwYjJjZDg2ZWVmMWM0MGExYjk0MDMyYWU3MWU3NTQ3NWE1NjhhODI1NzQyMSJ9fX0=\"}]}}}" ), "none", "/warp dungeon_hub" );

        @ConfigEntry.Category("button9")
        @ConfigEntry.Gui.CollapsibleObject()
        public QuickNavItemConfig.QuickNavItem button9 = new QuickNavItemConfig.QuickNavItem( true, new SkyblockerConfig.ItemData( "player_head", 1, "tag:{SkullOwner:{Id:[I;-562285948,532499670,-1705302742,775653035],Properties:{textures:[{Value:\"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjVkZjU1NTkyNjQzMGQ1ZDc1YWRlZDIxZGQ5NjE5Yjc2YzViN2NhMmM3ZjU0MDE0NDA1MjNkNTNhOGJjZmFhYiJ9fX0=\"}]}}}" ), "Visit prtl", "/visit prtl" );

        @ConfigEntry.Category("button10")
        @ConfigEntry.Gui.CollapsibleObject()
        public QuickNavItemConfig.QuickNavItem button10 = new QuickNavItemConfig.QuickNavItem( true, new SkyblockerConfig.ItemData( "enchanting_table" ), "Enchant Item", "/etable" );

        @ConfigEntry.Category("button11")
        @ConfigEntry.Gui.CollapsibleObject()
        public QuickNavItemConfig.QuickNavItem button11 = new QuickNavItemConfig.QuickNavItem( true, new SkyblockerConfig.ItemData( "anvil" ), "Anvil", "/anvil" );

        @ConfigEntry.Category("button12")
        @ConfigEntry.Gui.CollapsibleObject()
        public QuickNavItemConfig.QuickNavItem button12 = new QuickNavItemConfig.QuickNavItem( true, new SkyblockerConfig.ItemData( "crafting_table" ), "Craft Item", "/craft" );
    }
}