package lu.embellishedduck.engine.io.input;

import lombok.Getter;
import lombok.Setter;
import org.lwjgl.glfw.GLFW;

@Getter
public enum Keybinding {

    //===========
    // INSTANCES
    //===========
    up("MoveForward", GLFW.GLFW_KEY_W, () -> System.out.println("Up")),
    left("MoveLeft", GLFW.GLFW_KEY_A, () -> System.out.println("Left")),
    down("MoveDown", GLFW.GLFW_KEY_S, () -> System.out.println("Down")),
    right("MoveRight", GLFW.GLFW_KEY_D, () -> System.out.println("Right"));


    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private final String identifier;

    @Setter
    private int keyCode;

    private final Runnable action;


    //=============
    // CONSTRUCTOR
    //=============
    Keybinding(String identifier, int keyCode, Runnable action) {

        this.identifier = identifier;
        this.keyCode = keyCode;
        this.action = action;

    }//End of Constructor

}//End of Class