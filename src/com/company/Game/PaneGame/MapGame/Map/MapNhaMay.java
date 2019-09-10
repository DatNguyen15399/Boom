package com.company.Game.PaneGame.MapGame.Map;

import com.company.Game.PaneGame.MapGame.InputMap;
import com.company.Game.PaneGame.MapGame.Map.MapNhaMayGame.*;
import com.company.Game.PaneGame.MapGame.MapGame;
import com.company.Library.libarary;

import java.util.Random;

public class MapNhaMay extends MapGame {
    public MapNhaMay() {
        InputMap.setMap("Mapnhamay.txt");
        RandomVitri();
        buildMap();
    }

    @Override
    public void buildMap() {
        listMap.clear();
        for (int y = 0; y < libarary.soHang; y += 3) {
            for (int x = 0; x < libarary.soCot; x += 3) {
                if (InputMap.Map[y][x] == libarary.Tuong) {
                    listMap.add(new Tuong(x, y));
                } else {
                    listMap.add(new NenDichuyen(x, y));
                }
                if (InputMap.Map[y][x] == libarary.Gach) {
                    Random random = new Random();
                    AddItem_And_Door(x, y);
                    int a = random.nextInt(90);
                    if (a < 30)
                        listMap.add(new Gach(x, y));
                    else if (a < 60)
                        listMap.add(new Thung1(x, y));
                    else
                        listMap.add(new Thung2(x, y));
                }
            }
        }
    }
}
