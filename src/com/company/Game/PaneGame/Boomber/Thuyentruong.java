package com.company.Game.PaneGame.Boomber;

import com.company.Library.LoadImage;
import com.company.Library.libarary;

public class Thuyentruong extends Boomber {
    public Thuyentruong(int x, int y) {
        super(x, y);
        image[0] = LoadImage.load("image/bomber/Thuyentruong/xuong1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[1] = LoadImage.load("image/bomber/Thuyentruong/xuong2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[2] = LoadImage.load("image/bomber/Thuyentruong/xuong3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[3] = LoadImage.load("image/bomber/Thuyentruong/len1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[4] = LoadImage.load("image/bomber/Thuyentruong/len2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[5] = LoadImage.load("image/bomber/Thuyentruong/len3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[6] = LoadImage.load("image/bomber/Thuyentruong/trai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[7] = LoadImage.load("image/bomber/Thuyentruong/trai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[8] = LoadImage.load("image/bomber/Thuyentruong/trai3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[9] = LoadImage.load("image/bomber/Thuyentruong/phai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[10] = LoadImage.load("image/bomber/Thuyentruong/phai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[11] = LoadImage.load("image/bomber/Thuyentruong/phai3.png", libarary.WidthOVuong, libarary.WidthOVuong);
        dungIM = image[0];
        Die = LoadImage.load("image/die.png", libarary.WidthOVuong, libarary.WidthOVuong);
    }
}
