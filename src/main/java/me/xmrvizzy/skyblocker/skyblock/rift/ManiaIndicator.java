package me.xmrvizzy.skyblocker.skyblock.rift;

import me.xmrvizzy.skyblocker.config.getConfig;
import me.xmrvizzy.skyblocker.utils.RenderHelper;
import me.xmrvizzy.skyblocker.utils.SlayerUtils;
import me.xmrvizzy.skyblocker.utils.Utils;
import me.xmrvizzy.skyblocker.utils.title.Title;
import me.xmrvizzy.skyblocker.utils.title.TitleContainer;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;

public class ManiaIndicator {
    private static final Title title = new Title("skyblocker.rift.mania", Formatting.RED);

    protected static void updateMania() {
        if (!getConfig.get().slayer.vampireSlayer.enableManiaIndicator || !Utils.isOnSkyblock() || !Utils.isInTheRift() || !(Utils.getLocation().contains("Stillgore Château")) || !SlayerUtils.isInSlayer()) {
            TitleContainer.removeTitle(title);
            return;
        }

        Entity slayerEntity = SlayerUtils.getSlayerEntity();
        if (slayerEntity == null) return;

        boolean anyMania = false;
        for (Entity entity : SlayerUtils.getEntityArmorStands(slayerEntity)) {
            if (entity.getDisplayName().toString().contains("MANIA")) {
                anyMania = true;
                BlockPos pos = MinecraftClient.getInstance().player.getBlockPos().down();
                boolean isGreen = MinecraftClient.getInstance().world.getBlockState(pos).getBlock() == Blocks.GREEN_TERRACOTTA;
                title.setText(Text.translatable("skyblocker.rift.mania").formatted(isGreen ? Formatting.GREEN : Formatting.RED));
                RenderHelper.displayInTitleContainerAndPlaySound(title);
            }
        }
        if (!anyMania) {
            TitleContainer.removeTitle(title);
        }
    }
}