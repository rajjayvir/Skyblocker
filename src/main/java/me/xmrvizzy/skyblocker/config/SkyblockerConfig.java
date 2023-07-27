package me.xmrvizzy.skyblocker.config;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.xmrvizzy.skyblocker.SkyblockerMod;
import me.xmrvizzy.skyblocker.chat.ChatFilterResult;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.resource.language.I18n;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

@Config(name = "skyblocker")
public class SkyblockerConfig implements ConfigData {

    public final TabHudConfConfig tabHudConfConfig = new TabHudConfConfig();
    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.TransitiveObject
    public GeneralConfig.General general = new GeneralConfig.General();

    @ConfigEntry.Category("locations")
    @ConfigEntry.Gui.TransitiveObject
    public Locations locations = new Locations();

    @ConfigEntry.Category("slayer")
    @ConfigEntry.Gui.TransitiveObject
    public Slayer slayer = new Slayer();

    @ConfigEntry.Category("messages")
    @ConfigEntry.Gui.TransitiveObject
    public Messages messages = new Messages();

    @ConfigEntry.Category("richPresence")
    @ConfigEntry.Gui.TransitiveObject
    public RichPresenceConfig.RichPresence richPresence = new RichPresenceConfig.RichPresence();

    public enum NameSorting {
    	DEFAULT,
        ALPHABETICAL;

        @Override
        public String toString() {
            return switch (this) {
                case DEFAULT -> "Default";
                case ALPHABETICAL -> "Alphabetical";
            };
        }
    }

    public enum BarPosition {
        LAYER1,
        LAYER2,
        RIGHT,
        NONE;

        @Override
        public String toString() {
            return I18n.translate("text.autoconfig.skyblocker.option.general.bars.barpositions." + name());
        }

        public int toInt() {
            return switch (this) {
                case LAYER1 -> 0;
                case LAYER2 -> 1;
                case RIGHT -> 2;
                case NONE -> -1;
            };
        }
    }

    public static class TitleContainer {
        @ConfigEntry.BoundedDiscrete(min = 30, max = 140)
        public float titleContainerScale = 100;
        public int x = 540;
        public int y = 10;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public Direction direction = Direction.HORIZONTAL;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.DROPDOWN)
        public Alignment alignment = Alignment.MIDDLE;
    }

    public enum Direction {
        HORIZONTAL,
        VERTICAL;

        @Override
        public String toString() {
            return switch (this) {
                case HORIZONTAL -> "Horizontal";
                case VERTICAL -> "Vertical";
            };
        }
    }

    public enum Alignment {
        LEFT,
        RIGHT,
        MIDDLE;

        @Override
        public String toString() {
            return switch (this) {
                case LEFT -> "Left";
                case RIGHT -> "Right";
                case MIDDLE -> "Middle";
            };
        }
    }

    public static class ItemList {
        public boolean enableItemList = true;
    }

    public enum Average {
        ONE_DAY,
        THREE_DAY,
        BOTH;

        @Override
        public String toString() {
            return I18n.translate("text.autoconfig.skyblocker.option.general.itemTooltip.avg." + name());
        }
    }

    public static class ItemTooltip {
        public boolean enableNPCPrice = true;
        @ConfigEntry.Gui.Tooltip
        public boolean enableMotesPrice = true;
        public boolean enableAvgBIN = true;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        @ConfigEntry.Gui.Tooltip()
        public Average avg = Average.THREE_DAY;
        public boolean enableLowestBIN = true;
        public boolean enableBazaarPrice = true;
        public boolean enableMuseumDate = true;
    }

    public static class Locations {
        @ConfigEntry.Category("barn")
        @ConfigEntry.Gui.CollapsibleObject()
        public Barn barn = new Barn();

        @ConfigEntry.Category("dungeons")
        @ConfigEntry.Gui.CollapsibleObject()
        public Dungeons dungeons = new Dungeons();

        @ConfigEntry.Category("dwarvenmines")
        @ConfigEntry.Gui.CollapsibleObject()
        public DwarvenMines dwarvenMines = new DwarvenMines();

        @ConfigEntry.Category("rift")
        @ConfigEntry.Gui.CollapsibleObject()
        public Rift rift = new Rift();
    }

    public static class Dungeons {
        @ConfigEntry.Gui.Tooltip()
        public boolean croesusHelper = true;
        public boolean enableMap = true;
        public float mapScaling = 1f;
        public int mapX = 2;
        public int mapY = 2;
        public boolean solveThreeWeirdos = true;
        public boolean blazesolver = true;
        public boolean solveTrivia = true;
        @ConfigEntry.Gui.CollapsibleObject
        public LividColor lividColor = new LividColor();
        @ConfigEntry.Gui.CollapsibleObject()
        public Terminals terminals = new Terminals();
    }

    public static class LividColor {
        @ConfigEntry.Gui.Tooltip()
        public boolean enableLividColor = true;
        @ConfigEntry.Gui.Tooltip()
        public String lividColorText = "The livid color is [color]";
    }

    public static class Terminals {
        public boolean solveColor = true;
        public boolean solveOrder = true;
        public boolean solveStartsWith = true;
    }

    public static class DwarvenMines {
        public boolean enableDrillFuel = true;
        public boolean solveFetchur = true;
        public boolean solvePuzzler = true;
        @ConfigEntry.Gui.CollapsibleObject()
        public DwarvenHud dwarvenHud = new DwarvenHud();
    }

    public static class DwarvenHud {
        public boolean enabled = true;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        @ConfigEntry.Gui.Tooltip(count = 3)
        public Style style = Style.SIMPLE;
        public boolean enableBackground = true;
        public int x = 10;
        public int y = 10;
    }

    public enum Style {
        SIMPLE,
        FANCY,
        CLASSIC;

        @Override
        public String toString() {
            return switch (this) {
                case SIMPLE -> "Simple";
                case FANCY -> "Fancy";
                case CLASSIC -> "Classic";
            };
        }
    }

    public static class Barn {
        public boolean solveHungryHiker = true;
        public boolean solveTreasureHunter = true;
    }

    public static class Rift {
        public boolean mirrorverseWaypoints = true;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 5)
        @ConfigEntry.Gui.Tooltip
        public int mcGrubberStacks = 0;
    }

    public static class Slayer {
        @ConfigEntry.Category("vampire")
        @ConfigEntry.Gui.CollapsibleObject()
        public VampireSlayer vampireSlayer = new VampireSlayer();
    }

    public static class VampireSlayer {
        public boolean enableEffigyWaypoints = true;
        public boolean compactEffigyWaypoints;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
        @ConfigEntry.Gui.Tooltip()
        public int effigyUpdateFrequency = 5;
        public boolean enableHolyIceIndicator = true;
        public int holyIceIndicatorTickDelay = 10;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
        @ConfigEntry.Gui.Tooltip()
        public int holyIceUpdateFrequency = 5;
        public boolean enableHealingMelonIndicator = true;
        public float healingMelonHealthThreshold = 4F;
        public boolean enableSteakStakeIndicator = true;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
        @ConfigEntry.Gui.Tooltip()
        public int steakStakeUpdateFrequency = 5;
        public boolean enableManiaIndicator = true;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
        @ConfigEntry.Gui.Tooltip()
        public int maniaUpdateFrequency = 5;
    }

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

    public enum Info {
        PURSE,
        BITS,
        LOCATION;

        @Override
        public String toString() {
            return I18n.translate("text.autoconfig.skyblocker.option.richPresence.info." + name());
        }
    }

    /**
     * Registers the config to AutoConfig and register commands to open the config screen.
     */
    public static void init() {
        AutoConfig.register(SkyblockerConfig.class, GsonConfigSerializer::new);
        ClientCommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess) -> dispatcher.register(literal(SkyblockerMod.NAMESPACE).then(optionsLiteral("config")).then(optionsLiteral("options")))));
    }

    /**
     * Registers an options command with the given name. Used for registering both options and config as valid commands.
     *
     * @param name the name of the command node
     * @return the command builder
     */
    private static LiteralArgumentBuilder<FabricClientCommandSource> optionsLiteral(String name) {
        // Don't immediately open the next screen as it will be closed by ChatScreen right after this command is executed
        return literal(name).executes(context -> SkyblockerMod.getInstance().scheduler.queueOpenScreen(AutoConfig.getConfigScreen(SkyblockerConfig.class, null)));
    }

    public static SkyblockerConfig get() {
        return AutoConfig.getConfigHolder(SkyblockerConfig.class).getConfig();
    }
}
