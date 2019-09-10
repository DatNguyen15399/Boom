package com.company.Game.PaneGame.MapGame.Map;

import com.company.Game.PaneGame.MapGame.InputMap;
import com.company.Game.PaneGame.MapGame.Map.MapGardenGame.*;
import com.company.Game.PaneGame.MapGame.MapGame;
import com.company.Library.libarary;

import java.util.Random;

public class MapGarden extends MapGame {
    public MapGarden() {
        InputMap.setMap("mapGarden.txt");
        RandomVitri();
        buildMap();
    }

    @Override
    public void buildMap() {
        listMap.clear();
        for (int y = 0; y < libarary.soHang; y += 3)
            for (int x = 0; x < libarary.soCot; x += 3) {
                if ((x == 0 || x == libarary.soCot - 3) && y < libarary.soHang - 3) {
                    listMap.add(new Tuongdoc(x, y));
                } else if (y == 0 || y == libarary.soHang - 3) {
                    listMap.add(new tuongngang(x, y));
                } else if (InputMap.Map[y][x] == libarary.Tuong) {
                    Random random = new Random();
                    int a = random.nextInt(90);
                    listMap.add(new nendat(x, y));
                    if (a < 30) {
                        listMap.add(new cay1(x, y));
                    } else if (a < 60) {
                        listMap.add(new cay2(x, y));
                    } else {
                        listMap.add(new tre(x, y));
                    }
                } else {
                    listMap.add(new nendichuyen(x, y));
                }

                if (InputMap.Map[y][x] == libarary.Gach) {
                    listMap.add(new nendichuyen(x, y));
                    Random random = new Random();
                    AddItem_And_Door(x, y);
                    listMap.add(new Co(x, y));
                }
            }
    }
}
