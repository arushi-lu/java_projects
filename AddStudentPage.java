package com.company;

import javax.swing.*;

public class AddStudentPage extends JPanel {
    private ClientFrame parent;

    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JTextField ageTextField;

    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel ageLabel;

    private JButton addButton;
    private JButton backButton;

    private DBManager dbManager = new DBManager("localhost", "3306");

    public AddStudentPage(ClientFrame parent){
        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 100, 50,30);
        add(nameLabel);

        surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(100, 150, 100,30);
        add(surnameLabel);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(100, 200, 50,30);
        add(ageLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(250, 100, 100,30);
        add(nameTextField);

        surnameTextField = new JTextField();
        surnameTextField.setBounds(250, 150, 100,30);
        add(surnameTextField);

        ageTextField = new JTextField();
        ageTextField.setBounds(250, 200, 100,30);
        add(ageTextField);

        addButton = new JButton("ADD");
        addButton.setBounds(100, 300, 100,30);
        addButton.addActionListener(e ->{
            String name = nameTextField.getText();
            String surname = surnameTextField.getText();
            int age = Integer.parseInt(ageTextField.getText());
            Students student = new Students(null, name, surname, age);
            PackageData pd = new PackageData("ADD_STUDENT", null, student);
            dbManager.addStudent(pd);
            System.out.println("Student added successfully!");
        });
        add(addButton);

        backButton = new JButton("BACK");
        backButton.setBounds(250, 300, 100,30);
        backButton.addActionListener(e ->{
            parent.getAddStudentPage().setVisible(false);
            parent.getApplicationMenu().setVisible(true);
        });
        add(backButton);
    }
}

