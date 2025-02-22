package me.xmrvizzy.skyblocker.skyblock.tabhud.widget;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.xmrvizzy.skyblocker.skyblock.dwarven.DwarvenHud.Commission;
import me.xmrvizzy.skyblocker.skyblock.tabhud.util.Ico;
import me.xmrvizzy.skyblocker.skyblock.tabhud.util.PlayerListMgr;
import me.xmrvizzy.skyblocker.skyblock.tabhud.widget.component.Component;
import me.xmrvizzy.skyblocker.skyblock.tabhud.widget.component.IcoTextComponent;
import me.xmrvizzy.skyblocker.skyblock.tabhud.widget.component.PlainTextComponent;
import me.xmrvizzy.skyblocker.skyblock.tabhud.widget.component.ProgressComponent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.MathHelper;

// this widget shows the status of the king's commissions.
// (dwarven mines and crystal hollows)

public class CommsWidget extends Widget {

    private static final MutableText TITLE = Text.literal("Commissions").formatted(Formatting.DARK_AQUA,
            Formatting.BOLD);

    // match a comm
    // group 1: comm name
    // group 2: comm progress (without "%" for comms that show a percentage)
    private static final Pattern COMM_PATTERN = Pattern.compile("(?<name>.*): (?<progress>.*)%?");

    public CommsWidget() {
        super(TITLE, Formatting.DARK_AQUA.getColorValue());

        for (int i = 50; i <= 53; i++) {
            Matcher m = PlayerListMgr.regexAt(i, COMM_PATTERN);
            // end of comms found?
            if (m == null) {
                if (i == 50) {
                    this.addComponent(new IcoTextComponent());
                }
                break;
            }

            ProgressComponent pc;

            String name = m.group("name");
            String progress = m.group("progress");

            if (progress.equals("DONE")) {
                pc = new ProgressComponent(Ico.BOOK, Text.of(name), Text.of(progress), 100f, pcntToCol(100));
            } else {
                float pcnt = Float.parseFloat(progress.substring(0, progress.length() - 1));
                pc = new ProgressComponent(Ico.BOOK, Text.of(name), pcnt, pcntToCol(pcnt));
            }
            this.addComponent(pc);
        }
        this.pack();
    }

    // for the dwarven hud
    public CommsWidget(List<Commission> commissions, boolean isFancy) {
        super(TITLE, Formatting.AQUA.getColorValue());
        for (Commission comm : commissions) {

            Text c = Text.literal(comm.commission());

            float p = 100f;
            if (!comm.progression().contains("DONE")) {
                p = Float.parseFloat(comm.progression().substring(0, comm.progression().length() - 1));
            }

            Component comp;
            if (isFancy) {
                comp = new ProgressComponent(Ico.BOOK, c, p, pcntToCol(p));
            } else {
                comp = new PlainTextComponent(
                        Text.literal(comm.commission() + ": ")
                                .append(Text.literal(comm.progression()).formatted(Formatting.GREEN)));
            }
            this.addComponent(comp);
        }
        this.pack();

    }

    private int pcntToCol(float pcnt) {
        return MathHelper.hsvToRgb(pcnt / 300f, 0.9f, 0.9f);
    }

}
