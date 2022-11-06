package graphicmanipulator;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.DisplayMode;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author dell
 */
public class CubeVV extends GLCanvas implements GLEventListener {

    public GL2 gl;
    public static DisplayMode dm, dm_old;
    private final GLU glu = new GLU();
    
    private float translateXC1 = -3.5f;  //limit [-3.5;-0.5]
    private float translateXC2 = 3.5f;

    private boolean go = true;

    public CubeVV() {
        this.addGLEventListener(this);
        final FPSAnimator animator = new FPSAnimator(this, 10, true);
        animator.start();
    }

    @Override
    public void init(GLAutoDrawable glad) {
        gl = glad.getGL().getGL2();
        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glClearColor(0f, 0f, 0f, 0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
    }

    @Override
    public void dispose(GLAutoDrawable glad) {

    }

    @Override
    public void display(GLAutoDrawable glad) {
        gl = glad.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        cube1(gl);
        cube2(gl);

        moveCube1();
        moveCube2();
    }

    
    public void cube1(GL2 gl) {
        gl.glLoadIdentity();
        gl.glTranslatef(translateXC1, 0f, -5.0f);
        gl.glRotatef(-10, 0.8f, 1, 0);
        //Face 1
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(1f, 0f, 0f);
        gl.glVertex3f(0.3f, -0.3f, -0.3f);
        gl.glVertex3f(0.3f, 0.3f, -0.3f);
        gl.glVertex3f(-0.3f, 0.3f, -0.3f);
        gl.glVertex3f(-0.3f, -0.3f, -0.3f);
        gl.glFlush();
        gl.glEnd();

        //Face 2
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(0f, 1f, 0f);
        gl.glVertex3f(0.3f, -0.3f, 0.3f);
        gl.glVertex3f(0.3f, 0.3f, 0.3f);
        gl.glVertex3f(-0.3f, 0.3f, 0.3f);
        gl.glVertex3f(-0.3f, -0.3f, 0.3f);
        gl.glFlush();
        gl.glEnd();

        //Face 3
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(0f, 0f, 1f);
        gl.glVertex3f(0.3f, -0.3f, -0.3f);
        gl.glVertex3f(0.3f, 0.3f, -0.3f);
        gl.glVertex3f(0.3f, 0.3f, 0.3f);
        gl.glVertex3f(0.3f, -0.3f, 0.3f);
        gl.glFlush();
        gl.glEnd();

        //Face 4
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(1f, 1f, 0f);
        gl.glVertex3f(-0.3f, -0.3f, 0.3f);
        gl.glVertex3f(-0.3f, 0.3f, 0.3f);
        gl.glVertex3f(-0.3f, 0.3f, -0.3f);
        gl.glVertex3f(-0.3f, -0.3f, -0.3f);
        gl.glFlush();
        gl.glEnd();

        //Face 5
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(1f, 0f, 1f);
        gl.glVertex3f(0.3f, 0.3f, 0.3f);
        gl.glVertex3f(0.3f, 0.3f, -0.3f);
        gl.glVertex3f(-0.3f, 0.3f, -0.3f);
        gl.glVertex3f(-0.3f, 0.3f, 0.3f);
        gl.glFlush();
        gl.glEnd();

        //Face 6
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(0f, 1f, 1f);
        gl.glVertex3f(0.3f, -0.3f, -0.3f);
        gl.glVertex3f(0.3f, -0.3f, 0.3f);
        gl.glVertex3f(-0.3f, -0.3f, 0.3f);
        gl.glVertex3f(-0.3f, -0.3f, -0.3f);
        gl.glFlush();
        gl.glEnd();
    }

    public void cube2(GL2 gl) {
        gl.glLoadIdentity();
        gl.glTranslatef(translateXC2, 0f, -5.0f);
        gl.glRotatef(-10, 0.8f, 1, 0);
        //Face 1
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(1f, 0f, 0f);
        gl.glVertex3f(0.3f, -0.3f, -0.3f);
        gl.glVertex3f(0.3f, 0.3f, -0.3f);
        gl.glVertex3f(-0.3f, 0.3f, -0.3f);
        gl.glVertex3f(-0.3f, -0.3f, -0.3f);
        gl.glFlush();
        gl.glEnd();

        //Face 2
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(0f, 1f, 0f);
        gl.glVertex3f(0.3f, -0.3f, 0.3f);
        gl.glVertex3f(0.3f, 0.3f, 0.3f);
        gl.glVertex3f(-0.3f, 0.3f, 0.3f);
        gl.glVertex3f(-0.3f, -0.3f, 0.3f);
        gl.glFlush();
        gl.glEnd();

        //Face 3
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(0f, 0f, 1f);
        gl.glVertex3f(0.3f, -0.3f, -0.3f);
        gl.glVertex3f(0.3f, 0.3f, -0.3f);
        gl.glVertex3f(0.3f, 0.3f, 0.3f);
        gl.glVertex3f(0.3f, -0.3f, 0.3f);
        gl.glFlush();
        gl.glEnd();

        //Face 4
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(1f, 1f, 0f);
        gl.glVertex3f(-0.3f, -0.3f, 0.3f);
        gl.glVertex3f(-0.3f, 0.3f, 0.3f);
        gl.glVertex3f(-0.3f, 0.3f, -0.3f);
        gl.glVertex3f(-0.3f, -0.3f, -0.3f);
        gl.glFlush();
        gl.glEnd();

        //Face 5
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(1f, 0f, 1f);
        gl.glVertex3f(0.3f, 0.3f, 0.3f);
        gl.glVertex3f(0.3f, 0.3f, -0.3f);
        gl.glVertex3f(-0.3f, 0.3f, -0.3f);
        gl.glVertex3f(-0.3f, 0.3f, 0.3f);
        gl.glFlush();
        gl.glEnd();

        //Face 6
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(0f, 1f, 1f);
        gl.glVertex3f(0.3f, -0.3f, -0.3f);
        gl.glVertex3f(0.3f, -0.3f, 0.3f);
        gl.glVertex3f(-0.3f, -0.3f, 0.3f);
        gl.glVertex3f(-0.3f, -0.3f, -0.3f);
        gl.glFlush();
        gl.glEnd();
    }

    public void moveCube1() {
        if (translateXC1 <= -0.5f && go == true) {
            translateXC1 += 0.1f;
        } else {
            go = false;
        }
        if (translateXC1 >= -3.5f && go == false) {
            translateXC1 -= 0.1f;
        } else {
            go = true;
        }
    }

    public void moveCube2() {
        if (translateXC2 >= 0.5f && go == true) {
            translateXC2 -= 0.1f;
        } else {
            go = false;
        }
        if (translateXC2 <= 3.5f && go == false) {
            translateXC2 += 0.1f;
        } else {
            go = true;
        }
    }

    @Override
    public void reshape(GLAutoDrawable glad, int x, int y, int width, int height) {
        gl = glad.getGL().getGL2();
        if (height <= 0) {
            height = 1;
        }
        final float h = (float) width / height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
    
    public static void main(String[] args) {
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        CubeVV cube = new CubeVV();

        glcanvas.addGLEventListener(cube);
        glcanvas.setSize(400, 400);

        final JFrame frame = new JFrame("Cube Come n Go");
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);

        animator.start();
    }

}
