//Source for python implementation: https://www.geeksforgeeks.org/python-program-to-create-bankaccount-class-with-deposit-withdraw-function/

import java.util.*;

//The Bank Account Class

//Java program using OOP concept to perform some simple bank operations like deposit and withdrawal of money.

public class BankAccount {
    Scanner in = new Scanner(System.in);
    float balance;

    public BankAccount() {
        balance = 0;
        System.out.println("Instance created of the Bank Account Machine.");
    }

    void deposit(float amount) {
        balance += amount;
        System.out.println("Amount Deposited: " + amount);
    }

    void withdraw(float amount) {
        balance -= amount;
        System.out.println("You Withdrew: " + amount);
    }

    void display() {
        System.out.println("Your Available Balance = " + balance);
    }

    // Driver Code

    public static void main(String args[]) {

        // Creating an object of class
        BankAccount s = new BankAccount();

        // Calling functions with that class object
        s.deposit(10);
        s.withdraw(5);
        s.display();

    }
}