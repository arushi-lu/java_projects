package outside;

import banking_system.ATM;
import banking_system.Bank;
import outside.Customer;

public class Tester {

    public static void main(String[] args) {

    Bank bank = new Bank();
    ATM atm = new ATM();
    ATM atm_2 = new ATM();
    atm.setBank(bank);
    atm_2.setBank(bank);

    Customer customer = new Customer(bank, atm);
    Customer john = new Customer(bank, atm);
    Customer kevin = new Customer(bank, atm_2);


    customer.openAccount();
    customer.depositMoney(100);
    System.out.println(customer.checkBalance());
    customer.withdrawMoney(50);
    System.out.println(customer.checkBalance());

    john.withdrawMoney(100);
        System.out.println(john.checkBalance());




    }
}
