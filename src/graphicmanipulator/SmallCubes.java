package graphicmanipulator;

import processing.core.PApplet;
import static processing.core.PConstants.P3D;

/**
 *
 * @author dell
 */
public class SmallCubes extends PApplet {

    boolean face1 = true, face2 = true, 
            face3 = true, face4 = true, 
            face5 = true, face6 = true;
    float rotateVar = 0;
    
    @Override
    public void settings() {
        size(1000, 700, P3D);
    }

    @Override
    public void setup() {
        smooth();
        colorMode(RGB, 0.25f);
    }

    @Override
    public void draw() {
        background(0.5f);

        pushMatrix();
        popMatrix();

        pushMatrix();

        translate(width / 2, height / 2, -50);

        rotateY(radians(678));
        rotateZ(radians(678));
        rotateX(radians(678));

        
        drawAxies();
        noStroke();
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

        rotateVar += 0.06;

        popMatrix();
    }

    public void drawAxies() {
        pushMatrix();
        // X axis points right
        stroke(1, 0, 1);
        line(0, 1500, 0, 0, 0, 0);
        textSize(30);
        fill(1, 0, 1);
        text("X", 40, 250);
        text("X", 40, 250);
        translate(60, 320);
        rotateY(rotateVar * 0.09f);
        box(40);
        popMatrix();

        // Y axis points up
        pushMatrix();
        stroke(0, 0, 1);
        line(0, 0, 0, 1500, 0, 0);
        textSize(30);
        fill(0, 0, 1);
        text("Y", 250, 60);
        translate(310, 65);
        rotateY(rotateVar * 0.09f);
        box(40);

        popMatrix();

        // Z axis points backwards
        pushMatrix();
        stroke(0, 1, 1);
        line(0, 0, 0, 0, 0, 1500);
        textSize(30); 
        fill(0, 1, 1);
        text("Z", 100, -300);
        translate(-50, -10, 200);
        rotateY(rotateVar * 0.09f);
        box(40);

        popMatrix();
    }
    
    public static void main(String[] args) {
        PApplet.main(SmallCubes.class, args);
    }
}
