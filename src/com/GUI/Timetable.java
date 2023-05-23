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
        initialize();

        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        columnNames = new String[] {"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        dataValues = new String[][] {
                {"8:00"},
                {"8:30"},
                {"9:00"},
                {"9:30"},
                {"10:00"},
                {"10:30"},
                {"11:00"},
                {"11:30"},
                {"12:00"},
                {"12:30"},
                {"13:00"},
                {"13:30"},
                {"14:00"},
                {"14:30"},
                {"15:00"},
                {"15:30"},
                {"16:00"},
                {"16:30"},
                {"17:00"},
                {"17:30"},
                {"18:00"},
                {"18:30"},
                {"19:00"},
                {"19:30"},
                {"20:00"},
                {"20:30"},
                {"21:00"},
                {"21:30"},
                {"22:00"},
                {"22:30"},
                {"23:00"}
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

    public void initialize() {

        setVisible(true);
        setTitle("Timetable");
        setSize(300,300);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
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

        x.initialize();

    }

}

