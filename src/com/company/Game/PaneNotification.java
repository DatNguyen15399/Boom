package com.company.Game;

import com.company.GameBoom;
import com.company.Library.LoadImage;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaneNotification extends JPanel implements MouseListener {
    private JLabel Win, Lose, background, Broad1, Broad2, baGach, playAgain, next, _3Sao, _0Sao;
    private Image _Win, _Lose, _background, _Broad1, _Broad2, _3Gach, _3Gach2, _playAgain, _playAgain2, _next, _next2, __3Sao, __0Sao;
    private libarary.Click click = libarary.Click.KhongClick;

    public PaneNotification() {
        setLayout(null);
        setBounds(0, 0, GameBoom.getMainFrame().getWidth(), GameBoom.getMainFrame().getHeight());
        _background = LoadImage.load("image/background.jpg", getWidth(), getHeight());
        _Broad1 = LoadImage.load("image/thongbao/nenThongBao.png", 700, 550);
        _Broad2 = LoadImage.load("image/thongbao/nenmenu.png", 200, 400);
        _3Gach = LoadImage.load("image/thongbao/menu.png", 70, 70);
        _playAgain = LoadImage.load("image/thongbao/reload.png", 90, 90);
        _next = LoadImage.load("image/thongbao/tieptuc.png", 70, 70);
        _3Gach2 = LoadImage.load("image/thongbao/menu2.png", 70, 70);
        _playAgain2 = LoadImage.load("image/thongbao/reload2.png", 90, 90);
        _next2 = LoadImage.load("image/thongbao/tieptuc2.png", 70, 70);

        __3Sao = LoadImage.load("image/thongbao/3sao.png", 350, 200);
        __0Sao = LoadImage.load("image/thongbao/0sao.png", 350, 200);
        _Win = LoadImage.load("image/thongbao/win.png", 200, 60);
        _Lose = LoadImage.load("image/thongbao/lose.png", 200, 60);

        background = new JLabel(new ImageIcon(_background));
        background.setBounds(0, 0, getWidth(), getHeight());
        Broad1 = new JLabel(new ImageIcon(_Broad1));
        Broad1.setBounds((getWidth() - 700) / 2, 70, 700, 550);

        Broad2 = new JLabel(new ImageIcon(_Broad2));
        Broad2.setBounds((getWidth() - 200) / 2, (getHeight() - 400) / 2, 200, 400);
        baGach = new JLabel(new ImageIcon(_3Gach));
        baGach.setBounds(Broad1.getX() + 150, Broad1.getY() + 455, 70, 70);
        playAgain = new JLabel(new ImageIcon(_playAgain));
        playAgain.setBounds(Broad1.getX() + 290, Broad1.getY() + 447, 90, 90);
        next = new JLabel(new ImageIcon(_next));
        next.setBounds(Broad1.getX() + 440, Broad1.getY() + 455, 70, 70);
        _3Sao = new JLabel(new ImageIcon(__3Sao));
        _3Sao.setBounds(Broad1.getX() + (700 - 350) / 2, Broad1.getY() + 100, 350, 200);
        _0Sao = new JLabel(new ImageIcon(__0Sao));
        _0Sao.setBounds(Broad1.getX() + (700 - 350) / 2, Broad1.getY() + 100, 350, 200);
        Win = new JLabel(new ImageIcon(_Win));
        Win.setBounds(Broad1.getX() + (700 - 200) / 2, Broad1.getY() + 10, 200, 60);
        Lose = new JLabel(new ImageIcon(_Lose));
        Lose.setBounds(Broad1.getX() + (700 - 200) / 2, Broad1.getY() + 10, 200, 60);

        baGach.addMouseListener(this);
        playAgain.addMouseListener(this);
        next.addMouseListener(this);
        add(Lose);
        add(Win);
        add(_3Sao);
        add(baGach);
        add(playAgain);
        add(next);
        add(_0Sao);
        add(Broad1);
        add(background);
    }

    // thông báo khi thua
    public void Lose() {
        Lose.setVisible(true);
        Win.setVisible(false);
        _3Sao.setVisible(false);
        _0Sao.setVisible(true);
    }

    // thong báo khi thắng
    public void Win() {
        Lose.setVisible(false);
        Win.setVisible(true);
        _3Sao.setVisible(true);
        _0Sao.setVisible(false);
    }

    //thao tac cua ngươi chơi
    public libarary.Click Click() {
        return click;
    }

    @Override
    public void setVisible(boolean a) {
        if (!a) {
            click = libarary.Click.KhongClick;
        }
        super.setVisible(a);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == baGach) {
            click = libarary.Click.Menu;
            new SoundGame("click").start();
        }
        if (e.getSource() == playAgain) {
            click = libarary.Click.PlayAgain;
            new SoundGame("click").start();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == baGach) {
            baGach.setIcon(new ImageIcon(_3Gach2));
        }
        if (e.getSource() == next) {
            next.setIcon(new ImageIcon(_next2));
        }
        if (e.getSource() == playAgain) {
            playAgain.setIcon(new ImageIcon(_playAgain2));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == baGach) {
            baGach.setIcon(new ImageIcon(_3Gach));
        }
        if (e.getSource() == next) {
            next.setIcon(new ImageIcon(_next));
        }
        if (e.getSource() == playAgain) {
            playAgain.setIcon(new ImageIcon(_playAgain));
        }
    }
}
