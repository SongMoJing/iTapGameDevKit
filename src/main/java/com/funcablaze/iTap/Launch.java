package com.funcablaze.iTap;

import com.funcablaze.iTap.Game.MainHandler;
import com.funcablaze.iTap.Game.Window.Window;
import org.json.*;

import java.io.IOException;
import java.util.Objects;

/**
 * 启动游戏主进程
 */
public abstract class Launch {

    public static JSONObject GameConfig;

    public static MainHandler mainHandler;

    public abstract void launch(Window window);

    private void init() {
//        mainHandler = new MainHandler(MainHandler.SceneMode.REPLACE);
        JSONObject info = Launch.GameConfig.getJSONObject("GameInfo").getJSONObject("mainWindow");
        Window window = new Window(info.getString("title"), info.getInt("width"), info.getInt("height"));
        launch(window);
    }

    public static void main(String[] args) throws IOException {
        ClassLoader launchClass = Launch.class.getClassLoader();
        GameConfig = new JSONObject(new String(Objects.requireNonNull(launchClass.getResourceAsStream("GameConfig.json")).readAllBytes()));
        try {
            String mainClassName = GameConfig.getString("LaunchClass");
            Class<Launch> main = (Class<Launch>) launchClass.loadClass(mainClassName);
            main.newInstance().init();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("找不到或无法加载主类。\n" + e);
        }
    }
}
