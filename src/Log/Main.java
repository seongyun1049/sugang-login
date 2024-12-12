package Log;

import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose an option: ");
        System.out.println("1. Register");
        System.out.println("2. Login");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        if (choice == 1) {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter password: ");
            String pw = scanner.nextLine();
            
            try {
                if (UserService.registerUser(id, pw)) {
                    System.out.println("Registration successful!");
                } else {
                    System.out.println("Registration failed.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (choice == 2) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            
            try {
                if (UserService.authenticateUser(username, password)) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Invalid credentials.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid choice.");
        }
        
        scanner.close();
    }
}
