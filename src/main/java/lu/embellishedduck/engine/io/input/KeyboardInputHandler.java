package lu.embellishedduck.engine.io.input;

import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public enum KeyboardInputHandler {

    //===========
    // INSTANCES
    //===========
    instance;

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private static final List<Keybinding> keyBindings = new ArrayList<>();

    //---------------------------------
    // Populating the keyBindings list
    //---------------------------------
    static {

        keyBindings.add(Keybinding.up);
        keyBindings.add(Keybinding.left);
        keyBindings.add(Keybinding.down);
        keyBindings.add(Keybinding.right);

    }//End of Static Field


    //===================================
    // METHOD TO BIND A KEY TO AN ACTION
    //===================================
    public void bindKey(String identifier, int keyCode) {

        for (Keybinding keyBinding : keyBindings) {

            if (keyBinding.getIdentifier().equals(identifier)) {

                keyBinding.setKeyCode(keyCode);

            }//End of If Statement

        }//End of For-Each Loop

    }//End of Method


    //=======================
    // METHOD TO HANDLE KEYS
    //=======================
    public void handleKeys(long window) {

        for (Keybinding keyBinding : keyBindings) {

            if (GLFW.glfwGetKey(window, keyBinding.getKeyCode()) == GLFW.GLFW_PRESS) {

                keyBinding.getAction().run();

            }//End of If Statement

        }//End of For-Each Loop

    }//End of Method


    //=======================================
    // METHOD TO SET THE DEFAULT KEYBINDINGS
    //=======================================
    public void setDefaultKeyBinds() {

        bindKey("MoveForward", GLFW.GLFW_KEY_W);
        bindKey("MoveLeft", GLFW.GLFW_KEY_A);
        bindKey("MoveBackward", GLFW.GLFW_KEY_S);
        bindKey("MoveDown", GLFW.GLFW_KEY_D);

    }//End of Method

}//End of Class