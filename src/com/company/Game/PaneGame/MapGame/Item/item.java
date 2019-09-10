package com.company.Game.PaneGame.MapGame.Item;

import com.company.Game.PaneGame.MapGame.Chung.OVuong;
import com.company.Game.SoundGame;
import com.company.Library.libarary;
import com.company.Game.PaneGame.MapGame.InputMap;

public abstract class item extends OVuong {
    protected char Kitu;

    public item(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean PhaHuy() {
        for (int i = Vitri.y; i <= Vitri.y + 2; i++) {
            for (int j = Vitri.x; j <= Vitri.x + 2; j++) {
                if (InputMap.Map[i][j] == libarary.Boomber) {
                    InputMap.Map[i][j] = Kitu;
                    new SoundGame("Item").start();
                    return true;
                }
            }
        }
        return false;
    }
}
