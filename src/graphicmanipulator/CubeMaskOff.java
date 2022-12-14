package graphicmanipulator;

import processing.core.PApplet;

/**
 *
 * @author dell
 */
public class CubeMaskOff extends PApplet {

    boolean face1 = true, face2 = true, 
            face3 = true, face4 = true, 
            face5 = true, face6 = true;
    float angDeg = 0;

    
    @Override
    public void settings() {
        size(1000, 700, P3D);
    }
    
    @Override
    public void setup() {
        smooth();
        colorMode(RGB, 0.5f);
    }

    @Override
    public void draw() {
        background(0.5f);

        events();

        pushMatrix();
        noStroke();

        translate(width / 2, height / 2, -50);

        rotateX(angDeg * 0.3f);
        rotateY(angDeg * 0.9f);

        scale(90);
        beginShape(QUADS);

        if (face1) {
            fill(0, 1, 1);
            vertex(-1, 1, 1);
            fill(0, 1, 1);
            vertex(1, 1, 1);
            fill(0, 1, 1);
            vertex(1, -1, 1);
            fill(0, 1, 1);
            vertex(-1, -1, 1);
        }

        if (face2) {
            fill(0, 0, 1);
            vertex(1, 1, 1);
            fill(0, 0, 1);
            vertex(1, 1, -1);
            fill(0, 0, 1);
            vertex(1, -1, -1);
            fill(0, 0, 1);
            vertex(1, -1, 1);
        }

        if (face3) {
            fill(1, 1, 0);
            vertex(1, 1, -1);
            fill(1, 1, 0);
            vertex(-1, 1, -1);
            fill(1, 1, 0);
            vertex(-1, -1, -1);
            fill(1, 1, 0);
            vertex(1, -1, -1);
        }

        if (face4) {
            fill(0, 1, 0);
            vertex(-1, 1, -1);
            fill(0, 1, 0);
            vertex(-1, 1, 1);
            fill(0, 1, 0);
            vertex(-1, -1, 1);
            fill(0, 1, 0);
            vertex(-1, -1, -1);
        }

        if (face5) {
            fill(1, 0, 1);
            vertex(-1, 1, -1);
            fill(1, 0, 1);
            vertex(1, 1, -1);
            fill(1, 0, 1);
            vertex(1, 1, 1);
            fill(1, 0, 1);
            vertex(-1, 1, 1);
        }

        if (face6) {
            fill(1, 0, 0);
            vertex(-1, -1, -1);
            fill(1, 0, 0);
            vertex(1, -1, -1);
            fill(1, 0, 0);
            vertex(1, -1, 1);
            fill(1, 0, 0);
            vertex(-1, -1, 1);
        }

        endShape();

        angDeg += 0.06;

        popMatrix();
    }

    public void events() {
        if (keyPressed) {
            switch (key) {
                case '1':
                    face1 = false;
                    break;
                case '2':
                    face2 = false;
                    break;
                case '3':
                    face3 = false;
                    break;
                case '4':
                    face4 = false;
                    break;
                case '5':
                    face5 = false;
                    break;
                case '6':
                    face6 = false;
                    break;
                case 'R':
                case 'r':
                    face1 = true;
                    face2 = true;
                    face3 = true;
                    face4 = true;
                    face5 = true;
                    face6 = true;
                    break;
                default:
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        PApplet.main(CubeMaskOff.class, args);
    }

}
