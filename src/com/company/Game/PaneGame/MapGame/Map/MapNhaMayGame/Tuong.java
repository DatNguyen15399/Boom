package com.company.Game.PaneGame.MapGame.Map.MapNhaMayGame;

import com.company.Library.LoadImage;
import com.company.Game.PaneGame.MapGame.Chung.OVuong;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;

public class Tuong extends OVuong {
    private static Image image = LoadImage.load("image/MapGame/MapNhaMay/tuong.png", libarary.WidthOVuong, libarary.WidthOVuong);

    public Tuong(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g, JPanel panel) {
        g.drawImage(image, ToaDoX(), ToaDoY(), panel);
    }
}
