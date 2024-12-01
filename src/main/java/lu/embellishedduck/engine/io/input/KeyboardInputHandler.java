package lu.embellishedduck.engine.io.input;

import org.lwjgl.glfw.GLFW;

import java.util.HashMap;
import java.util.Map;

public enum KeyboardInputHandler {

    //===========
    // INSTANCES
    //===========
    instance;

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private Map<Integer, Runnable> keyBinds;


    //=============
    // CONSTRUCTOR
    //=============
    KeyboardInputHandler() {

        keyBinds = new HashMap<>();

    }//End of Class


    //===================================
    // METHOD TO BIND A KEY TO AN ACTION
    //===================================
    public void bindKey(int key, Runnable action) {

        keyBinds.put(key, action);

    }//End of Method


    //=======================
    // METHOD TO HANDLE KEYS
    //=======================
    public void handleKeys(long window) {

        for (Map.Entry<Integer, Runnable> entry : keyBinds.entrySet()) {

            if (GLFW.glfwGetKey(window, entry.getKey()) == GLFW.GLFW_PRESS) {

                entry.getValue().run();

            }//End of If Statement

        }//End of For Loop

    }//End of Method


    //=======================================
    // METHOD TO SET THE DEFAULT KEYBINDINGS
    //=======================================
    public void setDefaultKeyBinds() {

        bindKey(GLFW.GLFW_KEY_W, () -> System.out.println("Move Forward"));
        bindKey(GLFW.GLFW_KEY_S, () -> System.out.println("Move Backward"));
        bindKey(GLFW.GLFW_KEY_A, () -> System.out.println("Move Left"));
        bindKey(GLFW.GLFW_KEY_D, () -> System.out.println("Move Right"));

    }//End of Method

}//End of Class