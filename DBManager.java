package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/items?useUnicode=true&serverTimezone=UTC","root", ""
            );
            System.out.println("CONNECTED");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList <Items> getItems(){
        ArrayList<Items> items = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM items");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                items.add(new Items(id, name, price));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }
    public void addItems(Items item){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO items(id, name, price) values(NULL,?,?)");
            st.setString(1,item.getName());
            st.setDouble(2,item.getPrice());
            st.executeUpdate();
            st.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteItem(Long id){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM items where id = ?");
            st.setLong(1, id);
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

