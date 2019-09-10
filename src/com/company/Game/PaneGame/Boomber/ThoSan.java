package com.company.Game.PaneGame.Boomber;

import com.company.Library.LoadImage;
import com.company.Library.libarary;

public class ThoSan extends Boomber {
    public ThoSan(int x, int y) {
        super(x, y);
        image[0] = LoadImage.load("image/bomber/tho/xuong1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[1] = LoadImage.load("image/bomber/tho/xuong2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[2] = LoadImage.load("image/bomber/tho/xuong3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[3] = LoadImage.load("image/bomber/tho/len1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[4] = LoadImage.load("image/bomber/tho/len2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[5] = LoadImage.load("image/bomber/tho/len3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[6] = LoadImage.load("image/bomber/tho/trai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[7] = LoadImage.load("image/bomber/tho/trai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[8] = LoadImage.load("image/bomber/tho/trai3.png", libarary.WidthOVuong, libarary.WidthOVuong);

        image[9] = LoadImage.load("image/bomber/tho/phai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[10] = LoadImage.load("image/bomber/tho/phai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[11] = LoadImage.load("image/bomber/tho/phai3.png", libarary.WidthOVuong, libarary.WidthOVuong);
        dungIM = image[0];
        Die = LoadImage.load("image/die.png", libarary.WidthOVuong, libarary.WidthOVuong);
    }
}
