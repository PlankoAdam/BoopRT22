package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.logic.Logic;

import javax.swing.*;
import java.awt.*;

public class ExamRT extends JFrame {

    public ExamRT() {

        setTitle("Turtle Painter");
        setResizable(false);
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);

        JPanel sideMenu = new JPanel();
        Canvas canvas = new Canvas(700, 500);
        Logic logic = new Logic(canvas);

        add(sideMenu, BorderLayout.PAGE_END);
        add(canvas, BorderLayout.CENTER);

        JComboBox<Integer> angleComboBox = logic.getAngleComboBox();
        JSlider lengthSlider = logic.getLengthSlider();
        JButton executeButton = new JButton("Draw");
        JButton colorButton = new JButton("Change color");
        JLabel lengthAndAngleLabel = logic.getLengthAndAngleLabel();
        JLabel colorLabel = logic.getColorLabel();

        executeButton.setFocusable(false);
        colorButton.setFocusable(false);
        executeButton.addActionListener(logic);
        colorButton.addActionListener(logic);
        addKeyListener(logic);

        sideMenu.setLayout(new GridLayout(2, 3));

        sideMenu.add(executeButton);
        sideMenu.add(lengthAndAngleLabel);
        sideMenu.add(lengthSlider);
        sideMenu.add(colorButton);
        sideMenu.add(colorLabel);
        sideMenu.add(angleComboBox);



        pack();
        setVisible(true);
    }
}
