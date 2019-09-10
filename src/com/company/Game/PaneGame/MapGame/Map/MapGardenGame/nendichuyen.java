package com.company.Game.PaneGame.MapGame.Map.MapGardenGame;

import com.company.Library.LoadImage;
import com.company.Game.PaneGame.MapGame.Chung.OVuong;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;

public class nendichuyen extends OVuong {
    private static Image image = LoadImage.load("Image/mapgame/MapGarden/nendichuyen.png", libarary.WidthOVuong, libarary.WidthOVuong);

    public nendichuyen(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g, JPanel panel) {
        g.drawImage(image, ToaDoX(), ToaDoY(), panel);
    }
}
