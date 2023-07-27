package me.xmrvizzy.skyblocker.config;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.xmrvizzy.skyblocker.SkyblockerMod;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.resource.language.I18n;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

@Config(name = "skyblocker")
public class SkyblockerConfig implements ConfigData {

    public final TabHudConfConfigc tabHudConfConfigc = new TabHudConfConfigc();
    public final me.xmrvizzy.skyblocker.config.richPresence richPresence = new richPresence();
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
