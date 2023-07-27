package me.xmrvizzy.skyblocker.skyblock.dungeon;

import java.awt.Color;

import me.shedaniel.autoconfig.AutoConfig;
import me.xmrvizzy.skyblocker.config.SkyblockerConfig;
import me.xmrvizzy.skyblocker.config.getConfig;
import me.xmrvizzy.skyblocker.utils.RenderUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class DungeonMapConfigScreen extends Screen {

	private int hudX = getConfig.get().locations.dungeons.mapX;
	private int hudY = getConfig.get().locations.dungeons.mapY;

	protected DungeonMapConfigScreen() {
		super(Text.literal("Dungeon Map Config"));
	}

	@Override
	public void render(DrawContext context, int mouseX, int mouseY, float delta) {
		super.render(context, mouseX, mouseY, delta);
		renderBackground(context);
		DungeonMap.renderHUDMap(context, hudX, hudY);
		context.drawCenteredTextWithShadow(textRenderer, "Right Click To Reset Position", width >> 1, height >> 1, Color.GRAY.getRGB());
	}


	public boolean mouseDragged(MouseEvent event) {
		float scaling = getConfig.get().locations.dungeons.mapScaling;
		int size = (int) (128 * scaling);

		if (RenderUtils.pointExistsInArea((int) event.getMouseX(), (int) event.getMouseY(), hudX, hudY, hudX + size, hudY + size)
				&& event.getButton() == 0) {
			hudX = (int) Math.max(Math.min(event.getMouseX() - (size >> 1), this.width - size), 0);
			hudY = (int) Math.max(Math.min(event.getMouseY() - (size >> 1), this.height - size), 0);
		}

		return super.mouseDragged(event.getMouseX(), event.getMouseY(), event.getButton(), event.getDeltaX(), event.getDeltaY());
	}


	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		if (button == 1) {
			hudX = 2;
			hudY = 2;
		}

		return super.mouseClicked(mouseX, mouseY, button);
	}

	@Override
	public void close() {
		getConfig.get().locations.dungeons.mapX = hudX;
		getConfig.get().locations.dungeons.mapY = hudY;
		AutoConfig.getConfigHolder(SkyblockerConfig.class).save();
		super.close();
	}
}
