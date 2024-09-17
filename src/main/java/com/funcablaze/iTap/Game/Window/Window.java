package com.funcablaze.iTap.Game.Window;

import com.funcablaze.iTap.Game.MainHandler;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private MainHandler mainHandler;

    public Window(String title, int width, int height) {
        // 设置窗口的标题
        setTitle(title);
        // 设置窗口的大小
        setSize(width, height);
        // 将窗口设置为可调整大小
        setResizable(false);
        // 将窗口设置为在屏幕上居中
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {

    }

    public void setWindowHandler(MainHandler mainHandler) {
        this.mainHandler = mainHandler;
    }
}
