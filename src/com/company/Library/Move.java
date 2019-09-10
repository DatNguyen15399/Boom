package com.company.Library;

import javax.swing.*;
import java.awt.*;

public abstract class Move {
    protected libarary.TrangThai TRANG_THAI = libarary.TrangThai.dungIm;

    public void Draw(Graphics2D g, JPanel panel) {
        if (TRANG_THAI == libarary.TrangThai.len) {
            AnimationUp(g, panel);
        } else if (TRANG_THAI == libarary.TrangThai.xuong) {
            AnimationDown(g, panel);
        } else if (TRANG_THAI == libarary.TrangThai.trai) {
            AnimationLeft(g, panel);
        } else if (TRANG_THAI == libarary.TrangThai.phai) {
            AnimationRight(g, panel);
        }
    }

    public abstract void AnimationUp(Graphics2D g, JPanel panel);

    public abstract void AnimationDown(Graphics2D g, JPanel panel);

    public abstract void AnimationLeft(Graphics2D g, JPanel panel);

    public abstract void AnimationRight(Graphics2D g, JPanel panel);

    public abstract void AnimationDie(Graphics2D g, JPanel panel);

    public void Move() {
        if (TRANG_THAI == libarary.TrangThai.len) {
            MoveUp();
        } else if (TRANG_THAI == libarary.TrangThai.xuong) {
            MoveDown();
        } else if (TRANG_THAI == libarary.TrangThai.trai) {
            MoveLeft();
        } else if (TRANG_THAI == libarary.TrangThai.phai) {
            MoveRight();
        }
    }

    public abstract void MoveUp();

    public abstract void MoveDown();

    public abstract void MoveLeft();

    public abstract void MoveRight();
}
