package com.company.Game.PaneGame.Enermy;

import com.company.Library.LoadImage;
import com.company.Library.libarary;

public class RoiNau extends Enermy {
    public RoiNau(int x, int y) {
        super(x, y);
        image[0] = LoadImage.load("image/boss/RoiNau/len1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[1] = LoadImage.load("image/boss/RoiNau/len2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[2] = LoadImage.load("image/boss/RoiNau/len3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[3] = LoadImage.load("image/boss/RoiNau/xuong1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[4] = LoadImage.load("image/boss/RoiNau/xuong2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[5] = LoadImage.load("image/boss/RoiNau/xuong3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[6] = LoadImage.load("image/boss/RoiNau/trai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[7] = LoadImage.load("image/boss/RoiNau/trai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[8] = LoadImage.load("image/boss/RoiNau/trai3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[9] = LoadImage.load("image/boss/RoiNau/phai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[10] = LoadImage.load("image/boss/RoiNau/phai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[11] = LoadImage.load("image/boss/RoiNau/phai3.png", libarary.WidthOVuong, libarary.WidthOVuong);
    }
}
