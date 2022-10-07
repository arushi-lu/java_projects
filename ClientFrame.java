package com.company;

import javax.swing.*;

public class ClientFrame extends JFrame {
    private ClientMenu clientMenu;
    private ApplicationMenu applicationMenu;
    private AddStudentPage addStudentPage;
    private ListStudentsPage listStudentsPage;

    public ClientFrame() {
        setTitle("Students Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 500);

        clientMenu = new ClientMenu(this);
        clientMenu.setVisible(true);
        add(clientMenu);

        applicationMenu = new ApplicationMenu(this);
        applicationMenu.setVisible(false);
        add(applicationMenu);

        addStudentPage = new AddStudentPage(this);
        addStudentPage.setVisible(false);
        add(addStudentPage);

        listStudentsPage = new ListStudentsPage(this);
        listStudentsPage.setVisible(false);
        add(listStudentsPage);


    }


    public ClientMenu getClientMenu() {
        return clientMenu;
    }

    public void setClientMenu(ClientMenu clientMenu) {
        this.clientMenu = clientMenu;
    }

    public ApplicationMenu getApplicationMenu() {
        return applicationMenu;
    }

    public void setApplicationMenu(ApplicationMenu applicationMenu) {
        this.applicationMenu = applicationMenu;
    }

    public AddStudentPage getAddStudentPage() {
        return addStudentPage;
    }

    public void setAddStudentPage(AddStudentPage addStudentPage) {
        this.addStudentPage = addStudentPage;
    }

    public ListStudentsPage getListStudentsPage() {
        return listStudentsPage;
    }
}