package banking_system;

public class ATM {
    private Bank bank;
    private int account_num;

    public void setBank(Bank b) {
        this.bank = b;
    }

    public boolean loginToAccount(int acctNum) {

        try{
            bank.accessAccInfo(acctNum);
        }catch (Exception e){
            System.out.println("Cannot login to account");
            return false;
        }
        account_num = acctNum;
        return true;
    }

    public boolean deposit(int amount) {

        if(account_num == 0){
            return false;
        }
        try {
            bank.updateAccBal(account_num, amount);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean withdraw(int amount) {
        if(account_num == 0){
            return false;
        }
        try {
            bank.updateAccBal(account_num, (-amount));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public int getBalance(){
        int balance;
        try{
            balance = bank.accessAccInfo(account_num);
        }catch (Exception e){
            return 0;
        }
        return balance;
    }

    public void logout() {
        account_num = 0;
    }


}
