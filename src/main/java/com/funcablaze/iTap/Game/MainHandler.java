package com.funcablaze.iTap.Game;

import com.funcablaze.iTap.Game.Window.Scene;
import com.funcablaze.iTap.Game.Window.Window;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MainHandler extends Thread{
    private final Map<String, Window> windows = new HashMap<>();

    public boolean runGame() {
        if (!windows.isEmpty()) {
            start();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void start() {
        super.start();
        while (!windows.isEmpty()) {

        }
    }
}
