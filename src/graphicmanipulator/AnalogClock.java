package graphicmanipulator;

import processing.core.PApplet;

/**
 *
 * @author dell
 */
public class AnalogClock extends PApplet {

    int cx, cy;
    float secondsRadius;
    float minutesRadius;
    float hoursRadius;
    float clockDiameter;
    
    @Override
    public void settings() {
        size(640, 360);
    }

    @Override
    public void setup() {
        size(640, 360);
        stroke(255);

        int radius = min(width, height) / 2;
        secondsRadius = radius * 0.72f;
        minutesRadius = radius * 0.60f;
        hoursRadius = radius * 0.50f;
        clockDiameter = radius * 1.8f;

        cx = width / 2;
        cy = height / 2;
    }

    @Override
    public void draw() {
        background(0);

        // Draw the clock background
        fill(80);
        noStroke();
        ellipse(cx, cy, clockDiameter, clockDiameter);

        // Angles for sin() and cos() start at 3 o'clock;
        // subtract HALF_PI to make them start at the top
        float s = map(second(), 0, 60, 0, TWO_PI) - HALF_PI;
        float m = map(minute() + norm(second(), 0, 60), 0, 60, 0, TWO_PI) - HALF_PI;
        float h = map(hour() + norm(minute(), 0, 60), 0, 24, 0, TWO_PI * 2) - HALF_PI;

        // Draw the hands of the clock
        stroke(255);
        strokeWeight(1);
        line(cx, cy, cx + cos(s) * secondsRadius, cy + sin(s) * secondsRadius);
        strokeWeight(2);
        line(cx, cy, cx + cos(m) * minutesRadius, cy + sin(m) * minutesRadius);
        strokeWeight(4);
        line(cx, cy, cx + cos(h) * hoursRadius, cy + sin(h) * hoursRadius);

        // Draw the minute ticks
        strokeWeight(2);
        beginShape(POINTS);
        for (int a = 0; a < 360; a += 6) {
            float angle = radians(a);
            float x = cx + cos(angle) * secondsRadius;
            float y = cy + sin(angle) * secondsRadius;
            vertex(x, y);
        }
        endShape();
    }
    
    @Override
    public void keyPressed() {
        switch (key) {
            case CODED:
                if(keyCode == SHIFT) {
                    System.exit(0);
                }   break;
            case 'H':
            case 'h':
                
                break;
            case 'M':
            case 'm':
                
                break;
            case 'S':
            case 's':
                
                break;
            default:
                break;
        }
    }
    
    public static void main(String[] args) {
        PApplet.main(AnalogClock.class, args);
    }
}
