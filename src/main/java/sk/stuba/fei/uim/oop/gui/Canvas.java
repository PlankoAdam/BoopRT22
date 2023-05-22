package sk.stuba.fei.uim.oop.gui;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.turtle.Line;
import sk.stuba.fei.uim.oop.turtle.Turtle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {

    private List<Line> lines;
    @Getter
    private final Turtle turtle;
    @Setter
    @Getter
    private Color currentColor;

    public Canvas(int width, int height) {
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));

        lines = new ArrayList<>();
        this.turtle = new Turtle(getWidth()/2, getHeight()/2);
        currentColor = Color.BLACK;
        repaint();
    }

    public void add(Line line) {
        lines.add(line);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);
        for (Line line : lines) {
            line.draw(g);
        }
        turtle.draw(g);
    }
}
