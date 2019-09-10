package com.company.Game.PaneGame.Enermy;

import com.company.Library.LoadImage;
import com.company.Library.libarary;

public class RoiXanh extends Enermy {
    public RoiXanh(int x, int y) {
        super(x, y);
        image[0] = LoadImage.load("image/boss/RoiXanh/len1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[1] = LoadImage.load("image/boss/RoiXanh/len2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[2] = LoadImage.load("image/boss/RoiXanh/len3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[3] = LoadImage.load("image/boss/RoiXanh/xuong1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[4] = LoadImage.load("image/boss/RoiXanh/xuong2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[5] = LoadImage.load("image/boss/RoiXanh/xuong3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[6] = LoadImage.load("image/boss/RoiXanh/trai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[7] = LoadImage.load("image/boss/RoiXanh/trai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[8] = LoadImage.load("image/boss/RoiXanh/trai3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[9] = LoadImage.load("image/boss/RoiXanh/phai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[10] = LoadImage.load("image/boss/RoiXanh/phai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[11] = LoadImage.load("image/boss/RoiXanh/phai3.png", libarary.WidthOVuong, libarary.WidthOVuong);
    }
}
