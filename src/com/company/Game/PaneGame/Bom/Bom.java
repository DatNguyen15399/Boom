package com.company.Game.PaneGame.Bom;

import com.company.Library.LoadImage;
import com.company.Game.SoundGame;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;

import com.company.Game.PaneGame.MapGame.InputMap;

public class Bom {
    protected static Image image[] = new Image[4];
    protected static Image imageBomNo[] = new Image[10];
    protected libarary.ToaDo Vitri;
    protected int frameBom = 0;
    protected int Speed_BomNo = 15;// 30 * 10;

    public Bom(int x, int y) {
        Vitri = new libarary.ToaDo();
        // kiem tra dể dặt đúng vào ô vuong
        if (x % 3 != 0) {
            x = x + 1;
            if (x % 3 != 0) {
                x = x - 2;
            }
        }
        if (y % 3 != 0) {
            y = y + 1;
            if (y % 3 != 0) {
                y = y - 2;
            }
        }
        Vitri.setToaDo(x, y);
        image[0] = LoadImage.load("image/Bom/bom0.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[1] = LoadImage.load("image/Bom/bom1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[2] = LoadImage.load("image/Bom/bom2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[3] = LoadImage.load("image/Bom/bom3.png", libarary.WidthOVuong, libarary.WidthOVuong);
        imageBomNo[0] = LoadImage.load("image/Bom/trungtam1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        imageBomNo[1] = LoadImage.load("image/Bom/trungtam2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        imageBomNo[2] = LoadImage.load("image/Bom/trai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        imageBomNo[3] = LoadImage.load("image/Bom/trai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        imageBomNo[4] = LoadImage.load("image/Bom/phai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        imageBomNo[5] = LoadImage.load("image/Bom/phai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        imageBomNo[6] = LoadImage.load("image/Bom/tren1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        imageBomNo[7] = LoadImage.load("image/Bom/tren2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        imageBomNo[8] = LoadImage.load("image/Bom/duoi1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        imageBomNo[9] = LoadImage.load("image/Bom/duoi2.png", libarary.WidthOVuong, libarary.WidthOVuong);
    }

    // vẽ bom
    public void drawBom(Graphics2D g, JPanel panel) {
        if (NoLan() && frameBom <= Speed_BomNo) {// kiem tra xem bị nổ nan thì tiến vào trạng thái nổ
            DatViTri();
            frameBom = Speed_BomNo + 1;
            return;
        }
        if (frameBom <= Speed_BomNo) {
            if (libarary.SpeedGame == 50) Speed_BomNo = 30;
            DatViTri();
            g.drawImage(image[(frameBom / (100 / libarary.SpeedGame)) % 4], ToaDoX(), ToaDoY(), panel);
        }
        frameBom++;
    }

    public boolean BomNo(Graphics2D g, JPanel panel) {
        if (frameBom <= Speed_BomNo + 1) {
            // vẽ trung tâm
            g.drawImage(imageBomNo[0], ToaDoX(), ToaDoY(), panel);
            if (frameBom == Speed_BomNo + 1) {
                new SoundGame("Bom").start();// âm thanh
            }
        } else {
            int a;
            // vẽ ảnh nhỏ
            if (frameBom <= Speed_BomNo + 3) {
                a = 0;
            } else {
                a = 1;
            }
            g.drawImage(imageBomNo[a], ToaDoX(), ToaDoY(), panel);
            if (InputMap.Map[Vitri.y + 1][Vitri.x - 1] != libarary.Tuong)
                g.drawImage(imageBomNo[a + 2], ToaDoX() - libarary.WidthOVuong, ToaDoY(), panel); // no trai
            if (InputMap.Map[Vitri.y + 1][Vitri.x + 3] != libarary.Tuong)
                g.drawImage(imageBomNo[a + 4], ToaDoX() + libarary.WidthOVuong, ToaDoY(), panel);//no phai
            if (InputMap.Map[Vitri.y - 1][Vitri.x + 1] != libarary.Tuong)
                g.drawImage(imageBomNo[a + 6], ToaDoX(), ToaDoY() - libarary.WidthOVuong, panel); // no tren
            if (InputMap.Map[Vitri.y + 3][Vitri.x + 1] != libarary.Tuong)
                g.drawImage(imageBomNo[a + 8], ToaDoX(), ToaDoY() + libarary.WidthOVuong, panel); // no duoi
        }
        if (frameBom == Speed_BomNo + 5) {
            QuetPhamViBomNo(1);
            return true;
        }
        return false;
    }

    // quét xung quanh khi nổ
    public void QuetPhamViBomNo(int doRong) {
        for (int i = Vitri.y; i <= Vitri.y + 2; i++)//trung tam
            for (int j = Vitri.x; j <= Vitri.x + 2; j++) {
                if (InputMap.Map[i][j] != libarary.Tuong) {
                    InputMap.Map[i][j] = libarary.DiChuyen;
                }

            }
        //trai
        for (int j = Vitri.x - 1; j >= Vitri.x - (3 * doRong); j--)
            for (int i = Vitri.y; i <= Vitri.y + 2; i++) {
                if (InputMap.Map[i][j] == libarary.Tuong) {
                    j = -1000;
                    break;
                } else if (InputMap.Map[i][j] != libarary.DiChuyen) {
                    InputMap.Map[i][j] = libarary.BomNo;
                    j = -1000;
                    break;
                }
            }
        //phai
        for (int j = Vitri.x + 3; j <= Vitri.x + 2 + (doRong * 3); j++)
            for (int i = Vitri.y; i <= Vitri.y + 2; i++) {
                if (InputMap.Map[i][j] == libarary.Tuong) {
                    j = 1000;
                    break;
                } else if (InputMap.Map[i][j] != libarary.DiChuyen) {
                    InputMap.Map[i][j] = libarary.BomNo;
                    j = 1000;
                    break;
                }

            }
        //tren
        for (int i = Vitri.y - 1; i >= Vitri.y - (3 * doRong); i--) {//tren
            for (int j = Vitri.x; j <= Vitri.x + 2; j++) {
                if (InputMap.Map[i][j] == libarary.Tuong) {
                    i = -1000;
                    break;
                } else if (InputMap.Map[i][j] != libarary.DiChuyen) {
                    InputMap.Map[i][j] = libarary.BomNo;
                    i = -1000;
                    break;
                }
            }
        }
        //duoi
        for (int i = Vitri.y + 3; i <= Vitri.y + 2 + (doRong * 3); i++) {//duoi
            for (int j = Vitri.x; j <= Vitri.x + 2; j++) {
                if (InputMap.Map[i][j] == libarary.Tuong) {
                    i = 1000;
                    break;
                } else if (InputMap.Map[i][j] != libarary.DiChuyen) {
                    InputMap.Map[i][j] = libarary.BomNo;
                    i = 1000;
                    break;
                }
            }
        }
    }

    public void DatViTri() { // dat vi tri moi len mang
        InputMap.Map[Vitri.y][Vitri.x] = InputMap.Map[Vitri.y][Vitri.x + 1] = InputMap.Map[Vitri.y][Vitri.x + 2] = libarary.Bom;
        InputMap.Map[Vitri.y + 1][Vitri.x] = InputMap.Map[Vitri.y + 1][Vitri.x + 1] = InputMap.Map[Vitri.y + 1][Vitri.x + 2] = libarary.Bom;
        InputMap.Map[Vitri.y + 2][Vitri.x] = InputMap.Map[Vitri.y + 2][Vitri.x + 1] = InputMap.Map[Vitri.y + 2][Vitri.x + 2] = libarary.Bom;
    }

    public void XoaViTri() { // dat vi tri moi len mang
        InputMap.Map[Vitri.y][Vitri.x] = InputMap.Map[Vitri.y][Vitri.x + 1] = InputMap.Map[Vitri.y][Vitri.x + 2] = libarary.DiChuyen;
        InputMap.Map[Vitri.y + 1][Vitri.x] = InputMap.Map[Vitri.y + 1][Vitri.x + 1] = InputMap.Map[Vitri.y + 1][Vitri.x + 2] = libarary.DiChuyen;
        InputMap.Map[Vitri.y + 2][Vitri.x] = InputMap.Map[Vitri.y + 2][Vitri.x + 1] = InputMap.Map[Vitri.y + 2][Vitri.x + 2] = libarary.DiChuyen;
    }

    public boolean BomKichHoat() {
        return frameBom > Speed_BomNo;
    }

    // kiem tra xem có bị nổ lan
    private boolean NoLan() {// nổ Lan
        for (int i = Vitri.y; i <= Vitri.y + 2; i++)
            for (int j = Vitri.x; j <= Vitri.x + 2; j++) {
                if (InputMap.Map[i][j] == libarary.BomNo) {
                    return true;
                }
            }
        return false;
    }

    public libarary.ToaDo getVitri() {
        return Vitri;
    }

    public int ToaDoX() {
        return Vitri.x * libarary.WidthOVuong / 3;
    }

    public int ToaDoY() {
        return Vitri.y * libarary.WidthOVuong / 3;
    }
}
