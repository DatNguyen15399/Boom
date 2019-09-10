package com.company.Game.PaneGame.MapGame.Map.MapBangGame;

import com.company.Library.LoadImage;
import com.company.Game.PaneGame.MapGame.Chung.PhaHuyDuoc;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;

public class Thung2 extends PhaHuyDuoc {
    private static Image image = LoadImage.load("image/MapGame/MapBang/Thung2.png", libarary.WidthOVuong, libarary.WidthOVuong);

    public Thung2(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g, JPanel panel) {
        g.drawImage(image, ToaDoX(), ToaDoY(), panel);
    }
}
