package com.tw.uno.ui.elements;

import javax.swing.*;
import java.awt.*;

public class CardsStatus extends JFrame {
    GridLayout myLayout = new GridLayout(2,2);

    public CardsStatus(){
        super("Uno status");
        setSize(500, 500);
        setLayout(myLayout);
        add(new DrawButton());
        add(new PileButton());
        add(new Status());
        setVisible(true);
    }
}












