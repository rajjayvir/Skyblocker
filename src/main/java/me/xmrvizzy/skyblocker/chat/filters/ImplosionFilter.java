package me.xmrvizzy.skyblocker.chat.filters;

import me.xmrvizzy.skyblocker.chat.ChatFilterResult;
import me.xmrvizzy.skyblocker.config.getConfig;

public class ImplosionFilter extends SimpleChatFilter {
    public ImplosionFilter() {
        super("^Your Implosion hit " + NUMBER + " enem(?:y|ies) for " + NUMBER + " damage\\.$");
    }

    @Override
    public ChatFilterResult state() {
        return getConfig.get().messages.hideImplosion;
    }
}
