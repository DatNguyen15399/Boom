package com.company.Game.PaneOption.Menu;

import com.company.Game.PaneGame.Boomber.*;
import com.company.Library.LoadImage;

import javax.swing.*;

public class MenuBoomber extends ScrollItem {
    public MenuBoomber(int W, int H, JPanel panel) {
        super(W, H, panel);
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menubomber/hulk.png", WidthItem, HeightItem)));
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menubomber/ninja.png", WidthItem, HeightItem)));
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menubomber/thosan.png", WidthItem, HeightItem)));
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menubomber/thuyentruong.png", WidthItem, HeightItem)));
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menubomber/thanchet.png", WidthItem, HeightItem)));
        imageIcons.add(new ImageIcon(LoadImage.load("image/menubomber/super.png", WidthItem, HeightItem)));
        for (int i = 0; i < imageIcons.size(); i++) {
            listLabel.add(new JLabel(imageIcons.get(i)));
        }
        for (JLabel label : listLabel) {
            label.setSize(WidthItem, HeightItem);
            panel.add(label);
            label.addMouseListener(this);
        }
    }

    @Override
    public void setItem(int W, int H) {
        super.setItem(W, H);
        imageIcons.clear();
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menubomber/hulk.png", WidthItem, HeightItem)));
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menubomber/ninja.png", WidthItem, HeightItem)));
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menubomber/thosan.png", WidthItem, HeightItem)));
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menubomber/thuyentruong.png", WidthItem, HeightItem)));
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menubomber/thanchet.png", WidthItem, HeightItem)));
        imageIcons.add(new ImageIcon(LoadImage.load("image/menubomber/super.png", WidthItem, HeightItem)));
        for (int i = 0; i < listLabel.size(); i++) {
            listLabel.get(i).setSize(WidthItem, HeightItem);
            listLabel.get(i).setIcon(imageIcons.get(i));
        }
        ShowItem();
    }

    public Boomber getBoomber() {
        if (Luachon == 0) {
            return new Hulk(3, 3);
        }
        if (Luachon == 1) {
            return new Ninja(3, 3);
        }
        if (Luachon == 2) {
            return new ThoSan(3, 3);
        }
        if (Luachon == 3) {
            return new Thuyentruong(3, 3);
        }
        if (Luachon == 4) {
            return new ThanChet(3, 3);
        }
        if (Luachon == 5) {
            return new Super(3, 3);
        }
        return new Hulk(3, 3);
    }
}
