package com.company.Game.PaneGame.MapGame.Map;

import com.company.Game.PaneGame.MapGame.InputMap;
import com.company.Game.PaneGame.MapGame.Map.MapCityGame.*;
import com.company.Game.PaneGame.MapGame.MapGame;
import com.company.Library.libarary;

import java.util.Random;

public class MapCity extends MapGame {
    public MapCity() {
        InputMap.setMap("mapcity.txt");
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
                } else {
                    if (InputMap.Map[y][x] == libarary.Tuong) {
                        listMap.add(new NenNha(x, y));
                        Random random = new Random();
                        int a = random.nextInt(100);
                        if (a < 5) {
                            listMap.add(new Nha1(x, y));
                        } else if (a < 5 * 2) {
                            listMap.add(new Nha2(x, y));
                        } else if (a < 5 * 3) {
                            listMap.add(new Nha3(x, y));
                        } else if (a < 5 * 4) {
                            listMap.add(new Nha4(x, y));
                        } else if (a < 5 * 5) {
                            listMap.add(new Nha5(x, y));
                        } else if (a < 5 * 6) {
                            listMap.add(new Nha6(x, y));
                        } else if (a < 5 * 7) {
                            listMap.add(new Nha7(x, y));
                        } else if (a < 5 * 8) {
                            listMap.add(new Nha8(x, y));
                        } else if (a < 5 * 9) {
                            listMap.add(new Nha9(x, y));
                        } else if (a < 5 * 10) {
                            listMap.add(new Nha10(x, y));
                        } else if (a < 5 * 11) {
                            listMap.add(new Nha11(x, y));
                        } else if (a < 5 * 12) {
                            listMap.add(new Nha12(x, y));
                        } else if (a < 5 * 13) {
                            listMap.add(new Nha13(x, y));
                        } else if (a < 5 * 14) {
                            listMap.add(new Nha14(x, y));
                        } else if (a < 5 * 15) {
                            listMap.add(new Nha15(x, y));
                        } else if (a < 5 * 16) {
                            listMap.add(new Nha16(x, y));
                        } else if (a < 5 * 17) {
                            listMap.add(new Nha17(x, y));
                        } else if (a < 5 * 18) {
                            listMap.add(new Nha18(x, y));
                        } else if (a < 5 * 19) {
                            listMap.add(new Nha19(x, y));
                        } else if (a < 100) {
                            listMap.add(new Nha20(x, y));
                        }
                    } else {
                        listMap.add(new NenCity(x, y));
                    }

                    if (InputMap.Map[y][x] == libarary.Gach) {
                        listMap.add(new NenCity(x, y));
                        Random random = new Random();
                        AddItem_And_Door(x, y);
                        listMap.add(new Gach(x, y));
                    }
                }
            }
    }
}
