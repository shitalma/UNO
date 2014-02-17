package com.tw.uno.elements;

/**
 * This is for displaying the log.
 */

import javax.swing.*;
import java.awt.*;

public class Log extends JPanel {
    private JList listBox;
    private JScrollPane scrollPane;

    public Log(String[] actionList) {
        setSize(300, 800);
        setBackground(Color.gray);

        setLayout(new BorderLayout());
        listBox = new JList(actionList);

        scrollPane = new JScrollPane();
        scrollPane.getViewport().add(listBox);
        add(scrollPane, BorderLayout.CENTER);
    }

//    public static void main(String args[]) {
//        String[] log = {"aaaa", "bbbb", "ccccc", "aaaa", "bbbb", "ccccc"};
//        JFrame logFrame = new JFrame("UNOButton log");
//        logFrame.setLayout(new BorderLayout());
//        logFrame.add(new Log(log));
//        logFrame.setVisible(true);
//        logFrame.setSize(300, 700);
//    }
}