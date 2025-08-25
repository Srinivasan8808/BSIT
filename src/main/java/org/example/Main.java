package org.example;

import org.example.model.Account;
import org.example.service.BankService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;
import java.util.UUID;

@Configuration
@ComponentScan(basePackages = "org.example")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        BankService bankService = context.getBean(BankService.class);
        Scanner scanner = new Scanner(System.in);

        // User Input for Account Creation
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Initial Balance: ₹");
        double initialBalance = scanner.nextDouble();

        // Create Account with Random Account Number
        Account account = new Account(UUID.randomUUID().toString(), name, initialBalance);

        bankService.displayAccount(account);

        // Simple Console Menu Loop
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Account");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = scanner.nextDouble();
                    bankService.deposit(account, depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    bankService.withdraw(account, withdrawAmount);
                    break;
                case 3:
                    bankService.displayAccount(account);
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
