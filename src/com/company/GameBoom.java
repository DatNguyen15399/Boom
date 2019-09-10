package com.company;

import com.company.Game.PanePlay;
import com.company.Game.PaneStart;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameBoom {
    private static JFrame mainFrame = new JFrame("Boom"); // cửa sổ game
    private PaneStart paneStart;
    private PanePlay panePlay;
    boolean runGame = true;

    public GameBoom() {
        mainFrame.setSize(800, 600);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setMinimumSize(new Dimension(900, 700));
        mainFrame.setDefaultCloseOperation(mainFrame.DISPOSE_ON_CLOSE);
        paneStart = new PaneStart();
        mainFrame.add(paneStart);
        mainFrame.setVisible(true);
        panePlay = new PanePlay();
        paneStart.set(mainFrame.getWidth(), mainFrame.getHeight());
    }

    public static JFrame getMainFrame() {
        return mainFrame;
    }

    public void RunGame() {
        // bắt sự kiện nhán dấu X
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                runGame = false;
                paneStart.click = libarary.Click.Dau_X;
            }
        });
        paneStart.setVisible(true);
        panePlay.setVisible(false);
        mainFrame.add(panePlay);
        mainFrame.setVisible(true);
        // vòng lăp game chính
        while (runGame) {
            // đợi đến khi người chơi click vào 1 nút trên màn hinh bắt đầu  như play,help,exit
            while (paneStart.click == libarary.Click.KhongClick) {
                System.out.println("pane start");
            }
            // kiem tra xem người chơi click thoát hoặc nhấn dấu X thì thoát game
            if (paneStart.click == libarary.Click.Exit || paneStart.click == libarary.Click.Dau_X) {
                break;
            }
            // nếu nhấn play thì hien thi game
            if (paneStart.click == libarary.Click.Play) {
                panePlay.setVisible(true);
                paneStart.setVisible(false);// tắt man hinh hiển thị bắt đầu
                libarary.Click click = panePlay.PlayGame(); // chạy game và lấy tuong tác khi kêt thuc 1 game
                // nguoif chơi muốn thoát
                if (click == libarary.Click.Exit) break;
                else {
                    // quay lại menu chính
                    if (click == libarary.Click.Menu || click == libarary.Click.Back) {
                        System.out.println("dat");
                        paneStart.setVisible(true);
                        panePlay.setVisible(false);
                    }
                }
            }
        }
        if (paneStart.click == libarary.Click.Exit) {
            mainFrame.dispose();
        }
    }
}
