package org.test;

import com.funcablaze.iTap.Game.MainHandler;
import com.funcablaze.iTap.Game.Window.Window;
import com.funcablaze.iTap.Launch;

public class Main extends Launch{

    @Override
    public void launch(Window window) {
        window.setWindowHandler(new MainHandler());
        window.setVisible(true);
    }
}
