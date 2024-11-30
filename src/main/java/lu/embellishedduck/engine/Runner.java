package lu.embellishedduck.engine;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWVidMode;

import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;

import static org.lwjgl.opengl.GL11.*;

public class Runner {

    //=============
    // MAIN METHOD
    //=============
    public static void main(String[] args) {

        //Error handling glfw, basically if this fails nothing is going to work
        if (!glfwInit()) {

            throw new IllegalStateException("Failed to initialize GLFW");

        }//End of If Statement

        //Creating the window
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        long window = glfwCreateWindow(640, 480, "Game", 0, 0);

        //Error handling the window, if this is 0 then the game technically works, but you won't see anything
        if (window == 0) {

            throw new IllegalStateException("Failed to create window");

        }//End of If Statement

        //This can be used for making a fullscreen window
        GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor()/*This exact function can be called in the glfwWindowHint method to automatically make the game
        fullscreen*/);

        //Setting the window's position to the center of the screen
        assert videoMode != null;//This thing is basically a bootleg if condition I believe
        glfwSetWindowPos(window, (videoMode.width() - 640) / 2, (videoMode.height() - 480) / 2);

        glfwShowWindow(window);
        glfwMakeContextCurrent(window);//This allows you to add contexts to the window, like the one below.

        //This creates a context in the graphics card which lets it draw images (way more efficient than my old Swing game)
        GL.createCapabilities();

        //This while loop is critical to sustain the window being open, otherwise it would just flash for an instant and then disappear
        while (!glfwWindowShouldClose(window)) {

            glfwPollEvents();

            glClear(GL_COLOR_BUFFER_BIT);//This thing is basically the context, clearing it sets every pixel to black. You can also set which color to clear it to as well.

            glBegin(GL_QUADS);//Deprecated pipeline. I WON'T BE USING THIS LATER DOWN THE LINE BUT I JUST WANTED TO GET SOMETHING RENDERED.

                glColor4f(1, 0,0, 0);
                glVertex2f(-0.5f, 0.5f);

                glColor4f(0, 1,0, 0);
                glVertex2f(0.5f, 0.5f);

                glColor4f(0, 0,1, 0);
                glVertex2f(0.5f, -0.5f);

                glColor4f(1, 1,1, 0);
                glVertex2f(-0.5f, -0.5f);
            glEnd();//Tells the program to stop drawing

            glfwSwapBuffers(window);

            /*
            Basically when you needs two buffers otherwise that program might skip triangles and all sorts of other funny rendering errors will occur.
            The two buffers are split between front-end and back-end, allowing OpenGL to draw to the back-end one while rendering the front-end one. At the end
            of the frame the two are swapped. Increasing rendering speed (I think).
             */

        }//End of While Loop

        //Cleaning up everything, so I don't have to (convenient)
        glfwTerminate();

    }//End of Main Method

}//End of Class