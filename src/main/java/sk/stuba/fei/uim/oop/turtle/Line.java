package sk.stuba.fei.uim.oop.turtle;

import lombok.Getter;

import java.awt.*;

@Getter
public class Line {

    private final int x;
    private final int y;
    private final int length;
    private final int angle;
    private final Color color;

    public Line(int x, int y, int length, int angle, Color color) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.angle = angle;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x, y, (int) (x + length * Math.cos(Math.toRadians(angle))), (int) (y + length * Math.sin(Math.toRadians(angle))));
    }
}
