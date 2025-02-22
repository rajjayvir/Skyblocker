package me.xmrvizzy.skyblocker.skyblock.tabhud.screens.main;



import me.xmrvizzy.skyblocker.skyblock.tabhud.screens.Screen;
import me.xmrvizzy.skyblocker.skyblock.tabhud.widget.FireSaleWidget;
import me.xmrvizzy.skyblocker.skyblock.tabhud.widget.ServerWidget;


import net.minecraft.text.Text;

public class HubServerScreen extends Screen {

    public HubServerScreen(int w, int h, Text footer) {
        super(w, h);

        ServerWidget sw = new ServerWidget();
        FireSaleWidget fsw = new FireSaleWidget();

        this.centerW(sw);
        this.centerW(fsw);
        this.stackWidgetsH(sw, fsw);
        this.addWidgets(sw, fsw);
    }

}
