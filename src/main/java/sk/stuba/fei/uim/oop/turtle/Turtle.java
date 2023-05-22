package sk.stuba.fei.uim.oop.turtle;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
public class Turtle {

    private final int BODY_RADIUS = 20;
    private final int HEAD_RADIUS = 10;

    @Setter
    private int x;
    @Setter
    private int y;
    @Setter
    private int angle;

    public Turtle(int x, int y) {
        this.x = x;
        this.y = y;
        angle = -90;
    }

    public void draw(Graphics g) {

        Color originalColor = g.getColor();
        g.setColor(Color.GREEN);
        g.fillOval(x - BODY_RADIUS, y - BODY_RADIUS, 2 * BODY_RADIUS, 2 * BODY_RADIUS);
        g.setColor(Color.ORANGE);
        g.fillOval((int) (x - HEAD_RADIUS + BODY_RADIUS * Math.cos(Math.toRadians(angle))), (int) (y - HEAD_RADIUS + BODY_RADIUS * Math.sin(Math.toRadians(angle))), 2 * HEAD_RADIUS, 2 * HEAD_RADIUS);
        g.setColor(originalColor);
    }

    public void forward(int length) {
        x += (int) (length * Math.cos(Math.toRadians(this.angle)));
        y += (int) (length * Math.sin(Math.toRadians(this.angle)));
    }

    public void turnRight(int angle){
        this.angle += angle;
    }
}
