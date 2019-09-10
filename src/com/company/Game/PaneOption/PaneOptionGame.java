package com.company.Game.PaneOption;

import com.company.Game.PaneGame.Boomber.Boomber;
import com.company.Game.PaneGame.MapGame.MapGame;
import com.company.Game.PaneOption.Menu.MenuBoomber;
import com.company.Game.PaneOption.Menu.MenuMap;
import com.company.Game.SoundGame;
import com.company.GameBoom;
import com.company.Library.LoadImage;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaneOptionGame extends JPanel implements MouseListener {
    private MenuMap menuMap;
    private MenuBoomber menuBoomber;
    public libarary.Click click = libarary.Click.KhongClick;
    private Image[] Start, Back;
    private Image background;
    private JLabel _Start, _background, _Back;
    int Level;

    public PaneOptionGame() {
        setLayout(null);
        setBounds(0, 0, GameBoom.getMainFrame().getWidth(), GameBoom.getMainFrame().getHeight());
        setBackground(new Color(0xDAE1E6));

        Start = new Image[2];
        Back = new Image[2];
        Start[0] = LoadImage.load("image/start.png", 70, 40);
        Start[1] = LoadImage.load("image/start2.png", 70, 40);
        Back[0] = LoadImage.load("image/back.png", 60, 60);
        Back[1] = LoadImage.load("image/back2.png", 60, 60);
        background = LoadImage.load("image/background.jpg", GameBoom.getMainFrame().getWidth(), GameBoom.getMainFrame().getHeight());
        _Start = new JLabel(new ImageIcon(Start[0]));
        _Start.setBounds((getWidth() - 70) / 2, getHeight() / 10 * 7, 70, 50);
        _Back = new JLabel(new ImageIcon(Back[0]));
        _Back.setBounds(70, 70, 60, 60);
        _background = new JLabel(new ImageIcon(background));
        _background.setBounds(-10, -13, GameBoom.getMainFrame().getWidth(), GameBoom.getMainFrame().getHeight() - 10);

        menuMap = new MenuMap(1000, 200, this);
        menuMap.setLocation(230, 100);
        menuBoomber = new MenuBoomber(1000, 200, this);
        menuBoomber.setLocation(550, 350);
        menuBoomber.setItem(60, 120);
        add(_Start);
        add(_Back);
        add(_background);
        _Start.addMouseListener(this);
        _Back.addMouseListener(this);
    }

    @Override
    public void setVisible(boolean a) {
        if (!a) {
            click = libarary.Click.KhongClick;
        }
        super.setVisible(a);
    }

    // tao hieu ung chuyen dong
    public void ShowAllMenu() {
        menuMap.ShowKhung();
        menuBoomber.ShowKhung();
    }

    public MapGame getMapGame() {
        return menuMap.getMapGame();
    }

    public Boomber getBoomber() {
        return menuBoomber.getBoomber();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == _Start) {
            click = libarary.Click.Play;
            new SoundGame("click").start();
        }
        if (e.getSource() == _Back) {
            click = libarary.Click.Back;
            new SoundGame("click").start();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == _Start) {
            _Start.setIcon(new ImageIcon(Start[1]));
        }
        if (e.getSource() == _Back) {
            _Back.setIcon(new ImageIcon(Back[1]));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == _Start) {
            _Start.setIcon(new ImageIcon(Start[0]));
        }
        if (e.getSource() == _Back) {
            _Back.setIcon(new ImageIcon(Back[0]));
        }
    }
}
