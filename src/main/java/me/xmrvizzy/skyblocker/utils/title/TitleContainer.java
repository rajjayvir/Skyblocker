package me.xmrvizzy.skyblocker.utils.title;

import me.xmrvizzy.skyblocker.SkyblockerMod;
import me.xmrvizzy.skyblocker.config.SkyblockerConfig;
import me.xmrvizzy.skyblocker.config.getConfig;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;

import java.util.LinkedHashSet;
import java.util.Set;

public class TitleContainer {
    /**
     * The set of titles which will be rendered.
     *
     * @see #containsTitle(Title)
     * @see #addTitle(Title)
     * @see #addTitle(Title, int)
     * @see #removeTitle(Title)
     */
    private static final Set<Title> titles = new LinkedHashSet<>();

    public static void init() {
        HudRenderCallback.EVENT.register(TitleContainer::render);
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(ClientCommandManager.literal("skyblocker")
                .then(ClientCommandManager.literal("hud")
                        .then(ClientCommandManager.literal("titleContainer")
                                .executes(context -> SkyblockerMod.getInstance().scheduler.queueOpenScreen(TitleContainerConfigScreen::new))))));
    }

    /**
     * Returns {@code true} if the title is currently shown.
     *
     * @param title the title to check
     * @return whether the title in currently shown
     */
    public static boolean containsTitle(Title title) {
        return titles.contains(title);
    }

    /**
     * Adds a title to be shown
     *
     * @param title the title to be shown
     * @return whether the title is already currently being shown
     */
    public static boolean addTitle(Title title) {
        if (titles.add(title)) {
            title.resetPos();
            return true;
        }
        return false;
    }

    /**
     * Adds a title to be shown for a set number of ticks
     *
     * @param title the title to be shown
     * @param ticks the number of ticks to show the title
     * @return whether the title is already currently being shown
     */
    public static boolean addTitle(Title title, int ticks) {
        if (addTitle(title)) {
            SkyblockerMod.getInstance().scheduler.schedule(() -> TitleContainer.removeTitle(title), ticks);
            return true;
        }
        return false;
    }

    /**
     * Stops showing a title
     *
     * @param title the title to stop showing
     */
    public static void removeTitle(Title title) {
        titles.remove(title);
    }

    private static void render(DrawContext context, float tickDelta) {
        render(context, titles, getConfig.get().general.titleContainer.x, getConfig.get().general.titleContainer.y, tickDelta);
    }

    protected static void render(DrawContext context, Set<Title> titles, int xPos, int yPos, float tickDelta) {
        var client = MinecraftClient.getInstance();
        TextRenderer textRenderer = client.textRenderer;

        // Calculate Scale to use
        float scale = 3F * (getConfig.get().general.titleContainer.titleContainerScale / 100F);

        // Grab direction and alignment values
        SkyblockerConfig.Direction direction = getConfig.get().general.titleContainer.direction;
        SkyblockerConfig.Alignment alignment = getConfig.get().general.titleContainer.alignment;
        // x/y refer to the starting position for the text
        // y always starts at yPos
        float x = 0;
        float y = yPos;

        //Calculate the width of combined text
        float width = 0;
        for (Title title : titles) {
            width += textRenderer.getWidth(title.getText()) * scale + 10;
        }

        if (alignment == SkyblockerConfig.Alignment.MIDDLE) {
            if (direction == SkyblockerConfig.Direction.HORIZONTAL) {
                //If middle aligned horizontally, start the xPosition at half of the width to the left.
                x = xPos - (width / 2);
            } else {
                //If middle aligned vertically, start at xPos, we will shift each text to the left later
                x = xPos;
            }
        }
        if (alignment == SkyblockerConfig.Alignment.LEFT || alignment == SkyblockerConfig.Alignment.RIGHT) {
            //If left or right aligned, start at xPos, we will shift each text later
            x = xPos;
        }

        for (Title title : titles) {

            //Calculate which x the text should use
            float xToUse;
            if (direction == SkyblockerConfig.Direction.HORIZONTAL) {
                xToUse = alignment == SkyblockerConfig.Alignment.RIGHT ?
                        x - (textRenderer.getWidth(title.getText()) * scale) : //if right aligned we need the text position to be aligned on the right side.
                        x;
            } else {
                xToUse = alignment == SkyblockerConfig.Alignment.MIDDLE ?
                        x - (textRenderer.getWidth(title.getText()) * scale) / 2 : //if middle aligned we need the text position to be aligned in the middle.
                        alignment == SkyblockerConfig.Alignment.RIGHT ?
                                x - (textRenderer.getWidth(title.getText()) * scale) : //if right aligned we need the text position to be aligned on the right side.
                                x;
            }

            //Start displaying the title at the correct position, not at the default position
            if (title.isDefaultPos()) {
                title.x = xToUse;
                title.y = y;
            }

            //Lerp the texts x and y variables
            title.x = MathHelper.lerp(tickDelta * 0.5F, title.x, xToUse);
            title.y = MathHelper.lerp(tickDelta * 0.5F, title.y, y);

            //Translate the matrix to the texts position and scale
            context.getMatrices().push();
            context.getMatrices().translate(title.x, title.y, 200);
            context.getMatrices().scale(scale, scale, scale);

            //Draw text
            context.drawTextWithShadow(textRenderer, title.getText(), 0, 0, 0xFFFFFF);
            context.getMatrices().pop();

            //Calculate the x and y positions for the next title
            if (direction == SkyblockerConfig.Direction.HORIZONTAL) {
                if (alignment == SkyblockerConfig.Alignment.MIDDLE || alignment == SkyblockerConfig.Alignment.LEFT) {
                    //Move to the right if middle or left aligned
                    x += textRenderer.getWidth(title.getText()) * scale + 10;
                }

                if (alignment == SkyblockerConfig.Alignment.RIGHT) {
                    //Move to the left if right aligned
                    x -= textRenderer.getWidth(title.getText()) * scale + 10;
                }
            } else {
                //Y always moves by the same amount if vertical
                y += textRenderer.fontHeight * scale + 10;
            }
        }
    }
}