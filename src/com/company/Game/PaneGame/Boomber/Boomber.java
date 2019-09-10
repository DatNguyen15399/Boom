package com.company.Game.PaneGame.Boomber;

import com.company.Game.SoundGame;
import com.company.GameBoom;
import com.company.Game.PaneGame.MapGame.InputMap;
import com.company.Library.Move;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class Boomber extends Move implements KeyListener {
    private libarary.ToaDo ViTri = new libarary.ToaDo();
    protected Image[] image = new Image[12];
    protected Image dungIM, Die;
    private boolean DatBom = false;
    private int numberframe = 0;
    private int soBom = 1;
    private boolean flames = false; // do rong bom no;
    private static int Speed = 1;
    private boolean BoomberDie = false;
    private int loadAfterDie = 0;
    private SoundGame soundGame;

    int soNhip = 0;

    public Boomber(int x, int y) {
        ViTri.x = x;
        ViTri.y = y;
        DatViTriMoi();
    }

    @Override
    public void Draw(Graphics2D g, JPanel panel) {
        checkItem();
        if (CheckDie()) {
            AnimationDie(g, panel);
            if (loadAfterDie == 0) {
                soundGame = new SoundGame("die");
                soundGame.start();
            }
            loadAfterDie++;
            if (loadAfterDie == 20) {
                BoomberDie = true;
            }
        } else {
            if (TRANG_THAI == libarary.TrangThai.dungIm) {
                DatViTriMoi();
                g.drawImage(dungIM, ToaDoX(), ToaDoY(), panel);
            } else {
                Move();
                DatViTriMoi();
                super.Draw(g, panel);
                if (soNhip % Speed == Speed - 1) {
                    numberframe++;
                }
                soNhip++;
            }
        }
    }

    @Override
    public void Move() {
        if (soNhip % Speed == 0 && !BoomberDie) {
            super.Move();
        }
    }

    public boolean CMove() {
//        if(soNhip % Speed == 0){
//            return  true;
//        }
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 37) { // sang trai
            TRANG_THAI = libarary.TrangThai.trai;
        } else if (e.getKeyCode() == 38) { // len tren
            TRANG_THAI = libarary.TrangThai.len;
        } else if (e.getKeyCode() == 39) {// sang phai
            TRANG_THAI = libarary.TrangThai.phai;
        } else if (e.getKeyCode() == 40) {//xuong duoi
            TRANG_THAI = libarary.TrangThai.xuong;
        }
        if (e.getKeyCode() == 32) {
            DatBom = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 40) {//duoi
            dungIM = image[0];
            TRANG_THAI = libarary.TrangThai.dungIm;
            numberframe = 0;
            soNhip = 1;
        } else if (e.getKeyCode() == 38) {//tren
            dungIM = image[3];
            TRANG_THAI = libarary.TrangThai.dungIm;
            numberframe = 0;
            soNhip = 1;
        } else if (e.getKeyCode() == 37) {//trai
            dungIM = image[7];
            TRANG_THAI = libarary.TrangThai.dungIm;
            numberframe = 0;
            soNhip = 1;
        } else if (e.getKeyCode() == 39) {//phai
            dungIM = image[10];
            TRANG_THAI = libarary.TrangThai.dungIm;
            numberframe = 0;
            soNhip = 1;
        }
    }

    @Override
    public void AnimationUp(Graphics2D g, JPanel panel) {
        g.drawImage(image[numberframe % 2 + 4], ToaDoX(), ToaDoY(), panel);
    }

    @Override
    public void AnimationDown(Graphics2D g, JPanel panel) {
        g.drawImage(image[numberframe % 2 + 1], ToaDoX(), ToaDoY(), panel);
    }

    @Override
    public void AnimationLeft(Graphics2D g, JPanel panel) {
        g.drawImage(image[numberframe % 2 + 7], ToaDoX(), ToaDoY(), panel);
    }

    @Override
    public void AnimationRight(Graphics2D g, JPanel panel) {
        g.drawImage(image[numberframe % 2 + 10], ToaDoX(), ToaDoY(), panel);
    }

    @Override
    public void AnimationDie(Graphics2D g, JPanel panel) {
        g.drawImage(Die, ToaDoX(), ToaDoY(), panel);
    }

    @Override
    public void MoveUp() {
        if (ViTri.y > 3 && CheckVitri(InputMap.Map[ViTri.y - 1][ViTri.x + 1])) {
            if (CheckVitri2(InputMap.Map[ViTri.y - 1][ViTri.x + 1], InputMap.Map[ViTri.y - 2][ViTri.x + 1])) {
                XoaViTriCu();
                if (!CheckVitri(InputMap.Map[ViTri.y - 1][ViTri.x + 2]) || (InputMap.Map[ViTri.y - 1][ViTri.x + 2] == libarary.Bom && InputMap.Map[ViTri.y - 1][ViTri.x + 1] != libarary.Bom)) {
                    ViTri.x--;
                } else {
                    if (!CheckVitri(InputMap.Map[ViTri.y - 1][ViTri.x]) || (InputMap.Map[ViTri.y - 1][ViTri.x] == libarary.Bom && InputMap.Map[ViTri.y - 1][ViTri.x + 1] != libarary.Bom)) {
                        ViTri.x++;
                    }
                }
                ViTri.y--;
                DatViTriMoi();
            }
        }
    }

    @Override
    public void MoveDown() {
        if (ViTri.y < libarary.soHang - 6 && CheckVitri(InputMap.Map[ViTri.y + 3][ViTri.x + 1])) {
            if (CheckVitri2(InputMap.Map[ViTri.y + 3][ViTri.x + 1], InputMap.Map[ViTri.y + 4][ViTri.x + 1])) {
                XoaViTriCu();
                if (!CheckVitri(InputMap.Map[ViTri.y + 3][ViTri.x + 2]) || (InputMap.Map[ViTri.y + 3][ViTri.x + 2] == libarary.Bom && InputMap.Map[ViTri.y + 3][ViTri.x + 1] != libarary.Bom)) {
                    ViTri.x--;
                } else {
                    if (!CheckVitri(InputMap.Map[ViTri.y + 3][ViTri.x]) || (InputMap.Map[ViTri.y + 3][ViTri.x] == libarary.Bom && InputMap.Map[ViTri.y + 3][ViTri.x + 1] != libarary.Bom)) {
                        ViTri.x++;
                    }
                }
                ViTri.y++;
                DatViTriMoi();
            }
        }
    }

    @Override
    public void MoveLeft() {
        if (ViTri.x > 3 && CheckVitri(InputMap.Map[ViTri.y + 1][ViTri.x - 1])) {
            if (CheckVitri2(InputMap.Map[ViTri.y + 1][ViTri.x - 1], InputMap.Map[ViTri.y + 1][ViTri.x - 2])) {
                XoaViTriCu();
                if (!CheckVitri(InputMap.Map[ViTri.y][ViTri.x - 1]) || (InputMap.Map[ViTri.y][ViTri.x - 1] == libarary.Bom && InputMap.Map[ViTri.y + 1][ViTri.x - 1] != libarary.Bom)) {
                    ViTri.y++;
                } else {
                    if (!CheckVitri(InputMap.Map[ViTri.y + 2][ViTri.x - 1]) || (InputMap.Map[ViTri.y + 2][ViTri.x - 1] == libarary.Bom && InputMap.Map[ViTri.y + 1][ViTri.x - 1] != libarary.Bom)) {
                        ViTri.y--;
                    }
                }
                ViTri.x--;
                DatViTriMoi();
            }
        }
    }

    @Override
    public void MoveRight() {
        if (ViTri.x < libarary.soCot - 6 && CheckVitri(InputMap.Map[ViTri.y + 1][ViTri.x + 3])) {
            if (CheckVitri2(InputMap.Map[ViTri.y + 1][ViTri.x + 3], InputMap.Map[ViTri.y + 1][ViTri.x + 4])) {
                XoaViTriCu();
                if (!CheckVitri(InputMap.Map[ViTri.y][ViTri.x + 3]) || (InputMap.Map[ViTri.y][ViTri.x + 3] == libarary.Bom && InputMap.Map[ViTri.y + 1][ViTri.x + 3] != libarary.Bom)) {
                    ViTri.y++;
                } else {
                    if (!CheckVitri(InputMap.Map[ViTri.y + 2][ViTri.x + 3]) || (InputMap.Map[ViTri.y + 2][ViTri.x + 3] == libarary.Bom && InputMap.Map[ViTri.y + 1][ViTri.x + 3] != libarary.Bom)) {
                        ViTri.y--;
                    }
                }
                ViTri.x++;
                DatViTriMoi();
            }
        }
    }

    private boolean CheckDie() {
        for (int i = ViTri.y; i <= ViTri.y + 2; i++)
            for (int j = ViTri.x; j <= ViTri.x + 2; j++) {
                if (InputMap.Map[i][j] == libarary.BomNo || InputMap.Map[i][j] == libarary.Boss || InputMap.Map[i][j] == libarary.DiChuyen) {
                    GameBoom.getMainFrame().removeKeyListener(this);
                    TRANG_THAI = libarary.TrangThai.dungIm;
                    return true;
                }
            }
        return false;
    }

    private boolean CheckVitri(char key) {
        if (key != libarary.Tuong && key != libarary.Gach) {
            return true;
        }
        return false;
    }

    private boolean CheckVitri2(char key, char key2) {// neu o dang xét là bom nhung vi tri tiep theo khac boom thì di dc
        if (key != libarary.Bom || (key == libarary.Bom && CheckVitri(key2) && key2 != libarary.Bom)) {
            return true;
        }
        return false;
    }

    private void XoaViTriCu() { // xoa vi tri cu tren mang;
        InputMap.Map[ViTri.y][ViTri.x] = InputMap.Map[ViTri.y][ViTri.x + 1] = InputMap.Map[ViTri.y][ViTri.x + 2] = libarary.DiChuyen;
        InputMap.Map[ViTri.y + 1][ViTri.x] = InputMap.Map[ViTri.y + 1][ViTri.x + 1] = InputMap.Map[ViTri.y + 1][ViTri.x + 2] = libarary.DiChuyen;
        InputMap.Map[ViTri.y + 2][ViTri.x] = InputMap.Map[ViTri.y + 2][ViTri.x + 1] = InputMap.Map[ViTri.y + 2][ViTri.x + 2] = libarary.DiChuyen;
    }

    private void DatViTriMoi() { // dat vi tri moi len mang
        InputMap.Map[ViTri.y][ViTri.x] = InputMap.Map[ViTri.y][ViTri.x + 1] = InputMap.Map[ViTri.y][ViTri.x + 2] = libarary.Boomber;
        InputMap.Map[ViTri.y + 1][ViTri.x] = InputMap.Map[ViTri.y + 1][ViTri.x + 1] = InputMap.Map[ViTri.y + 1][ViTri.x + 2] = libarary.Boomber;
        InputMap.Map[ViTri.y + 2][ViTri.x] = InputMap.Map[ViTri.y + 2][ViTri.x + 1] = InputMap.Map[ViTri.y + 2][ViTri.x + 2] = libarary.Boomber;
    }

    public void ReloadBoomber(int x, int y) {
        soBom = 1;
        flames = false;
        Speed = 1;
        ViTri.x = x;
        ViTri.y = y;
        DatViTriMoi();
        TRANG_THAI = libarary.TrangThai.dungIm;
        numberframe = 0;
        soNhip = 0;
        loadAfterDie = 0;
        DatBom = false;
        BoomberDie = false;
        GameBoom.getMainFrame().addKeyListener(this);
    }

    public void checkItem() {
        for (int i = ViTri.y; i <= ViTri.y + 2; i++)
            for (int j = ViTri.x; j <= ViTri.x + 2; j++) {
                if (InputMap.Map[i][j] == libarary.powerup_bombs) {
                    soBom = 2;
                }
                if (InputMap.Map[i][j] == libarary.powerup_flames) {
                    flames = true;
                }
                if (InputMap.Map[i][j] == libarary.powerup_speed) {
                    libarary.SpeedGame = 50;
                }
            }
    }

    public boolean getBoomberDie() {
        return BoomberDie;
    }

    public libarary.ToaDo getViTri() {
        return ViTri;
    }

    public int getSoBom() {
        return soBom;
    }

    public boolean isFlames() {
        return flames;
    }

    public boolean getDatBom() {
        return DatBom;
    }

    public void ResetDatBom() {
        DatBom = false;
    }

    public KeyListener GetKeyListener() {
        return (KeyListener) this;
    }

    public int ToaDoX() {
        return ViTri.x * libarary.WidthOVuong / 3;
    }

    public int ToaDoY() {
        return ViTri.y * libarary.WidthOVuong / 3;
    }
}
