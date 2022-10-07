package com.company;

import javax.swing.*;

public class ClientMenu extends JPanel {

    private ClientFrame parent;

    private JTextField ipTextField;
    private JTextField portTextField;
    private JTextField errorTextField;
    private JButton connectionButton;

    public ClientMenu(ClientFrame parent){
        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        ipTextField = new JTextField("Write IP");
        ipTextField.setBounds(150, 100, 200, 30);
        add(ipTextField);

        portTextField = new JTextField("Write PORT");
        portTextField.setBounds(150, 200, 200, 30);
        add(portTextField);

        connectionButton = new JButton("Connect");
        connectionButton.setBounds(150, 300, 200, 30);
        connectionButton.addActionListener(e -> {
            String ip = ipTextField.getText();
            String port = portTextField.getText();
            DBManager dbManager = new DBManager(ip ,port);
            if(port.equals("3306") && ip.equals("localhost")) {
                parent.getClientMenu().setVisible(false);
                parent.getApplicationMenu().setVisible(true);
            } else {
                errorTextField = new JTextField("NO CONNECTION");
                errorTextField.setBounds(150, 200, 200, 30);
                add(errorTextField);
            }
        });
        add(connectionButton);
    }
}

