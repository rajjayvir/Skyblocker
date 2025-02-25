package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.minecraft.client.resource.language.I18n;

@Config(name = "skyblocker")
public class SkyblockerConfig implements ConfigData {

    public final me.xmrvizzy.skyblocker.config.richPresence richPresence = new richPresence();
    public final me.xmrvizzy.skyblocker.config.tabHudConfConfigCon tabHudConfConfigCon = new tabHudConfConfigCon();
    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.TransitiveObject
    public GeneralConfig.General general = new GeneralConfig.General();

    @ConfigEntry.Category("locations")
    @ConfigEntry.Gui.TransitiveObject
    public LocationsConfig.Locations locations = new LocationsConfig.Locations();

    @ConfigEntry.Category("slayer")
    @ConfigEntry.Gui.TransitiveObject
    public Slayer slayer = new Slayer();

    @ConfigEntry.Category("messages")
    @ConfigEntry.Gui.TransitiveObject
    public MessagesConfig.Messages messages = new MessagesConfig.Messages();

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

    public enum Average {
        ONE_DAY,
        THREE_DAY,
        BOTH;

        @Override
        public String toString() {
            return I18n.translate("text.autoconfig.skyblocker.option.general.itemTooltip.avg." + name());
        }
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

    public static class Slayer {
        @ConfigEntry.Category("vampire")
        @ConfigEntry.Gui.CollapsibleObject()
        public VampireSlayerConfig.VampireSlayer vampireSlayer = new VampireSlayerConfig.VampireSlayer();
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

}
