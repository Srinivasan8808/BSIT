package org.example.service;

import org.example.model.Account;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    public void deposit(Account account, double amount) {
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        System.out.println("Deposited ₹" + amount + ". New Balance: ₹" + newBalance);
    }

    public void withdraw(Account account, double amount) {
        if (account.getBalance() >= amount) {
            double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
            System.out.println("Withdrew ₹" + amount + ". New Balance: ₹" + newBalance);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    public void displayAccount(Account account) {
        System.out.println("\nAccount Details:");
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: ₹" + account.getBalance());
    }
}
