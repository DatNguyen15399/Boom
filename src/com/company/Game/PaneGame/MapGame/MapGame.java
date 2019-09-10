package com.company.Game.PaneGame.MapGame;

import com.company.Game.PaneGame.MapGame.Chung.Door;
import com.company.Game.PaneGame.MapGame.Chung.OVuong;
import com.company.Game.PaneGame.MapGame.Item.powerup_bombs;
import com.company.Game.PaneGame.MapGame.Item.powerup_flames;
import com.company.Game.PaneGame.MapGame.Item.powerup_speed;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class MapGame {
    public abstract void buildMap();

    protected ArrayList<OVuong> listMap = new ArrayList<>();
    protected libarary.ToaDo VitriDoor = new libarary.ToaDo();
    protected libarary.ToaDo VitriItemFlames = new libarary.ToaDo();
    protected libarary.ToaDo VitriItemBombs = new libarary.ToaDo();
    protected libarary.ToaDo VitriItemSpeed = new libarary.ToaDo();

    public libarary.ToaDo getVitriDoor() {
        return VitriDoor;
    }

    public void drawMap(Graphics2D g, JPanel panel) {
        for (int i = 0; i < listMap.size(); i++) {
            listMap.get(i).draw(g, panel);
            if (listMap.get(i).PhaHuy()) {
                listMap.remove(i);
                i--;
            }
        }
    }

    // tạo vị trí ngẫu nhiên các item và cửa thắng
    public void RandomVitri() {
        Random random = new Random();
        int x;
        int y;
        while (true) {
            y = random.nextInt(libarary.soHang / 3);
            x = random.nextInt(libarary.soCot / 3);
            if (InputMap.Map[y * 3][x * 3] == libarary.Gach) {
                VitriDoor.x = x * 3;
                VitriDoor.y = y * 3;
                System.out.println(x * 3);
                System.out.println(y * 3);
                break;
            }
        }
        while (true) {
            y = random.nextInt(libarary.soHang / 3);
            x = random.nextInt(libarary.soCot / 3);
            if (InputMap.Map[y * 3][x * 3] == libarary.Gach &&
                    (VitriDoor.x / 3 != x || VitriDoor.y / 3 != y)) {
                VitriItemFlames.x = x * 3;
                VitriItemFlames.y = y * 3;
                break;
            }
        }
        while (true) {
            y = random.nextInt(libarary.soHang / 3);
            x = random.nextInt(libarary.soCot / 3);
            if (InputMap.Map[y * 3][x * 3] == libarary.Gach &&
                    (VitriDoor.x / 3 != x || VitriDoor.y / 3 != y) &&
                    (VitriItemFlames.x / 3 != x || VitriItemFlames.y / 3 != y)) {
                VitriItemBombs.x = x * 3;
                VitriItemBombs.y = y * 3;
                break;
            }
        }
        while (true) {
            y = random.nextInt(libarary.soHang / 3);
            x = random.nextInt(libarary.soCot / 3);
            if (InputMap.Map[y * 3][x * 3] == libarary.Gach &&
                    (VitriDoor.x / 3 != x || VitriDoor.y / 3 != y) &&
                    (VitriItemFlames.x / 3 != x || VitriItemFlames.y / 3 != y) &&
                    (VitriItemBombs.x / 3 != x || VitriItemBombs.y / 3 != y)) {
                VitriItemSpeed.x = x * 3;
                VitriItemSpeed.y = y * 3;
                break;
            }
        }
    }

    // hàm dùng chung add item và cửa
    public void AddItem_And_Door(int x, int y) {
        if (y == VitriItemBombs.y && x == VitriItemBombs.x) {
            listMap.add(new powerup_bombs(x, y));
        } else if (y == VitriItemFlames.y && x == VitriItemFlames.x) {
            listMap.add(new powerup_flames(x, y));
        } else if (y == VitriItemSpeed.y && x == VitriItemSpeed.x) {
            listMap.add(new powerup_speed(x, y));
        } else if (y == VitriDoor.y && x == VitriDoor.x) {
            listMap.add(new Door(x, y));
        }
    }
}
