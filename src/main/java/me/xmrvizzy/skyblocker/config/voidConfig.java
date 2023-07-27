package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.xmrvizzy.skyblocker.SkyblockerMod;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public class voidConfig {
    /**
     * Registers the config to AutoConfig and register commands to open the config screen.
     */
    public static void init() {
        AutoConfig.register( SkyblockerConfig.class, GsonConfigSerializer::new );
        ClientCommandRegistrationCallback.EVENT.register( ((dispatcher, registryAccess) -> dispatcher.register( ClientCommandManager.literal( SkyblockerMod.NAMESPACE ).then( SkyblockerConfig.optionsLiteral( "config" ) ).then( SkyblockerConfig.optionsLiteral( "options" ) ) )) );
    }
}