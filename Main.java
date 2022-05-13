package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DBManager dbManager = new DBManager();
        dbManager.connect();

        while (true){
            System.out.println("PRESS [1] TO ADD ITEMS");
            System.out.println("PRESS [2] TO LIST ITEMS");
            System.out.println("PRESS [3] TO DELETE ITEMS");
            System.out.println("PRESS [0] TO EXIT");

            int choice = in.nextInt();
            if (choice == 1){
                System.out.print("Insert name: ");
                String name = in.next();
                System.out.print("Insert price: ");
                Double price = in.nextDouble();

                Items item = new Items(null, name, price);
                dbManager.addItems(item);
                System.out.println("Item added successfully!");

            }else if (choice == 2){
                ArrayList<Items> items = dbManager.getItems();
                for (Items i: items){
                    System.out.println(i.toString());
                }

            }else if (choice == 3){
                System.out.print("Insert id to delete item: ");
                Long id = in.nextLong();
                dbManager.deleteItem(id);
                System.out.println("Item deleted successfully!");

            }else if (choice == 0){
                break;
            }else {
                System.out.println("NO SUCH CHOICE!!!");
                System.out.println("HELLO");
            }
        }
    }
}
