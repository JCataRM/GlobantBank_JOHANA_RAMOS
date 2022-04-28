package Data;

public class Client {
    final private String user;
    final private String password;
    private BankAccount savingAccount;

    public Client(String user, String password, BankAccount savingAccount){
        this.user = user;
        this.password = password;
        this.setSavingAccount(savingAccount);
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public BankAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(BankAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public String toString(){
        return "User: " + getUser() + ", saving account No." + savingAccount.getAccountNumber() + ", current balance: " + savingAccount.getBalance() + ", and opening date:" + savingAccount.getOpeningDate() + ". \n";
    }
}

