package com.company.Game.PaneGame.MapGame;

import com.company.Library.libarary;

import java.io.*;
import java.util.ArrayList;

public class InputMap {
    private static ArrayList<String> FileMap = new ArrayList<>();
    public static char[][] Map;

    public static void setMap(String name) {
        ReaderMap(name);
        libarary.soHang = FileMap.size() * 3;
        libarary.soCot = FileMap.get(0).length() * 3;
        Map = new char[libarary.soHang][libarary.soCot];
        ReloadMap();
    }

    public static void ReloadMap() {
        for (int i = 0; i < libarary.soHang; i += 3) {
            for (int j = 0; j < libarary.soCot; j += 3) {
                if (FileMap.get(i / 3).charAt(j / 3) == libarary.Tuong) {
                    Map[i][j] = Map[i][j + 1] = Map[i][j + 2] = libarary.Tuong;
                    Map[i + 1][j] = Map[i + 1][j + 1] = Map[i + 1][j + 2] = libarary.Tuong;
                    Map[i + 2][j] = Map[i + 2][j + 1] = Map[i + 2][j + 2] = libarary.Tuong;
                }
                if (FileMap.get(i / 3).charAt(j / 3) == libarary.DiChuyen) {
                    Map[i][j] = Map[i][j + 1] = Map[i][j + 2] = libarary.DiChuyen;
                    Map[i + 1][j] = Map[i + 1][j + 1] = Map[i + 1][j + 2] = libarary.DiChuyen;
                    Map[i + 2][j] = Map[i + 2][j + 1] = Map[i + 2][j + 2] = libarary.DiChuyen;
                }
                if (FileMap.get(i / 3).charAt(j / 3) == libarary.Gach) {
                    Map[i][j] = Map[i][j + 1] = Map[i][j + 2] = libarary.Gach;
                    Map[i + 1][j] = Map[i + 1][j + 1] = Map[i + 1][j + 2] = libarary.Gach;
                    Map[i + 2][j] = Map[i + 2][j + 1] = Map[i + 2][j + 2] = libarary.Gach;
                }
                if (FileMap.get(i / 3).charAt(j / 3) == libarary.Boss) {
                    Map[i][j] = Map[i][j + 1] = Map[i][j + 2] = libarary.Boss;
                    Map[i + 1][j] = Map[i + 1][j + 1] = Map[i + 1][j + 2] = libarary.Boss;
                    Map[i + 2][j] = Map[i + 2][j + 1] = Map[i + 2][j + 2] = libarary.Boss;
                }

            }
        }
    }

    public static void printMap() {
        for (int i = 0; i < FileMap.size(); i++) {
            System.out.println(FileMap.get(i));
        }
    }

    public static void ReaderMap(String name) {
        try {
            FileMap.clear();
            File file = new File("Map/" + name);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            line = bufferedReader.readLine();
            while (line != null) {
                FileMap.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
