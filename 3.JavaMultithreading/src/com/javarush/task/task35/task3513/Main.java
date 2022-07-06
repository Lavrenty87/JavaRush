package com.javarush.task.task35.task3513;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);

        JFrame geame = new JFrame();
        geame.setTitle("2048");
        geame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        geame.setSize(450, 500);
        geame.setResizable(false);
        geame.add(controller.getView());
        geame.setLocationRelativeTo(null);
        geame.setVisible(true);
    }
}
