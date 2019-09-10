package com.company.Game.PaneGame.Boomber;

import com.company.Library.LoadImage;
import com.company.Library.libarary;

public class Super extends Boomber {
    public Super(int x, int y) {
        super(x, y);
        image[0] = LoadImage.load("image/bomber/Super/xuong1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[1] = LoadImage.load("image/bomber/Super/xuong2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[2] = LoadImage.load("image/bomber/Super/xuong3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[3] = LoadImage.load("image/bomber/Super/len1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[4] = LoadImage.load("image/bomber/Super/len2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[5] = LoadImage.load("image/bomber/Super/len3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[6] = LoadImage.load("image/bomber/Super/trai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[7] = LoadImage.load("image/bomber/Super/trai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[8] = LoadImage.load("image/bomber/Super/trai3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[9] = LoadImage.load("image/bomber/Super/phai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[10] = LoadImage.load("image/bomber/Super/phai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[11] = LoadImage.load("image/bomber/Super/phai3.png", libarary.WidthOVuong, libarary.WidthOVuong);
        dungIM = image[0];
        Die = LoadImage.load("image/die.png", libarary.WidthOVuong, libarary.WidthOVuong);
    }
}
