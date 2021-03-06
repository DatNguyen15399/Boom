package com.company.Game.PaneGame.MapGame.Map.MapCityGame;

import com.company.Library.LoadImage;
import com.company.Game.PaneGame.MapGame.Chung.OVuong;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;

public class Nha5 extends OVuong {
    private static Image image = LoadImage.load("image/MapGame/Mapcity/nha5.png", libarary.WidthOVuong, libarary.WidthOVuong);

    public Nha5(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g, JPanel panel) {
        g.drawImage(image, ToaDoX(), ToaDoY(), panel);
    }
}
