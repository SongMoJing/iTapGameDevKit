package com.funcablaze.iTap.Game;

import com.funcablaze.iTap.Game.Window.Tscn.Scene;

import java.util.Stack;

public class MainHandler extends Thread{
    private final Stack<Scene> scenes = new Stack<>();
    private final SceneMode sceneMode;

    public enum SceneMode {
        STACK,
        REPLACE
    }

    public MainHandler(SceneMode mode) {
        this.sceneMode = mode;

    }

    /**
     * 压入或切换场景
     * @param scene 场景
     */
    public void pushScene(Scene scene) {
        if (sceneMode == SceneMode.STACK) {
            scenes.push(scene);
        } else {
            scenes.clear();
            scenes.push(scene);
        }
    }

    /**
     * 弹出场景
     * @throws Exception 场景栈为空或场景模式为取代
     */
    public void popScene() throws Exception {
        if (sceneMode == SceneMode.STACK) {
            if (!scenes.empty()) {
                scenes.pop();
            } else {
                throw new Exception("场景栈为空！");
            }
        } else {
            throw new Exception("场景模式为取代！");
        }
    }

    /**
     * 获取当前场景
     * @return 当前场景
     */
    public Scene getTopScene() {
        return scenes.peek();
    }
}
