package com.company.Game;

import com.company.Game.PaneGame.ShowGame;
import com.company.Game.PaneOption.PaneOptionGame;
import com.company.GameBoom;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PanePlay extends JPanel {
    private int soLanLap = 0;
    private ShowGame showGame;
    private PaneOptionGame paneOptionGame;
    private PaneNotification paneNotification;
    boolean RunGame = true;
    private SoundGame WinOrLose;
    boolean aSound = true;

    public PanePlay() {
        paneOptionGame = new PaneOptionGame();// pane chọn map va boomber
        paneNotification = new PaneNotification(); // pane thông báo
        add(paneOptionGame);
        setLayout(null);
    }

    // trả về thao tác của người dùng cho vòng lặp lớn ở GameBoom xử lí
    public libarary.Click PlayGame() {
        try {
            //bắt sự kiện nhấn dấu X
            GameBoom.getMainFrame().addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    RunGame = false;
                    paneOptionGame.click = libarary.Click.Exit;
                    showGame.setVisible(false);
                }
            });
            // màn hình lụa chọn map và boomber
            paneOptionGame.setVisible(true);
            while (paneOptionGame.click == libarary.Click.KhongClick) {
                paneOptionGame.ShowAllMenu(); // tạo hiệu ứng xoay quanh đối tượng đã chọn
                try {
                    Thread.sleep(150);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (paneOptionGame.click == libarary.Click.Play) {
                // tạo game với map và boomber đã chọn
                showGame = new ShowGame(paneOptionGame.getMapGame(), paneOptionGame.getBoomber());
                showGame.setCamera(getWidth(), getHeight());
                showGame.Camera();//camera
                showGame.setVisible(RunGame);
                add(showGame);
                paneOptionGame.setVisible(false);
                paneNotification.setVisible(false);
                add(paneNotification);
            }
            if (paneOptionGame.click == libarary.Click.Back) {
                paneOptionGame.click = libarary.Click.KhongClick;
                return libarary.Click.Back;
            }
            if (paneOptionGame.click == libarary.Click.Exit) {
                return libarary.Click.Exit;
            }
            soLanLap = 0;
            aSound = true;
            WinOrLose = new SoundGame("Win");
            showGame.ThoiGian();
            // Game
            while (RunGame) {
                if (showGame.isVisible()) {// neu game đang được hiên thị
                    showGame.setCamera(getWidth(), getHeight());
                    showGame.Camera();
                    showGame.repaint(); // vẽ lại game
                }
                //kiem tra
                if (showGame.checkGame() == libarary.Game.lose) {// kiem tra thua thi hien thong bao thua
                    paneNotification.Lose();
                    paneNotification.setVisible(true); //hien thong bao
                    showGame.setVisible(false);// tắt hiển thị game
                } else {
                    if (showGame.checkGame() == libarary.Game.win) {// thang thì hiện thong bao
                        if (aSound) {
                            WinOrLose = new SoundGame("Win");
                            WinOrLose.start();
                            WinOrLose.Remuse();
                            aSound = false;
                        }
                        paneNotification.Win();
                        paneNotification.setVisible(true);//hien thi thong bao
                        showGame.setVisible(false); // tắt hiển thi game
                    }
                }
                if (showGame.checkGame() != libarary.Game.play) {
                    //kiem tra khi hien thông báo thì người chơi click vào đâu
                    if (paneNotification.Click() == libarary.Click.Menu) {// trở lại màn hình bắt đầu
                        paneNotification.setVisible(false);
                        WinOrLose.Stop();
                        return libarary.Click.Menu;
                    } else {
                        if (paneNotification.Click() == libarary.Click.PlayAgain) { // chơi lại
                            showGame.setVisible(true);// hiên thị game và reset lại
                            showGame.ThoiGian();
                            showGame.Camera();// hiển thị map thep nhân vật
                            paneNotification.setVisible(false);
                            soLanLap = -1; // tính thời gian chơi game
                            WinOrLose.Stop();
                            aSound = true;
                        }
                    }
                }
                soLanLap++; //tính thời gian choi game
                Thread.sleep(libarary.SpeedGame);
            }
        } catch (Exception eq) {
            System.out.println(eq);
        }
        return libarary.Click.Exit;
    }
}
