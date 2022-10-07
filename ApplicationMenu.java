package com.company;

import javax.swing.*;

public class ApplicationMenu extends JPanel {

    private ClientFrame parent;

    private JButton addStudentButton;
    private JButton listStudentButton;
    private JButton exitButton;


    public ApplicationMenu(ClientFrame parent){
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);

        addStudentButton = new JButton("ADD STUDENT");
        addStudentButton.setBounds(150, 100, 200, 30);
        addStudentButton.addActionListener(e -> {
            parent.getApplicationMenu().setVisible(false);
            parent.getAddStudentPage().setVisible(true);
        });
        add(addStudentButton);


        listStudentButton = new JButton("LIST STUDENTS");
        listStudentButton.setBounds(150, 150, 200, 30);
        listStudentButton.addActionListener(e -> {
            PackageData pd = new PackageData("LIST_STUDENTS");
            parent.getListStudentsPage().generateTable(pd);
            parent.getApplicationMenu().setVisible(false);
            parent.getListStudentsPage().setVisible(true);
        });
        add(listStudentButton);

        exitButton = new JButton("EXIT");
        exitButton.setBounds(150, 200, 200, 30);
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
        add(exitButton);

    }

}

