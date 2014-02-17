package com.tw.uno.ui.elements;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class WildCard extends JPanel {
    Map<String,Color> map = new HashMap<>();
    List<String> colors = new ArrayList<>();

    public WildCard addAllButtons() {
        map.put("green", Color.GREEN);
        map.put("red", Color.RED);
        map.put("blue", Color.BLUE);
        map.put("yellow", Color.YELLOW);

        setSize(500, 500);

        colors.add("green");
        colors.add("red");
        colors.add("blue");
        colors.add("yellow");

        for (int i = 0; i < map.size(); i++) {
            final int finalI = i;
            JButton s = new JButton() {
                @Override
                public void paintComponent(Graphics g) {
                    g.setColor(map.get(colors.get(finalI)));
                    g.fillRect(0, 0, getSize().width, getSize().height);
                    super.paintComponent(g);
                }
            };
            s.setSize(100, 100);
            s.setContentAreaFilled(false);
            add(s);

        }
        setLayout(new GridLayout(2, 2));
        setVisible(true);
        return this;
    }
}
