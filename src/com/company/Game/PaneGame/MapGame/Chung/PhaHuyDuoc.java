package com.company.Game.PaneGame.MapGame.Chung;

import com.company.Game.PaneGame.MapGame.InputMap;
import com.company.Library.libarary;

public abstract class PhaHuyDuoc extends OVuong {
    public PhaHuyDuoc(int x, int y) {
        super(x, y);
    }

    public void XoaVitri() {
        for (int i = Vitri.y; i <= Vitri.y + 2; i++) {
            for (int j = Vitri.x; j <= Vitri.x + 2; j++) {
                InputMap.Map[i][j] = libarary.DiChuyen;
            }
        }
    }

    @Override
    public boolean PhaHuy() {
        for (int i = Vitri.y; i <= Vitri.y + 2; i++) {
            for (int j = Vitri.x; j <= Vitri.x + 2; j++) {
                if (InputMap.Map[i][j] == libarary.BomNo) {
                    XoaVitri();
                    return true;
                }
            }
        }
        return false;
    }
}
