package com.company.Game.PaneOption.Menu;

import com.company.Game.SoundGame;
import com.company.Library.LoadImage;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ScrollItem implements MouseListener {
    protected ArrayList<JLabel> listLabel = new ArrayList<>();
    protected ArrayList<ImageIcon> imageIcons = new ArrayList<>();
    private JLabel TenTrai, TenPhai, Khung;
    private Image image[] = new Image[4];
    private ImageIcon _Khung[] = new ImageIcon[3];
    protected int WidthMT, HeightMT;
    protected int WidthItem, HeightItem;
    private int[] Vitri = {100, 101, 102};
    protected int Luachon = Vitri[0];
    private libarary.ToaDo TD = new libarary.ToaDo();
    private int numberFrame = 0;

    public ScrollItem(int W, int H, JPanel panel) {
        TD.x = 0;
        TD.y = 0;
        WidthItem = W / 4;
        HeightItem = H / 10 * 9;
        image[0] = LoadImage.load("Image/menumap/tentrai.png", WidthItem / 5, HeightItem / 4);
        image[1] = LoadImage.load("Image/menumap/tentrai2.png", WidthItem / 5, HeightItem / 4);
        image[2] = LoadImage.load("Image/menumap/tenphai.png", WidthItem / 5, HeightItem / 4);
        image[3] = LoadImage.load("Image/menumap/tenphai2.png", WidthItem / 5, HeightItem / 4);
        TenTrai = new JLabel(new ImageIcon(image[0]));
        TenPhai = new JLabel(new ImageIcon(image[2]));
        _Khung[0] = new ImageIcon(LoadImage.load("image/menumap/Khung1.png", WidthItem + 10, HeightItem + 10));
        _Khung[1] = new ImageIcon(LoadImage.load("image/menumap/Khung2.png", WidthItem + 10, HeightItem + 10));
        _Khung[2] = new ImageIcon(LoadImage.load("image/menumap/Khung3.png", WidthItem + 10, HeightItem + 10));
        Khung = new JLabel(_Khung[0]);
        Khung.setSize(WidthItem + 10, HeightItem + 10);
        panel.add(Khung);
        TenPhai.addMouseListener(this);
        TenTrai.addMouseListener(this);
        panel.add(TenTrai);
        panel.add(TenPhai);
    }

    public void setItem(int W, int H) {
        WidthItem = W;
        HeightItem = H;
        _Khung[0] = new ImageIcon(LoadImage.load("image/menumap/Khung1.png", WidthItem + 10, HeightItem + 10));
        _Khung[1] = new ImageIcon(LoadImage.load("image/menumap/Khung2.png", WidthItem + 10, HeightItem + 10));
        _Khung[2] = new ImageIcon(LoadImage.load("image/menumap/Khung3.png", WidthItem + 10, HeightItem + 10));
        Khung.setIcon(_Khung[0]);
        Khung.setSize(WidthItem + 10, HeightItem + 10);
        image[0] = LoadImage.load("Image/menumap/tentrai.png", WidthItem / 5, HeightItem / 4);
        image[1] = LoadImage.load("Image/menumap/tentrai2.png", WidthItem / 5, HeightItem / 4);
        image[2] = LoadImage.load("Image/menumap/tenphai.png", WidthItem / 5, HeightItem / 4);
        image[3] = LoadImage.load("Image/menumap/tenphai2.png", WidthItem / 5, HeightItem / 4);
        TenTrai.setIcon(new ImageIcon(image[0]));
        TenPhai.setIcon(new ImageIcon(image[2]));
    }

    public void setLocation(int x, int y) {
        TD.x = x;
        TD.y = y;
        ShowItem();
    }

    public void ShowItem() {
        int x = TD.x + WidthItem / 5 + 10;
        int y = TD.y + HeightItem / 20;
        TenTrai.setBounds(TD.x, TD.y + HeightItem / 8 * 3, WidthItem / 5, HeightItem / 4);
        for (int i = 0; i < listLabel.size(); i++) {
            listLabel.get(i).setVisible(false);
        }
        listLabel.get(Vitri[0] % listLabel.size()).setVisible(true);
        listLabel.get(Vitri[0] % listLabel.size()).setLocation(x, y);
        x = x + WidthItem + 20;
        listLabel.get(Vitri[1] % listLabel.size()).setVisible(true);
        listLabel.get(Vitri[1] % listLabel.size()).setLocation(x, y);
        x = x + WidthItem + 20;
        listLabel.get(Vitri[2] % listLabel.size()).setVisible(true);
        listLabel.get(Vitri[2] % listLabel.size()).setLocation(x, y);
        x = x + WidthItem + 10;
        TenPhai.setBounds(x, TD.y + HeightItem / 8 * 3, WidthItem / 5, HeightItem / 4);
    }

    public void ShowKhung() {
        for (int i = 0; i < 3; i++) {
            if (Luachon == Vitri[i] % listLabel.size()) {
                Khung.setLocation(listLabel.get(Vitri[i] % listLabel.size()).getX() - 5,
                        listLabel.get(Vitri[i] % listLabel.size()).getY() - 5);
                Khung.setIcon(_Khung[numberFrame % 3]);
                break;
            }
            if (i == 2) {
                Khung.setLocation(listLabel.get(Vitri[0] % listLabel.size()).getX() - 5,
                        listLabel.get(Vitri[0] % listLabel.size()).getY() - 5);
                Khung.setIcon(_Khung[numberFrame % 3]);
                Luachon = Vitri[0] % listLabel.size();
            }
        }
        numberFrame++;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        new SoundGame("click").start();
        for (int i = 0; i < listLabel.size(); i++) {
            if (e.getSource() == listLabel.get(i)) {
                Luachon = i;
            }
        }
        if (e.getSource() == TenTrai) {
            Vitri[0] -= 1;
            if (Vitri[0] == 0) Vitri[0] = listLabel.size() * 10;
            Vitri[1] -= 1;
            if (Vitri[1] == 0) Vitri[1] = listLabel.size() * 10;
            Vitri[2] -= 1;
            if (Vitri[2] == 0) Vitri[2] = listLabel.size() * 10;
        }
        if (e.getSource() == TenPhai) {
            Vitri[0] += 1;
            Vitri[1] += 1;
            Vitri[2] += 1;
        }
        ShowItem();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == TenPhai) {
            TenPhai.setIcon(new ImageIcon(image[3]));
        } else {
            if (e.getSource() == TenTrai) {
                TenTrai.setIcon(new ImageIcon(image[1]));
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == TenPhai) {
            TenPhai.setIcon(new ImageIcon(image[2]));
        } else {
            if (e.getSource() == TenTrai) {
                TenTrai.setIcon(new ImageIcon(image[0]));
            }
        }
    }
}
