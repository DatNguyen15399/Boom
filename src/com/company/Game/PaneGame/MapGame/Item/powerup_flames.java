package com.company.Game.PaneGame.MapGame.Item;

import com.company.Library.LoadImage;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;

public class powerup_flames extends item {
    private static Image image = LoadImage.load("image/item/bomlon.png", libarary.WidthOVuong, libarary.WidthOVuong);

    public powerup_flames(int x, int y) {
        super(x, y);
        Kitu = libarary.powerup_flames;
    }

    @Override
    public void draw(Graphics2D g, JPanel panel) {
        g.drawImage(image, ToaDoX(), ToaDoY(), panel);
    }
}
