package com.company.Game.PaneGame.Enermy.AI;

import java.util.ArrayList;

public class AI_ {
    private static class vitri {
        public vitri(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;
    }

    ArrayList<vitri> listVitri = new ArrayList<>();
    ArrayList<vitri> list = new ArrayList<>();

    public AI_() {
        list.add(new vitri(-1, 0));
        list.add(new vitri(1, 0));
        list.add(new vitri(0, 1));
        list.add(new vitri(0, -1));
    }

    private static int VitriKetThuc = 2;

    public void SearchRoad(int[][] arr, int x, int y) {
        int _x = -1, _y = -1;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                if (arr[i][j] == VitriKetThuc) {
                    _x = j;
                    _y = i;
                    break;
                }
        System.out.println(_x);
        System.out.println(_y);
        if (_x >= 0 && _y >= 0) {
            listVitri.clear();
            Search(arr, x, y);
        }
    }

    public boolean Search(int[][] arr, int x, int y) {
        if (y >= 0 && y < arr.length && x >= 0 && x < arr[0].length) {
            if (arr[y][x] == VitriKetThuc) {
                arr[y][x] = 9;
                return true;
            }
            if (arr[y][x] == 0) {
                arr[y][x] = 5;
                boolean a;
                for (int i = 0; i < 4; i++) {
                    a = Search(arr, x + list.get(i).x, y + list.get(i).y);
                    if (a) {
                        listVitri.add(new vitri(x, y));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void prinnt() {
        for (int i = 0; i < listVitri.size(); i++) {
            System.out.println(listVitri.get(i).x + " " + listVitri.get(i).y);
        }
    }
}
