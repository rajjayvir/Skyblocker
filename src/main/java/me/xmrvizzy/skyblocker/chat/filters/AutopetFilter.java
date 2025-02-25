package me.xmrvizzy.skyblocker.chat.filters;

import me.xmrvizzy.skyblocker.chat.ChatFilterResult;
import me.xmrvizzy.skyblocker.chat.ChatPatternListener;
import me.xmrvizzy.skyblocker.config.getConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.util.Objects;
import java.util.regex.Matcher;

public class AutopetFilter extends ChatPatternListener {
    public AutopetFilter() {
        super("^§cAutopet §eequipped your §7.*§e! §a§lVIEW RULE$");
    }

    @Override
    public boolean onMatch(Text _message, Matcher matcher) {
        if (getConfig.get().messages.hideAutopet == ChatFilterResult.ACTION_BAR) {
            Objects.requireNonNull(MinecraftClient.getInstance().player).sendMessage(
                    Text.literal(
                            _message.getString().replace("§a§lVIEW RULE", "")
                    ), true);
        }
        return true;
    }

    @Override
    public ChatFilterResult state() {
        if (getConfig.get().messages.hideAutopet == ChatFilterResult.ACTION_BAR)
            return ChatFilterResult.FILTER;
        else
            return getConfig.get().messages.hideAutopet;
    }
}