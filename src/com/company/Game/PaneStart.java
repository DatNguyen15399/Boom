package com.company.Game;

import com.company.Library.LoadImage;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaneStart extends JPanel implements MouseListener {
    private Image background;
    private Image Boom, Logo, bkg, Play[], Help[], Exit[], Back[];
    private JLabel _background, _Boom, _Play, _Help, _Exit, _Back, _KhungHelp;
    public libarary.Click click = libarary.Click.KhongClick;
    private SoundGame soundGame = new SoundGame("Nền Game");

    public PaneStart() {
        Play = new Image[2];
        Exit = new Image[2];
        Help = new Image[2];
        Back = new Image[2];
        background = LoadImage.load("Image/background.jpg", 1366, 680);
        Boom = LoadImage.load("Image/boom.png", 700, 200);
        bkg = LoadImage.load("image/bkg.png", 1500, 800);
        Play[0] = LoadImage.load("image/Play.png", 350, 70);
        Play[1] = LoadImage.load("image/Play2.png", 350, 70);
        Help[0] = LoadImage.load("image/help.png", 350, 70);
        Help[1] = LoadImage.load("image/help2.png", 350, 70);
        Exit[0] = LoadImage.load("image/exit2.png", 350, 70);
        Exit[1] = LoadImage.load("image/exit.png", 350, 70);
        Back[0] = LoadImage.load("image/back.png", 60, 60);
        Back[1] = LoadImage.load("image/back2.png", 60, 60);
        _KhungHelp = new JLabel(new ImageIcon(LoadImage.load("image/khunghelp.png", 900, 600)));
        _KhungHelp.setVisible(false);
        _Back = new JLabel(new ImageIcon(Back[0]));
        _Back.setBounds(70, 70, 60, 60);
        _Back.setVisible(false);
        setLayout(null);
        setSize(1500, 800);
        _background = new JLabel(new ImageIcon(bkg));
        _background.setBounds(0, 0, 1500, 800);
        _Boom = new JLabel(new ImageIcon(Boom));
        _Play = new JLabel(new ImageIcon(Play[0]));
        _Help = new JLabel(new ImageIcon(Help[0]));
        _Exit = new JLabel(new ImageIcon(Exit[0]));
        add(_background);
    }

    // cài đặt kich thước phu hợp với màn hinh ban đầu
    public void set(int Width, int Height) {
        setBounds(0, 0, Width, Height);
        _background.setBounds(0, 0, Width, Height);
        _Boom.setBounds((Width - 700) / 2, 50, 700, 200);
        _Play.setBounds((Width - 350) / 2, 290, 350, 70);
        _Help.setBounds((Width - 350) / 2, 410, 350, 70);
        _Exit.setBounds((Width - 350) / 2, 530, 350, 70);
        _KhungHelp.setBounds((Width - 900) / 2, (Height - 600) / 2 - 60, 900, 600);
        _background.setIcon(new ImageIcon(background.getScaledInstance(Width, Height, Image.SCALE_SMOOTH)));
        add(_KhungHelp);
        add(_Back);
        add(_Boom);
        add(_Play);
        add(_Help);
        add(_Exit);
        add(_background);
        _Play.addMouseListener(this);
        _Help.addMouseListener(this);
        _Exit.addMouseListener(this);
        _Back.addMouseListener(this);
    }

    @Override
    public void setVisible(boolean check) {
        super.setVisible(check);
        if (check) {
            click = libarary.Click.KhongClick;
            soundGame = new SoundGame("Nền Game");
            soundGame.Remuse();
            soundGame.start();
        } else {
            soundGame.Stop();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == _Play) {
            click = libarary.Click.Play;
        } else if (e.getSource() == _Exit) {
            click = libarary.Click.Exit;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        new SoundGame("click").start();
        if (e.getSource() == _Back) {
            _Back.setVisible(false);
            _KhungHelp.setVisible(false);
        }
        if (e.getSource() == _Help) {
            _Back.setVisible(true);
            _KhungHelp.setVisible(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == _Play) {
            _Play.setIcon(new ImageIcon(Play[1]));
        } else if (e.getSource() == _Help) {
            _Help.setIcon(new ImageIcon(Help[1]));
        } else {
            if (e.getSource() == _Exit) {
                _Exit.setIcon(new ImageIcon(Exit[1]));
            }
        }
        if (e.getSource() == _Back) {
            _Back.setIcon(new ImageIcon(Back[1]));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == _Play) {
            _Play.setIcon(new ImageIcon(Play[0]));
        } else if (e.getSource() == _Help) {
            _Help.setIcon(new ImageIcon(Help[0]));
        } else if (e.getSource() == _Exit) {
            _Exit.setIcon(new ImageIcon(Exit[0]));
        }
        if (e.getSource() == _Back) {
            _Back.setIcon(new ImageIcon(Back[0]));
        }
    }
}
