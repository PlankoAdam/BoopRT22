package sk.stuba.fei.uim.oop.logic;

import lombok.Getter;
import sk.stuba.fei.uim.oop.gui.Canvas;
import sk.stuba.fei.uim.oop.turtle.Line;
import sk.stuba.fei.uim.oop.turtle.Turtle;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Logic extends UniversalAdapter{

    private final Canvas canvas;
    private final Turtle turtle;

    private int length;
    private int angle;

    @Getter
    private final JComboBox<Integer> angleComboBox;
    @Getter
    private final JSlider lengthSlider;
    @Getter
    private final JLabel lengthAndAngleLabel;
    @Getter
    private final JLabel colorLabel;

    private final HashMap<Color, String> colors;
    private Iterator<Map.Entry<Color, String>> iterator;

    public Logic(Canvas canvas) {
        this.canvas = canvas;
        turtle = canvas.getTurtle();
        angleComboBox = new JComboBox<>();
        lengthSlider = new JSlider();
        lengthAndAngleLabel = new JLabel();
        colorLabel = new JLabel();

        lengthSlider.setFocusable(false);
        angleComboBox.setFocusable(false);

        for (Integer i : new int[]{0, 5, 10, 45, 90, 180}) {
            angleComboBox.addItem(i);
        }

        lengthSlider.setMinimum(0);
        lengthSlider.setMaximum(100);
        lengthSlider.setMinorTickSpacing(10);
        lengthSlider.setMajorTickSpacing(10);
        lengthSlider.setSnapToTicks(true);
        lengthSlider.setValue(10);
        lengthSlider.setPaintTicks(true);
        length = lengthSlider.getValue();

        angleComboBox.addActionListener(this);
        lengthSlider.addChangeListener(this);

        colors = new HashMap<>();
        colors.put(Color.BLACK, "Black");
        colors.put(Color.RED, "Red");
        colors.put(Color.GREEN, "Green");
        colors.put(Color.BLUE, "Blue");
        iterator = colors.entrySet().iterator();
        canvas.setCurrentColor(iterator.next().getKey());

        updateLabels();
    }

    private void updateLabels() {
        lengthAndAngleLabel.setText("Length: " + length + " Angle: " + angle);
        colorLabel.setText("Color: " + colors.get(canvas.getCurrentColor()));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Draw")) {
            canvas.add(new Line(turtle.getX(), turtle.getY(), length, turtle.getAngle(), canvas.getCurrentColor()));
            turtle.forward(length);
            turtle.turnRight(angle);
        } else if (actionEvent.getActionCommand().equals("Change color")) {
            if (!iterator.hasNext()) {
                iterator = colors.entrySet().iterator();
            }
            canvas.setCurrentColor(iterator.next().getKey());
        } else if (actionEvent.getSource().equals(angleComboBox)) {
            angle = (int) angleComboBox.getSelectedItem();
        }
        updateLabels();
        canvas.repaint();
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        if (changeEvent.getSource().equals(lengthSlider)) {
            length = lengthSlider.getValue();
        }
        updateLabels();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            canvas.add(new Line(turtle.getX(), turtle.getY(), length, turtle.getAngle(), canvas.getCurrentColor()));
            turtle.forward(length);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            canvas.add(new Line(turtle.getX(), turtle.getY(), -length, turtle.getAngle(), canvas.getCurrentColor()));
            turtle.forward(-length);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            turtle.turnRight(angle);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            turtle.turnRight(-angle);
        }
        canvas.repaint();
    }
}
