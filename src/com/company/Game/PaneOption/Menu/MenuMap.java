package com.company.Game.PaneOption.Menu;

import com.company.Game.PaneGame.MapGame.Map.MapBang;
import com.company.Game.PaneGame.MapGame.Map.MapCity;
import com.company.Game.PaneGame.MapGame.Map.MapGarden;
import com.company.Game.PaneGame.MapGame.Map.MapNhaMay;
import com.company.Game.PaneGame.MapGame.MapGame;
import com.company.Library.LoadImage;

import javax.swing.*;

public class MenuMap extends ScrollItem {
    private MapGame mapGame;

    public MenuMap(int W, int H, JPanel panel) {
        super(W, H, panel);
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menumap/mapbang.png", WidthItem, HeightItem)));
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menumap/mapgarden.png", WidthItem, HeightItem)));
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menumap/mapnhamay.png", WidthItem, HeightItem)));
        imageIcons.add(new ImageIcon(LoadImage.load("Image/menumap/mapcity.png", WidthItem, HeightItem)));
        listLabel.add(new JLabel(imageIcons.get(0)));
        listLabel.add(new JLabel(imageIcons.get(1)));
        listLabel.add(new JLabel(imageIcons.get(2)));
        listLabel.add(new JLabel(imageIcons.get(3)));
        for (JLabel label : listLabel) {
            label.setSize(WidthItem, HeightItem);
            panel.add(label);
            label.addMouseListener(this);
        }
        mapGame = new MapBang();
        ShowItem();
    }

    public MapGame getMapGame() {
        if (Luachon == 0) {
            mapGame = new MapBang();
        } else if (Luachon == 1) {
            mapGame = new MapGarden();
        } else if (Luachon == 2) {
            mapGame = new MapNhaMay();
        } else if (Luachon == 3) {
            mapGame = new MapCity();
        }
        return mapGame;
    }
}
