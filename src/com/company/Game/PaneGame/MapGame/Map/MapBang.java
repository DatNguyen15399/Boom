package com.company.Game.PaneGame.MapGame.Map;

import com.company.Game.PaneGame.MapGame.InputMap;
import com.company.Game.PaneGame.MapGame.Map.MapBangGame.*;
import com.company.Game.PaneGame.MapGame.MapGame;
import com.company.Library.libarary;

import java.util.Random;

public class MapBang extends MapGame {
    public MapBang() {
        InputMap.setMap("Test.txt");
        RandomVitri();
        buildMap();
    }

    @Override
    public void buildMap() {
        listMap.clear();
        for (int y = 0; y < libarary.soHang; y += 3)
            for (int x = 0; x < libarary.soCot; x += 3) {
                // tạo viền khung của map
                if (x == 0 && y == 0) {
                    listMap.add(new goctraitren(x, y));
                } else if (x == 0 && y == libarary.soHang - 3) {
                    listMap.add(new goctraiduoi(x, y));
                } else if (x == libarary.soCot - 3 && y == 0) {
                    listMap.add(new gocphaitren(x, y));
                } else if (x == libarary.soCot - 3 && y == libarary.soHang - 3) {
                    listMap.add(new gocphaiduoi(x, y));
                } else if (x == 0) {
                    listMap.add(new tuongtrai(x, y));
                } else if (x == libarary.soCot - 3) {
                    listMap.add(new tuongphai(x, y));
                } else if (y == 0) {
                    listMap.add(new tuongtren(x, y));
                } else if (y == libarary.soHang - 3) {
                    listMap.add(new tuongduoi(x, y));
                } else if (InputMap.Map[y][x] == libarary.Tuong) {
                    listMap.add(new nenBang(x, y));
                    listMap.add(new caybang(x, y));
                } else {
                    // thêm các vật phá được và item
                    listMap.add(new nenBang(x, y));
                    if (InputMap.Map[y][x] == libarary.Gach) {
                        Random random = new Random();
                        int a = random.nextInt(160);
                        AddItem_And_Door(x, y);
                        // random hiển thị vật phá được
                        if (a < 40) {
                            listMap.add(new Gach(x, y));
                        } else if (a < 80) {
                            listMap.add(new NguoiTuyet(x, y));
                        } else if (a < 120) {
                            listMap.add(new Thung1(x, y));
                        } else {
                            listMap.add(new Thung2(x, y));
                        }
                    }
                }
            }
    }
}
