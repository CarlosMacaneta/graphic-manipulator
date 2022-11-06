
package graphicmanipulator;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import java.awt.Window.Type;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author dell
 */
public class GridCube implements GLEventListener {

    @Override
    public void init(GLAutoDrawable glad) {
//        final GL2 gl = glad.getGL().getGL2();
//        gl.glShadeModel(GL2.GL_SMOOTH);
//        gl.glClearColor(0f, 0f, 0f, 0f);
//        gl.glClearDepth(1.0f);
//        gl.glEnable(GL2.GL_DEPTH_TEST);
//        gl.glDepthFunc(GL2.GL_LEQUAL);
//        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

    }

    @Override
    public void dispose(GLAutoDrawable glad) {
    }

    @Override
    public void display(GLAutoDrawable glad) {
        final GL2 gl = glad.getGL().getGL2();
        
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glBegin(GL2.GL_LINES);
        float X = 30; // how many lines
        for (float i = -1f; i < 1f; i += 2f/X) {
            gl.glVertex3f(i,-1f, 0);
            gl.glVertex3f(-i,1f, 0);
        }
      
        gl.glEnd();
        
        gl.glBegin(GL2.GL_LINES);
        for (float i = 0f; i < 2f; i += 2f/X) {
            gl.glVertex3f(-(i), i, -0.5f);
            gl.glVertex3f(i, -1f, 0.5f);
        }
      
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }
    
    public static void main(String[] args) {
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        GridCube gridCube = new GridCube();

        glcanvas.addGLEventListener(gridCube);
        glcanvas.setSize(400, 400);

        final JFrame frame = new JFrame(" Multicolored cube");
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
