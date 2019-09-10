package com.company.Game.PaneGame.MapGame.Chung;

import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;

public abstract class OVuong {
    protected libarary.ToaDo Vitri;

    public abstract void draw(Graphics2D g, JPanel panel);

    public OVuong(int x, int y) {
        Vitri = new libarary.ToaDo();
        Vitri.x = x;
        Vitri.y = y;
    }

    public int ToaDoX() {
        return Vitri.x * libarary.WidthOVuong / 3;
    }

    public int ToaDoY() {
        return Vitri.y * libarary.WidthOVuong / 3;
    }

    public boolean PhaHuy() {
        return false;
    }
}
