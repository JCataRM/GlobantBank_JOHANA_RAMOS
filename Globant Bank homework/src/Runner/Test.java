package Runner;

import Data.BankAccount;
import Data.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Client> listClients = new ArrayList<Client>();

        listClients.add(new Client("Catalina", "Catalina", new BankAccount("2938420000", 2029)));
        listClients.add(new Client("Joan", "Joan", new BankAccount("1230008765", 7000)));
        listClients.add(new Client("Pepito", "Pepito", new BankAccount("289765483", 3200)));
        listClients.add(new Client("Cristina", "Cristina", new BankAccount("2093482038", 9000)));
        listClients.add(new Client("Pedro", "Pedro", new BankAccount("987120003", 4600)));
        listClients.add(new Client("Maria", "Maria", new BankAccount("378725000", 0)));

        System.out.println("Welcome to Globant Bank \n" +
                "Please introduce your user:");
        String userName = scan.nextLine();
        System.out.println("Please introduce your password:");
        String passwordUser = scan.nextLine();

        Client currentClient = null;

        for (Client objClient: listClients) {
            if(userName.equals(objClient.getUser()) && passwordUser.equals(objClient.getPassword())){
                currentClient = objClient;
                System.out.println("Then, mark the desire option:");
            }
        }

        if(currentClient != null) {
            Boolean menu = true;
            while(menu){
                System.out.println("1. Print all clients and their related information.");
                System.out.println("2. Add money to the account.");
                System.out.println("3. Withdraw money from the account.");
                System.out.println("4. Transfer money to another bank account.");
                System.out.println("5. Exit to the program.");

                int option = Integer.valueOf(scan.nextLine());
                switch (option) {
                    case 1:
                        System.out.println(listClients);
                        break;
                    case 2:
                        System.out.println("Introduce the amount to add:");
                        double addAmount = Double.valueOf(scan.nextLine());
                        currentClient.getSavingAccount().addMoney(addAmount);
                        System.out.println("Your balance is: " + currentClient.getSavingAccount().getBalance());
                        break;
                    case 3:
                        System.out.println("Introduce the amount that you want withdraw:");
                        double withdrawAmount = Double.valueOf(scan.nextLine());
                        String result = currentClient.getSavingAccount().withdrawMoney(withdrawAmount);
                        System.out.println(result);
                        System.out.println("Your balance is: " + currentClient.getSavingAccount().getBalance());
                        break;
                    case 4:
                        System.out.println("Introduce account number to transfer");
                        String accountTransfer = scan.nextLine();
                        Boolean transferResult = true;
                        for (Client obj: listClients) {
                            if(obj.getSavingAccount().getAccountNumber().equals(accountTransfer)) {
                                System.out.println("Introduce the amount that you want to transfer another bank account:");
                                double transferAmount = Double.valueOf(scan.nextLine());
                                System.out.println(currentClient.getSavingAccount().transferMoney(transferAmount));
                                transferResult = false;
                                obj.getSavingAccount().addMoney(transferAmount);
                                System.out.println("Your balance is: " + currentClient.getSavingAccount().getBalance());
                            }
                        }

                        if(transferResult) {
                            System.out.println("The accountNumber not exist.");
                        }
                        break;
                    case 5:
                        menu = false;
                        break;
                    default:
                        System.out.println("Mark the options from 1 to 5 please.");
                }
            }
        } else {
            System.out.println("The user and password are wrong or don´t exist.");
        }
    }
}