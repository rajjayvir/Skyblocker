package me.xmrvizzy.skyblocker.chat.filters;

import me.xmrvizzy.skyblocker.chat.ChatFilterResult;
import me.xmrvizzy.skyblocker.config.getConfig;

public class AbilityFilter extends SimpleChatFilter {
    public AbilityFilter() {
        super("^(?:This ability is on cooldown for " + NUMBER + "s\\.|No more charges, next one in " + NUMBER + "s!)$");
    }

    @Override
    protected ChatFilterResult state() {
        return getConfig.get().messages.hideAbility;
    }
}
