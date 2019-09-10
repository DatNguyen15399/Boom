package com.company.Game.PaneGame.Bom;

import com.company.Game.PaneGame.MapGame.InputMap;
import com.company.Game.SoundGame;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;

public class BomBig extends Bom {
    private int widthTrai, widthPhai, widthTren, widthDuoi;

    public BomBig(int x, int y) {
        super(x, y);
    }

    // kiem tra xem bom nổ xong chưa để remove khỏi list bom trong show game
    public boolean BomNo(Graphics2D g, JPanel panel) {
        if (frameBom <= Speed_BomNo + 1) {
            //vẽ trung tam
            g.drawImage(imageBomNo[0], ToaDoX(), ToaDoY(), panel);
            if (frameBom == Speed_BomNo + 1) {
                new SoundGame("Bom").start();// âm thanh
                SetWidth();
            }
        } else {
            int a;
            if (frameBom <= Speed_BomNo + 3) {
                a = 0;
            } else {
                a = 1;
            }
            g.drawImage(imageBomNo[a], ToaDoX(), ToaDoY(), panel);
            //trai
            if (com.company.Game.PaneGame.MapGame.InputMap.Map[Vitri.y + 1][Vitri.x - 1] != libarary.Tuong) {
                g.drawImage(imageBomNo[a + 2], ToaDoX() - libarary.WidthOVuong * widthTrai, ToaDoY(), panel); // no trai
            }
            //phai
            if (com.company.Game.PaneGame.MapGame.InputMap.Map[Vitri.y + 1][Vitri.x + 3] != libarary.Tuong) {
                g.drawImage(imageBomNo[a + 4], ToaDoX() + libarary.WidthOVuong, ToaDoY(), panel);//no phai
            }
            //tren
            if (com.company.Game.PaneGame.MapGame.InputMap.Map[Vitri.y - 1][Vitri.x + 1] != libarary.Tuong) {
                g.drawImage(imageBomNo[a + 6], ToaDoX(), ToaDoY() - libarary.WidthOVuong * widthTren, panel); // no tren
            }
            //duoi
            if (InputMap.Map[Vitri.y + 3][Vitri.x + 1] != libarary.Tuong) {
                g.drawImage(imageBomNo[a + 8], ToaDoX(), ToaDoY() + libarary.WidthOVuong, panel); // no duoi
            }
        }
        if (frameBom == Speed_BomNo + 5) {
            QuetPhamViBomNo(2);// tiêu diệt mục tiêu xung quanh
            return true;
        }
        return false;
    }

    public void SetWidth() {
        widthTrai = 1;
        if (InputMap.Map[Vitri.y + 1][Vitri.x - 1] == libarary.DiChuyen && InputMap.Map[Vitri.y + 1][Vitri.x - 4] != libarary.Tuong) {
            widthTrai = 2;
        }
        widthPhai = 1;
        if (InputMap.Map[Vitri.y + 1][Vitri.x + 3] == libarary.DiChuyen && InputMap.Map[Vitri.y + 1][Vitri.x + 6] != libarary.Tuong) {
            widthPhai = 2;
        }
        widthTren = 1;
        if (InputMap.Map[Vitri.y - 1][Vitri.x + 1] == libarary.DiChuyen && InputMap.Map[Vitri.y - 4][Vitri.x + 1] != libarary.Tuong) {
            widthTren = 2;
        }
        widthDuoi = 1;
        if (InputMap.Map[Vitri.y + 3][Vitri.x + 1] == libarary.DiChuyen && InputMap.Map[Vitri.y + 6][Vitri.x + 1] != libarary.Tuong) {
            widthDuoi = 2;
        }
        imageBomNo[2] = imageBomNo[2].getScaledInstance(libarary.WidthOVuong * widthTrai, libarary.WidthOVuong, Image.SCALE_SMOOTH);
        imageBomNo[3] = imageBomNo[3].getScaledInstance(libarary.WidthOVuong * widthTrai, libarary.WidthOVuong, Image.SCALE_SMOOTH);
        imageBomNo[4] = imageBomNo[4].getScaledInstance(libarary.WidthOVuong * widthPhai, libarary.WidthOVuong, Image.SCALE_SMOOTH);
        imageBomNo[5] = imageBomNo[5].getScaledInstance(libarary.WidthOVuong * widthPhai, libarary.WidthOVuong, Image.SCALE_SMOOTH);
        imageBomNo[6] = imageBomNo[6].getScaledInstance(libarary.WidthOVuong, libarary.WidthOVuong * widthTren, Image.SCALE_SMOOTH);
        imageBomNo[7] = imageBomNo[7].getScaledInstance(libarary.WidthOVuong, libarary.WidthOVuong * widthTren, Image.SCALE_SMOOTH);
        imageBomNo[8] = imageBomNo[8].getScaledInstance(libarary.WidthOVuong, libarary.WidthOVuong * widthDuoi, Image.SCALE_SMOOTH);
        imageBomNo[9] = imageBomNo[9].getScaledInstance(libarary.WidthOVuong, libarary.WidthOVuong * widthDuoi, Image.SCALE_SMOOTH);


    }
}