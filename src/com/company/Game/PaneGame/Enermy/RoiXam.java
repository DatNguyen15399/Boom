package com.company.Game.PaneGame.Enermy;

import com.company.Library.LoadImage;
import com.company.Library.libarary;

public class RoiXam extends Enermy {
    public RoiXam(int x, int y) {
        super(x, y);
        image[0] = LoadImage.load("image/boss/RoiXam/len1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[1] = LoadImage.load("image/boss/RoiXam/len2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[2] = LoadImage.load("image/boss/RoiXam/len3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[3] = LoadImage.load("image/boss/RoiXam/xuong1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[4] = LoadImage.load("image/boss/RoiXam/xuong2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[5] = LoadImage.load("image/boss/RoiXam/xuong3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[6] = LoadImage.load("image/boss/RoiXam/trai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[7] = LoadImage.load("image/boss/RoiXam/trai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[8] = LoadImage.load("image/boss/RoiXam/trai3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[9] = LoadImage.load("image/boss/RoiXam/phai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[10] = LoadImage.load("image/boss/RoiXam/phai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[11] = LoadImage.load("image/boss/RoiXam/phai3.png", libarary.WidthOVuong, libarary.WidthOVuong);
    }
}
