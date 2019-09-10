package com.company.Library;

// thuộc tính dùng chung cho toàn game
public class libarary {
    public static int soCot = 75;
    public static int soHang = 51;
    public static int SpeedGame = 100;
    public static final int WidthOVuong = 51;
    public static final char DiChuyen = 'O';
    public static final char Tuong = '#';
    public static final char Gach = 'G';
    public static final char Boomber = 'B';
    public static final char Boss = 'Q';
    public static final char BomNo = 'N';
    public static final char Bom = 'X';
    public static final char powerup_bombs = 'E';
    public static final char powerup_flames = 'F';
    public static final char powerup_speed = 'S';

    public static class ToaDo {
        public int x, y;

        public ToaDo() {
            x = 0;
            y = 0;
        }

        public void setToaDo(int a, int b) {
            x = a;
            y = b;
        }
    }

    public enum TrangThai {len, xuong, phai, trai, dungIm}

    public enum Game {win, lose, play}

    public enum Click {PlayAgain, Menu, Next, Exit, Play, Help, Dau_X, KhongClick, Back}
}
