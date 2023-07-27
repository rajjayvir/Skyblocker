package me.xmrvizzy.skyblocker.config;

import me.shedaniel.autoconfig.AutoConfig;

public class getConfig {
    public static SkyblockerConfig get() {
        return AutoConfig.getConfigHolder( SkyblockerConfig.class ).getConfig();
    }
}