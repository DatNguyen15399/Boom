package com.company.Game.PaneGame.Enermy;

import com.company.Library.LoadImage;
import com.company.Library.libarary;

public class RoiHong extends Enermy {
    public RoiHong(int x, int y) {
        super(x, y);
        image[0] = LoadImage.load("image/boss/RoiHong/len1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[1] = LoadImage.load("image/boss/RoiHong/len2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[2] = LoadImage.load("image/boss/RoiHong/len3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[3] = LoadImage.load("image/boss/RoiHong/xuong1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[4] = LoadImage.load("image/boss/RoiHong/xuong2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[5] = LoadImage.load("image/boss/RoiHong/xuong3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[6] = LoadImage.load("image/boss/RoiHong/trai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[7] = LoadImage.load("image/boss/RoiHong/trai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[8] = LoadImage.load("image/boss/RoiHong/trai3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[9] = LoadImage.load("image/boss/RoiHong/phai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[10] = LoadImage.load("image/boss/RoiHong/phai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[11] = LoadImage.load("image/boss/RoiHong/phai3.png", libarary.WidthOVuong, libarary.WidthOVuong);
    }
}
