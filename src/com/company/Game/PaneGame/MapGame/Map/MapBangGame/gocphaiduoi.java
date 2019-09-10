package com.company.Game.PaneGame.MapGame.Map.MapBangGame;

import com.company.Library.LoadImage;
import com.company.Game.PaneGame.MapGame.Chung.OVuong;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;

public class gocphaiduoi extends OVuong {
    private static Image image = LoadImage.load("Image/mapGame/MapBang/gocphai2.png", libarary.WidthOVuong, libarary.WidthOVuong);

    public gocphaiduoi(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g, JPanel panel) {
        g.drawImage(image, ToaDoX(), ToaDoY(), panel);
    }
}
