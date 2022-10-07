package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListStudentsPage extends JPanel {
    private ClientFrame parent;
    private JTable table;
    private JScrollPane scrollPane;

    private JButton buttonBack;
    private DBManager dbManager = new DBManager("localhost", "3306");

    public ListStudentsPage(ClientFrame parent){
        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        buttonBack = new JButton("BACK");
        buttonBack.setBounds(200,400,100,30);
        buttonBack.addActionListener(e -> {
            parent.getListStudentsPage().setVisible(false);
            parent.getApplicationMenu().setVisible(true);
        });
        add(buttonBack);

        table = new JTable();
        table.setFont(new Font("Montserrat", Font.PLAIN, 12));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(460,370);
        scrollPane.setLocation(10,10);
        add(scrollPane);

    }

    public void generateTable(PackageData packageData) {
        ArrayList<Students> students = dbManager.getAllStudents(packageData);

        String[] header = {"id", "name", "surname", "age"};

        Object data[][] = new Object[students.size()][4];
        if (packageData.getOperationType().equals("LIST_STUDENTS")) {
            for (int i = 0; i < students.size(); i++) {
                data[i][0] = students.get(i).getId();
                data[i][1] = students.get(i).getName();
                data[i][2] = students.get(i).getSurname();
                data[i][3] = students.get(i).getAge();
            }
            DefaultTableModel model = new DefaultTableModel(data, header);
            table.setModel(model);
        }
    }
}

