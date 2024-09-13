package com.funcablaze.iTap;

import com.funcablaze.iTap.Game.MainHandler;
import org.json.*;

import java.io.IOException;
import java.util.Objects;

/**
 * 启动游戏主进程
 */
public abstract class Launch {

    MainHandler mainHandler;

    public abstract void launch();

    private void init() {
        mainHandler = new MainHandler(MainHandler.SceneMode.REPLACE);
        launch();
    }

    public static void main(String[] args) throws IOException {
        ClassLoader launchClass = Launch.class.getClassLoader();
        Class<Launch> main;
        JSONObject json = new JSONObject(new String(Objects.requireNonNull(launchClass.getResourceAsStream("GameConfig.json")).readAllBytes()));
        String mainClassName = json.getString("mainClass");
        try {
            main = (Class<Launch>) launchClass.loadClass(mainClassName);
            main.newInstance().init();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("找不到或无法加载主类。\n" + e);
        }
    }
}