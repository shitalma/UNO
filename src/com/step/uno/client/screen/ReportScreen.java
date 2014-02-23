package com.step.uno.client.screen;

import com.step.uno.client.view.ResultView;
import com.step.uno.messages.GameResult;
import com.step.uno.model.PlayerResult;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ReportScreen extends JFrame implements ResultView {

    DefaultTableModel model;
    JTable table;
    String col[] = {"Player", "NumberOfCards", "Points"};
    int row = 0, column = 0, numberOfRows;
    List<String> names = new ArrayList<>();
    List<Integer> numberOfCards = new ArrayList<>();
    List<Integer> points = new ArrayList<>();


    public ReportScreen(GameResult gameResult) {

        super(" Report Screen ");
        for (PlayerResult player : gameResult.players) {
            names.add(player.name);
            numberOfCards.add(player.cards.length);
            points.add(player.points);
        }
        numberOfRows = gameResult.players.length;
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        start();
    }

    public DefaultTableModel setTableModel(DefaultTableModel model) {
        model = new DefaultTableModel(col, numberOfRows);
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

        for (int i = 0; i < names.size(); i++) {
            column = 0;
            table.setValueAt(names.get(i), row, column);
            column++;
            table.setValueAt(numberOfCards.get(i), row, column);
            column++;
            table.setValueAt(points.get(i), row, column);
            row++;
        }

        add(pane);
        setVisible(true);
    }

    @Override
    public void showResult() {

    }
}

