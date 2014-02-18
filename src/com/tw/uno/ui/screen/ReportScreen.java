package com.tw.uno.ui.screen;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReportScreen extends JFrame {
    DefaultTableModel model;
    JTable table;
    String col[] = {"Player", "NumberOfCards", "Points"};

    public static void main(String args[]) {
        new ReportScreen().start();
    }

    public void start() {

        model = new DefaultTableModel(col, 2);
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int arg0, int arg1) {

                return false;
            }
        };
        JScrollPane pane = new JScrollPane(table);

        table.setValueAt("Uday", 0, 0);
        table.setValueAt(5,0,1);
        table.setValueAt(30,0,2);

        add(pane);
        setVisible(true);
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
