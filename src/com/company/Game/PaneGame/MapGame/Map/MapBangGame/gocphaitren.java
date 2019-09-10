package com.company.Game.PaneGame.MapGame.Map.MapBangGame;

import com.company.Library.LoadImage;
import com.company.Game.PaneGame.MapGame.Chung.OVuong;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;

public class gocphaitren extends OVuong {
    private static Image image = LoadImage.load("Image/mapGame/MapBang/gocphai1.png", libarary.WidthOVuong, libarary.WidthOVuong);

    public gocphaitren(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g, JPanel panel) {
        g.drawImage(image, ToaDoX(), ToaDoY(), panel);
    }
}
