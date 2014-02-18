package com.tw.uno.ui.screen;

import com.tw.uno.lib.Report;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ReportScreen extends JFrame {
    DefaultTableModel model;
    JTable table;
    String col[] = {"Player", "NumberOfCards", "Points"};
    int row = 0, column = 0;
    List<String> names;
    List<Integer> numberOfCards;
    private Report report;

    public ReportScreen(Report report) {
        this.report = report;

        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        start();
    }

    public DefaultTableModel setTableModel(DefaultTableModel model){
        model = new DefaultTableModel(col, 2);
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }
        };

        return model;
    }

    public void start() {
        model = setTableModel(model);
        JScrollPane pane = new JScrollPane(table);

        names = report.getPlayersNames();
        numberOfCards = report.getNumberOfCardsForEachPlayer();

        for (int i = 0; i <= names.size() - 1; i++) {
            column = 0;
            table.setValueAt(names.get(i), row, column);
            column++;
            table.setValueAt(numberOfCards.get(i), row, column);
            column++;
            table.setValueAt(0, row, column);
            row++;
        }

        add(pane);
        setVisible(true);
    }

}
