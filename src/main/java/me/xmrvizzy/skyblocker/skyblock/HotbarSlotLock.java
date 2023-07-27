package me.xmrvizzy.skyblocker.skyblock;

import me.shedaniel.autoconfig.AutoConfig;
import me.xmrvizzy.skyblocker.config.SkyblockerConfig;
import me.xmrvizzy.skyblocker.config.getConfig;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

public class HotbarSlotLock {
    public static KeyBinding hotbarSlotLock;

    public static void init() {
        hotbarSlotLock = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.hotbarSlotLock",
                GLFW.GLFW_KEY_H,
                "key.categories.skyblocker"
        ));
    }

    public static boolean isLocked(int slot) {
        return getConfig.get().general.lockedSlots.contains(slot);
    }

    public static void handleDropSelectedItem(int slot, CallbackInfoReturnable<Boolean> cir) {
        if (isLocked(slot)) cir.setReturnValue(false);
    }

    public static void handleInputEvents(ClientPlayerEntity player) {
        while (hotbarSlotLock.wasPressed()) {
            List<Integer> lockedSlots = getConfig.get().general.lockedSlots;
            int selected = player.getInventory().selectedSlot;
            if (!isLocked(player.getInventory().selectedSlot)) lockedSlots.add(selected);
            else lockedSlots.remove(Integer.valueOf(selected));
            AutoConfig.getConfigHolder(SkyblockerConfig.class).save();
        }
    }
}