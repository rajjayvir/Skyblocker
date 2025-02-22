package me.xmrvizzy.skyblocker.skyblock.tabhud.widget;

import me.xmrvizzy.skyblocker.skyblock.tabhud.util.PlayerListMgr;
import me.xmrvizzy.skyblocker.skyblock.tabhud.widget.component.PlainTextComponent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class GardenVisitorsWidget extends Widget {
	private static final MutableText TITLE = Text.literal("Visitors").formatted(Formatting.DARK_GREEN, Formatting.BOLD);

	public GardenVisitorsWidget() {
		super(TITLE, Formatting.DARK_GREEN.getColorValue());
		
		if (PlayerListMgr.textAt(54) == null) {
			this.addComponent(new PlainTextComponent(Text.literal("No visitors!").formatted(Formatting.GRAY)));
			this.pack();
			
			return;
		}
		
		for (int i = 54; i < 59; i++) {
			String text = PlayerListMgr.strAt(i);
			if (text != null) this.addComponent(new PlainTextComponent(Text.literal(text)));
		}
		
		this.pack();
	}
}
