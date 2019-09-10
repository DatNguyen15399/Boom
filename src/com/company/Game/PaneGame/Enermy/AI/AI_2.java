package com.company.Game.PaneGame.Enermy.AI;

import com.company.Game.PaneGame.MapGame.InputMap;
import com.company.Library.libarary;

import java.util.ArrayList;

public class AI_2 {
    static int arr[][];
    static int KhongDichuyen = 1;
    static int DichDen = 2;
    static int Dichuyen = 0;
    static int a = 3;

    public static libarary.TrangThai SearchRoad(int x, int y, int PhamVi) {
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(PhamVi + 1, PhamVi + 1, null));
        arr = new int[PhamVi * 2][PhamVi * 2];
        Node node = null;
        if (setArray2(x, y, PhamVi)) {
            a = 3;
            node = Search(list);
            if (node == null) return libarary.TrangThai.dungIm;
            while (node.pre != null) {
                if ((node.pre).pre == null) {
                    if (node == node.pre.trai) return libarary.TrangThai.trai;
                    if (node == node.pre.phai) return libarary.TrangThai.phai;
                    if (node == node.pre.tren) return libarary.TrangThai.len;
                    if (node == node.pre.duoi) return libarary.TrangThai.xuong;
                }
                node = node.pre;
            }
        }
        return libarary.TrangThai.dungIm;
    }

    private static Node Search(ArrayList<Node> list) {
        ArrayList<Node> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;
            if (y >= 0 && y < arr.length && x >= 0 && x < arr[0].length) {
                if (arr[y][x] == DichDen) {
                    return list.get(i);
                }
                if (arr[y][x] == Dichuyen) {
                    arr[y][x] = a;
                    Node n = new Node(x + 1, y, list.get(i));
                    list.get(i).phai = n;
                    list2.add(n);
                    Node n2 = new Node(x - 1, y, list.get(i));
                    list.get(i).trai = n2;
                    list2.add(n2);
                    Node n3 = new Node(x, y + 1, list.get(i));
                    list.get(i).duoi = n3;
                    list2.add(n3);
                    Node n4 = new Node(x, y - 1, list.get(i));
                    list.get(i).tren = n4;
                    list2.add(n4);
                }
            }
        }
        if (list.size() > 0) {
            a++;
            return Search(list2);
        }
        return null;
    }

    private static boolean setArray2(int x, int y, int PhamVi) {
        int n = 0, m = 0;
        boolean checkDichDen = false;// kiểm tra boomber có ở trong phạm vi
        for (int i = y - PhamVi; i < y + PhamVi; i++) {
            m = 0;
            for (int j = x - PhamVi; j < x + PhamVi; j++) {
                arr[n][m] = KhongDichuyen;
                if (i >= 0 && j >= 0 && i < libarary.soHang && j < libarary.soCot) {
                    if (i % 3 == 1 || j % 3 == 1) {
                        if (InputMap.Map[i][j] == libarary.Gach || InputMap.Map[i][j] == libarary.Tuong || InputMap.Map[i][j] == libarary.Bom) {
                            arr[n][m] = KhongDichuyen;
                        } else if (InputMap.Map[i][j] == libarary.Boomber) {
                            arr[n][m] = DichDen;
                            checkDichDen = true;
                        } else {
                            arr[n][m] = Dichuyen;
                        }
                    }
                }
                m++;
            }
            n++;
        }
        return checkDichDen;
    }

    public static void print() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] < 10) {
                    System.out.print(arr[i][j] + "  ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

class Node {
    int x, y;
    Node trai;
    Node phai;
    Node tren;
    Node duoi;
    Node pre;

    public Node(int x, int y, Node pre) {
        this.x = x;
        this.y = y;
        this.pre = pre;
        trai = phai = tren = duoi = null;
    }
}
