package com.company.Game.PaneGame.MapGame.Item;

import com.company.Library.LoadImage;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;

public class powerup_speed extends item {
    private static Image image = LoadImage.load("image/item/speed.png", libarary.WidthOVuong, libarary.WidthOVuong);

    public powerup_speed(int x, int y) {
        super(x, y);
        Kitu = libarary.powerup_speed;
    }

    @Override
    public void draw(Graphics2D g, JPanel panel) {
        g.drawImage(image, ToaDoX(), ToaDoY(), panel);
    }
}
