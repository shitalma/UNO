package com.step.uno.client.screen.elements;

/**
 * This is for displaying the log.
 */

import com.step.uno.model.PlayerSummary;

import javax.swing.*;
import java.awt.*;

public class Log extends JPanel {
    private JList listBox;
    private JScrollPane scrollPane;

    public Log(String[] log) {
        String[] logData = new String[log.length];
        for(int i = 0;i < log.length; i++){
            logData[i] = log[i].toString();
        }
        setSize(300, 800);
        setBackground(Color.gray);

        setLayout(new BorderLayout());
        listBox = new JList<>(logData);

        scrollPane = new JScrollPane();
        scrollPane.getViewport().add(listBox);
        add(scrollPane, BorderLayout.CENTER);

    }
}