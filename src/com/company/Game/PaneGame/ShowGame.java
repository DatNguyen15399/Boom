package com.company.Game.PaneGame;

import com.company.Game.PaneGame.Bom.Bom;
import com.company.Game.PaneGame.Bom.BomBig;
import com.company.Game.PaneGame.Boomber.*;
import com.company.Game.PaneGame.Enermy.*;
import com.company.Game.PaneGame.MapGame.InputMap;
import com.company.Game.PaneGame.MapGame.MapGame;
import com.company.GameBoom;
import com.company.Library.LoadImage;
import com.company.Game.SoundGame;
import com.company.Library.libarary;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ShowGame extends JPanel {
    private Boomber boomber;
    private MapGame mapGame;
    private ArrayList<Bom> listBom = new ArrayList<>();
    private ArrayList<Enermy> enermies = new ArrayList<>();
    private int WidthCamera, HeightCamera;
    private Image KhungTG;
    private String Time = "00:00";
    private SoundGame sound;
    private boolean TG = true;

    public ShowGame(MapGame mapGame, Boomber boomber) {
        this.mapGame = mapGame;
        this.boomber = boomber;
        BuildBoss();
        setBounds(0, 0, libarary.soCot * libarary.WidthOVuong / 3, libarary.soHang * libarary.WidthOVuong / 3);
        setLayout(null);
        KhungTG = LoadImage.load("image/KhungTG.png", 120, 50);
        setForeground(new Color(0xF6DF31));
        GameBoom.getMainFrame().addKeyListener(boomber.GetKeyListener());
    }

    @Override
    public void setVisible(boolean check) {
        if (check) {
            RestoreGame();
        }
        super.setVisible(check);
        if (check) {
            TG = true;
            sound = new SoundGame("Nền");
            sound.Remuse();
            sound.start();
        } else {
            sound.Stop();
            TG = false;
        }
    }

    // reset lại game
    public void RestoreGame() {
        InputMap.ReloadMap();
        mapGame.RandomVitri();
        mapGame.buildMap();
        listBom.clear();
        BuildBoss();
        boomber.ReloadBoomber(3, 3);
        this.setBackground(new Color(0x4D3E3E));
        Camera();
    }

    // tính thời gian
    private void setThoiGian(int thoiGian) {//don vi giay
        int soPhut = thoiGian / 60;
        int soGiay = thoiGian % 60;
        if (soPhut < 10) {
            Time = "0" + soPhut + ":";
        } else {
            Time = soPhut + ":";
        }
        if (soGiay < 10) {
            Time = Time + "0" + soGiay;
        } else {
            Time = Time + soGiay;
        }
    }

    public void ThoiGian() {
        new Thread() {
            @Override
            public void run() {
                int a = 0;
                while (TG) {
                    setThoiGian(a / 10);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    System.out.println(a);
                    a++;
                }
            }
        }.start();
    }

    // kiem tra game thang hay thua
    public libarary.Game checkGame() {
        if (enermies.size() == 0 && boomber.getViTri().x == mapGame.getVitriDoor().x
                && boomber.getViTri().y == mapGame.getVitriDoor().y) {
            return libarary.Game.win;
        } else {
            if (boomber.getBoomberDie()) {
                return libarary.Game.lose;//game thua
            } else {
                return libarary.Game.play;// game vân đang chơi
            }
        }
    }

    public void setBoomber(Boomber boomber) {
        this.boomber = boomber;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gd2 = (Graphics2D) g;
        super.paint(gd2);
        //vẽ map
        mapGame.drawMap(gd2, this);
        //vẽ bom trong trạng thái chưa nổ
        for (Bom bom : listBom) {
            bom.drawBom(gd2, this);
        }
        // dat bom
        if (boomber.getDatBom()) {
            if (listBom.size() < boomber.getSoBom()) {
                if (boomber.isFlames()) {// kiem tra xem bom của người chơi đang là loại nào để thêm vào list
                    listBom.add(new BomBig(boomber.getViTri().x, boomber.getViTri().y));
                } else {
                    listBom.add(new Bom(boomber.getViTri().x, boomber.getViTri().y));
                }
                if (listBom.size() >= 2) {// kiem tra xem bom dat có trùng nhau
                    for (int i = 0; i < listBom.size() - 1; i++) {
                        if (listBom.get(listBom.size() - 1).getVitri().x == listBom.get(i).getVitri().x && listBom.get(listBom.size() - 1).getVitri().y == listBom.get(i).getVitri().y) {
                            listBom.remove(listBom.size() - 1);
                        }
                    }
                }
            }
            boomber.ResetDatBom();
        }
        // ve bomber
        boomber.Draw(gd2, this);

        //vẽ quái game
        for (Enermy enermy : enermies) {
            enermy.Draw(gd2, this);
        }
        // hien thi khi bom nổ
        for (int i = 0; i < listBom.size(); i++) {
            if (listBom.get(i).BomKichHoat()) {
                if (listBom.get(i).BomNo(gd2, this)) {
                    listBom.remove(i);
                    i--;
                }
            }
        }
        // kierm tra xem boss có bị die không
        for (int i = 0; i < enermies.size(); i++) {
            if (enermies.get(i).CheckDie()) {
                enermies.remove(i);
                i--;
            }
        }
        // vẽ khung thoi gian
        gd2.drawImage(KhungTG, -getX() + (WidthCamera - 120) / 2, -getY() + 3, this);
        gd2.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        gd2.drawString(Time, -getX() + (WidthCamera - 120) / 2 + 20, -getY() + 38);
    }

    // tạo quái trong game
    public void BuildBoss() {
        Random random = new Random();
        enermies.clear();// xóa
        for (int y = 0; y < libarary.soHang; y += 3)
            for (int x = 0; x < libarary.soCot; x += 3) {
                if (InputMap.Map[y][x] == libarary.Boss) {
                    int a = random.nextInt(100);
                    if (a < 70) {
                        int b = random.nextInt(50);
                        if (b < 10) {
                            enermies.add(new RoiHong(x, y));
                        } else if (b < 20) {
                            enermies.add(new RoiXam(x, y));
                        } else if (b < 30) {
                            enermies.add(new RoiNau(x, y));
                        } else if (b < 40) {
                            enermies.add(new RoiXanh(x, y));
                        } else {
                            enermies.add(new RoiDo(x, y));
                        }
                    } else {
                        enermies.add(new Quaiden(x, y));
                    }
                }
            }
    }

    public void Move() {
        boomber.Move();
        for (Enermy e : enermies) {
            e.Move();
        }
    }

    public void setCamera(int W, int H) {
        WidthCamera = W;
        HeightCamera = H;
    }

    // hiển thị map theo boomber
    public void Camera() {
        int w = WidthCamera / 2;
        int h = HeightCamera / 2;
        if (boomber.CMove()) {
            if ((boomber.ToaDoX() - w) >= 0 && (boomber.ToaDoX() + w) <= getWidth()) {// o giau man hinh
                setLocation(-(boomber.ToaDoX() - w), getY());
            } else {
                if (boomber.ToaDoX() - w >= 0) {// lệch phai
                    setLocation(-(getWidth() - WidthCamera), getY());
                } else {
                    setLocation(0, getY());// lệch trái
                }
            }
            if ((boomber.ToaDoY() - h) >= 0 && (boomber.ToaDoY() + h) <= getHeight()) { // o giữa man hình
                setLocation(getX(), -(boomber.ToaDoY() - h));
            } else {
                if (boomber.ToaDoY() - h >= 0) {// lệch dưới
                    setLocation(getX(), -(getHeight() - HeightCamera));
                } else {
                    setLocation(getX(), 0);// lệch trên
                }
            }
        }
    }
}
