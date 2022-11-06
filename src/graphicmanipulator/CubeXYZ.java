package graphicmanipulator;

import processing.core.PApplet;
import processing.core.PShape;

/**
 *
 * @author dell
 */
public class CubeXYZ extends PApplet {

    PShape cube;

    @Override
    public void settings() {
        size(600, 600, P3D);
    }

    @Override
    public void setup() {
        strokeWeight(9);

        cube = createShape(BOX, 150);
    }

    @Override
    public void draw() {
        background(255);
        lights();

        int x = 372;
        int y = 450;

        translate(width * 0.5f, height * 0.5f, 0);
        rotateY(map(x, 0, width, -PI, PI));
        rotateX(map(y, 0, height, PI, -PI));

        shape(cube);
    }

    public static void main(String[] args) {
        PApplet.main(CubeXYZ.class, args);
    }
}
