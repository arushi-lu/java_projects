package outside;

import banking_system.ATM;
import banking_system.Bank;

public class Customer {
    private Bank b;
    private ATM atm;
    private int accNum;

    public Customer(Bank bank, ATM a) {
        b = bank;
        atm = a;
    }

    public int openAccount() {
        accNum = b.createAccount();
        System.out.println(accNum);
        return accNum;
    }

    public void depositMoney(int amount){
        atm.loginToAccount(accNum);
        atm.deposit(amount);
        atm.logout();
    }

    public void withdrawMoney(int amount) {

        atm.loginToAccount(accNum);
        atm.withdraw(amount);
        atm.logout();
    }

    public int checkBalance(){
        atm.loginToAccount(accNum);
        int balance = atm.getBalance();
        atm.logout();
        return balance;
    }
}


