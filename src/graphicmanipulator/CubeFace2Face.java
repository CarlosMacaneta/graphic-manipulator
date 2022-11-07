package graphicmanipulator;

import processing.core.PApplet;
import processing.core.PShape;

/**
 *
 * @author dell
 */
public class CubeFace2Face extends PApplet {
    
    PShape cube1, cube2;
    float a = 0.0f;
   
    @Override
    public void settings() {
        size(640, 360, P3D);
    }

    @Override
    public void setup() {
        strokeWeight(9);
        
        cube1 = createShape(BOX, 150);
        cube2 = createShape(BOX, 150);
    }

    @Override
    public void draw() {
        background(255);
        
        cube1.setFill(color(random(255), random(255), random(255)));
        cube2.setFill(color(random(255), random(255), random(255)));
        
        a += 0.005;
        if(a > TWO_PI) { 
          a = 0.0f; 
        }
         
        translate(width * 0.35f, height * 0.05f, 0);
        
        cube1.rotateX(a);
        cube1.rotateY(a * 2.0f);
        
        cube2.rotateX(1.25f * a);
        cube2.rotateY(-0.4f * a);
        delay(150);
       

        shape(cube1, 130, height / 2);
        shape(cube2, 500, height * 0.35f);
    }

    
    @Override
    public void exit() {
        dispose();
    }
    
    public static void main(String[] args) {
        PApplet.main(CubeFace2Face.class, args);
    }
}
