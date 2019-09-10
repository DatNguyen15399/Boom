package com.company.Game.PaneGame.Boomber;

import com.company.Library.LoadImage;
import com.company.Library.libarary;

public class Hulk extends Boomber {
    public Hulk(int x, int y) {
        super(x, y);
        image[0] = LoadImage.load("image/Bomber/hulk/hulkxuong1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[1] = LoadImage.load("image/Bomber/hulk/hulkxuong2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[2] = LoadImage.load("image/Bomber/hulk/hulkxuong3.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[3] = LoadImage.load("image/Bomber/hulk/hulklen1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[4] = LoadImage.load("image/Bomber/hulk/hulklen2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[5] = LoadImage.load("image/Bomber/hulk/hulklen3.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[6] = LoadImage.load("image/Bomber/hulk/hulktrai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[7] = LoadImage.load("image/Bomber/hulk/hulktrai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[8] = LoadImage.load("image/Bomber/hulk/hulktrai3.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[9] = LoadImage.load("image/Bomber/hulk/hulkphai1.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[10] = LoadImage.load("image/Bomber/hulk/hulkphai2.png", libarary.WidthOVuong, libarary.WidthOVuong);
        image[11] = LoadImage.load("image/Bomber/hulk/hulkphai3.png", libarary.WidthOVuong, libarary.WidthOVuong);
        dungIM = image[0];
        Die = LoadImage.load("image/die.png", libarary.WidthOVuong, libarary.WidthOVuong);
    }
}
