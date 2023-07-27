package me.xmrvizzy.skyblocker.skyblock.dungeon;

import me.xmrvizzy.skyblocker.config.SkyblockerConfig;
import me.xmrvizzy.skyblocker.utils.RenderUtils;

public class MouseEvent {
    private final double mouseX;
    private final double mouseY;
    private final int button;
    private final double deltaX;
    private final double deltaY;

    public MouseEvent(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.button = button;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public double getMouseX() {
        return mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }

    public int getButton() {
        return button;
    }

    public double getDeltaX() {
        return deltaX;
    }

    public double getDeltaY() {
        return deltaY;
    }

}
