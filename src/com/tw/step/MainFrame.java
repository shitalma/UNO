package com.tw.step;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * This is for adding all components to the main frame.
 */
public class MainFrame extends JFrame {
    void addPanel(JPanel panel, String north){
        this.add(panel,north);
    }

    public MainFrame() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        setSize(new Dimension(800, 500));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void display(){
        this.addPanel(new Players(Arrays.asList("Sandesh","Ram")),BorderLayout.NORTH);
        this.addPanel(new MyCards(Arrays.asList("1","4","8","+4")), BorderLayout.SOUTH);
    }
}
