package com.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class Timetable extends JFrame{

    private JPanel topPanel;

    private JTable table;

    private JScrollPane scrollPane;

    private String[] columnNames = new String[3];

    private String[][] dataValues = new String[3][3];

    JTextField textBox = new JTextField();


    public Timetable() {

        setTitle("Timetable");

        setSize(300,300);

        setDefaultCloseOperation (EXIT_ON_CLOSE);

        topPanel = new JPanel();

        topPanel.setLayout(new BorderLayout());

        getContentPane().add(topPanel);

        columnNames = new String[] {"Time", "Room 1", "Room 2", "Room 3"};

        dataValues = new String[][] {
                {"8:00","1","2","3"},
                {"8:30"},
                {"9:00","4","5","6"},
                {"9:30"},
                {"10:00","7","8","9"},
                {"10:30"},
                {"11:00","10","11","12"},
                {"11:30"}
        };

        TableModel model = new myTableModel();

        table = new JTable();

        table.setRowHeight(15);

        table.setModel(model);

        TableColumn soprtColumn=table.getColumnModel().getColumn(1);

        soprtColumn.setCellEditor(new DefaultCellEditor (textBox));

        table.setCellSelectionEnabled(true);

        scrollPane=new JScrollPane(table);

        topPanel.add(scrollPane,BorderLayout.CENTER);


        table.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent e) {

            }
        });
    }

    public class myTableModel extends DefaultTableModel

    {

        myTableModel()

        {

            super(dataValues,columnNames);

        }

        public boolean isCellEditable(int row,int cols)

        {

            return false;

        }

    }

    public static void main(String args[])

    {

        Timetable x=new Timetable();

        x.setVisible(true);

    }

}

