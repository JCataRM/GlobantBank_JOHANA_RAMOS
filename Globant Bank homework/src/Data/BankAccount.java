package Data;

import java.util.Date;

public class BankAccount {
    final private String accountNumber;
    final private Date openingDate;
    private double balance;

    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.openingDate = new Date();
        this.setBalance(balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String withdrawMoney(double withdrawAmount){
        String message = "";

        if((balance >= withdrawAmount + 200) && withdrawAmount < 1000){
            balance = balance - (withdrawAmount + 200);
        } else if ((balance >= withdrawAmount + 200 + (withdrawAmount * 0.15)) && withdrawAmount >= 1000) {
            balance = balance - ((withdrawAmount * 0.15) + (withdrawAmount + 200));
        } else {
            message = "Withdraw canceled, insufficient balance";
        }
        return message;
    }

    public void addMoney(double addAmount){ //Se pasan como parametros las variables que no tengo, balance ya está declarada en la clase, entonces no se pasa
        balance += addAmount;
    }

    public String transferMoney(double transferAmount) {
        String message = "";

        if(balance >= transferAmount + 100){
            balance = balance - (transferAmount + 100);
        }else {
            message = "Insuficient funds to transfer";
        }
        return message;
    }
}
