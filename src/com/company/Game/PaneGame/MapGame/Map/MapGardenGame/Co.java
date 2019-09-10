package com.company.Game.PaneGame.MapGame.Map.MapGardenGame;

import com.company.Library.LoadImage;
import com.company.Game.PaneGame.MapGame.Chung.PhaHuyDuoc;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;

public class Co extends PhaHuyDuoc {
    private static Image image = LoadImage.load("image/MapGame/MapGarden/co.png", libarary.WidthOVuong, libarary.WidthOVuong);

    public Co(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g, JPanel panel) {
        g.drawImage(image, ToaDoX(), ToaDoY(), panel);
    }
}
