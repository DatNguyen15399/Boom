package com.company.Library;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadImage {
    public static Image load(String linkImage, int width, int height) {
        try {
            BufferedImage image = ImageIO.read(new File(linkImage));
            return image.getScaledInstance(width, height, image.SCALE_SMOOTH);
        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }
}
