package com.company.Game.PaneGame.MapGame.Item;

import com.company.Library.LoadImage;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;

public class powerup_bombs extends item {
    private static Image image = LoadImage.load("image/item/x2Bom.png", libarary.WidthOVuong, libarary.WidthOVuong);

    public powerup_bombs(int x, int y) {
        super(x, y);
        Kitu = libarary.powerup_bombs;
    }

    //    public void DatViTriMoi() { // dat vi tri moi len mang
//        InputMap.Map[Vitri.y][Vitri.x] = InputMap.Map[Vitri.y][Vitri.x + 1] = InputMap.Map[Vitri.y][Vitri.x + 2] = libarary.Boomber;
//        InputMap.Map[Vitri.y + 1][Vitri.x] = InputMap.Map[Vitri.y + 1][Vitri.x + 1] = InputMap.Map[Vitri.y + 1][Vitri.x + 2] = libarary.Boomber;
//        InputMap.Map[Vitri.y + 2][Vitri.x] = InputMap.Map[Vitri.y + 2][Vitri.x + 1] = InputMap.Map[Vitri.y + 2][Vitri.x + 2] = libarary.Boomber;
//    }
    @Override
    public void draw(Graphics2D g, JPanel panel) {
        g.drawImage(image, ToaDoX(), ToaDoY(), panel);
    }
}
