package banking_system;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    ArrayList<ATM> atms;
    Bank bank;
    int id = 0;

    public Bank(){
        accounts = new ArrayList<Account>();
        atms = new ArrayList<ATM>();
    }

    public int createAccount() {
        Account account = new Account();
        accounts.add(account);
        account.setAccount_number(++id);
        account.setAccount_balance(0);
        return account.getAccount_number();
    }

    public void attachATM(ATM atm) {
        atms.add(atm);
        atm.setBank(bank);


    }

    public int accessAccInfo(int acctNum) throws Exception{
        int balance = 0;
            for (Account account : accounts) {
                if (account.getAccount_number() == acctNum) {
                    balance =  account.getAccount_balance();
                }else{
                   throw new Exception("Account is not in the system");
                }
            }

        return balance;
    }

    public void updateAccBal(int acctNum, int diff) throws Exception{

            for (Account account : accounts) {
                if (account.getAccount_number() != acctNum) {
                    throw new Exception("Account can not be found");
                }else{
                    account.setAccount_balance(account.getAccount_balance() + diff);
                    if(account.getAccount_balance() < 0){
                        throw new Exception("Negative resulting balance");
                    }
                }
            }

    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}

