package me.xmrvizzy.skyblocker.skyblock.dungeon.terminal;

import me.xmrvizzy.skyblocker.config.getConfig;
import me.xmrvizzy.skyblocker.gui.ColorHighlight;
import me.xmrvizzy.skyblocker.gui.ContainerSolver;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class ColorTerminal extends ContainerSolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(ColorTerminal.class.getName());
    private static final Map<String, DyeColor> colorFromName;
    private DyeColor targetColor;
    private static final Map<Item, DyeColor> itemColor;

    public ColorTerminal() {
        super("^Select all the ([A-Z ]+) items!$");
    }

    @Override
    protected boolean isEnabled() {
        targetColor = null;
        return getConfig.get().locations.dungeons.terminals.solveColor;
    }

    @Override
    protected List<ColorHighlight> getColors(String[] groups, Map<Integer, ItemStack> slots) {
        trimEdges(slots, 6);
        List<ColorHighlight> highlights = new ArrayList<>();
        String colorString = groups[0];
        if (targetColor == null) {
            targetColor = colorFromName.get(colorString);
            if (targetColor == null) {
                LOGGER.error("[Skyblocker] Couldn't find dye color corresponding to \"" + colorString + "\"");
                return Collections.emptyList();
            }
        }
        for (Map.Entry<Integer, ItemStack> slot : slots.entrySet()) {
            ItemStack itemStack = slot.getValue();
            if (!itemStack.hasEnchantments() && targetColor.equals(itemColor.get(itemStack.getItem()))) {
                highlights.add(ColorHighlight.green(slot.getKey()));
            }
        }
        return highlights;
    }


    static {
        colorFromName = new HashMap<>();
        for (DyeColor color : DyeColor.values())
            colorFromName.put(color.getName().toUpperCase(Locale.ENGLISH), color);
        colorFromName.put("SILVER", DyeColor.LIGHT_GRAY);
        colorFromName.put("LIGHT BLUE", DyeColor.LIGHT_BLUE);

        itemColor = new HashMap<>();
        for (DyeColor color : DyeColor.values())
            for (String item : new String[]{"dye", "wool", "stained_glass", "terracotta"})
                itemColor.put(Registries.ITEM.get(new Identifier(color.getName() + '_' + item)), color);
        itemColor.put(Items.BONE_MEAL, DyeColor.WHITE);
        itemColor.put(Items.LAPIS_LAZULI, DyeColor.BLUE);
        itemColor.put(Items.COCOA_BEANS, DyeColor.BROWN);
        itemColor.put(Items.INK_SAC, DyeColor.BLACK);
    }
}