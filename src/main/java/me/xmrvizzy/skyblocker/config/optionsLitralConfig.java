package me.xmrvizzy.skyblocker.config;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.shedaniel.autoconfig.AutoConfig;
import me.xmrvizzy.skyblocker.SkyblockerMod;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

public class optionsLitralConfig {
    /**
     * Registers an options command with the given name. Used for registering both options and config as valid commands.
     *
     * @param name the name of the command node
     * @return the command builder
     */
    public static LiteralArgumentBuilder<FabricClientCommandSource> optionsLiteral(String name) {
        // Don't immediately open the next screen as it will be closed by ChatScreen right after this command is executed
        return ClientCommandManager.literal( name ).executes( context -> SkyblockerMod.getInstance().scheduler.queueOpenScreen( AutoConfig.getConfigScreen( SkyblockerConfig.class, null ) ) );
    }
}