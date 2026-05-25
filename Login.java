/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author nyiko
 */
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.Random;

class Login {

    String username;
    String password;
    String cellPhoneNumber;
    String firstName;
    String lastName;

    public Login(String username, String password, String cellPhoneNumber, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Username validation
    public boolean checkUsername() {
        return username.contains("_") && username.length() <= 5;
    }

    public String registerUsername() {
        if (checkUsername()) {
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    }

    // Password validation
    public boolean checkPasswordComplexity() {

        boolean length = password.length() >= 8;
        boolean capital = password.matches(".*[A-Z].*");
        boolean number = password.matches(".*[0-9].*");
        boolean special = password.matches(".*[^a-zA-Z0-9].*");

        return length && capital && number && special;
    }

    public String registerPassword() {
        if (checkPasswordComplexity()) {
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted, please ensure that your password contains 8 characters, a capital letter, a number, and a special character.";
        }
    }

    // Cell phone validation
    public boolean checkCellPhoneNumber() {
        String regex = "^\\+27[0-9]{9}$";
        return Pattern.matches(regex, cellPhoneNumber);
    }

    public String registerCellPhoneNumber() {
        if (checkCellPhoneNumber()) {
            return "Cell phone number successfully added.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain international code +27.";
        }
    }

    // Login validation
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }

    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return "Welcome " + firstName + ", " + lastName + " it is nice to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

class QuickChat {

    String messageID;
    String recipient;
    String text;
    String messageHash;

    static int totalMessages = 0;

    // Constructor
    public QuickChat(String recipient, String text) {

        this.recipient = recipient;
        this.text = text;

        generateMessageID();
        createMessageHash();
    }

    // Generate random 10-digit ID
    public void generateMessageID() {

        Random random = new Random();

        messageID = String.valueOf(1000000000L
                + (long)(random.nextDouble() * 9000000000L));
    }

    // Check message length
    public boolean checkMessage() {

        return text.length() <= 250;
    }

    // Check recipient number
    public boolean checkRecipientCell() {

        return recipient.startsWith("+27")
                && recipient.length() <= 12;
    }

    // Create message hash
    public void createMessageHash() {

        String[] words = text.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        messageHash = messageID.substring(0, 2)
                + ":"
                + totalMessages
                + ":"
                + firstWord.toUpperCase()
                + lastWord.toUpperCase();
    }

    // Send/store/discard
    public String sentMessage(int choice) {

        if (choice == 1) {

            totalMessages++;

            return "Message successfully sent.";

        } else if (choice == 2) {

            return "Press 0 to delete message.";

        } else if (choice == 3) {

            return "Message successfully stored.";

        }

        return "Invalid option.";
    }

    // Print message
    public String printMessages() {

        return "\nMessage ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + text;
    }

    // Total sent
    public static int returnTotalMessages() {

        return totalMessages;
    }
}

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // REGISTRATION
        System.out.println("===== REGISTRATION =====");

        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Enter Username: ");
        String username = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        System.out.print("Enter Cell Phone Number: ");
        String phone = input.nextLine();

        Login user = new Login(username, password, phone, firstName, lastName);

        // Registration feedback
        System.out.println(user.registerUsername());
        System.out.println(user.registerPassword());
        System.out.println(user.registerCellPhoneNumber());

        // Login only if valid
        if (user.checkUsername() && user.checkPasswordComplexity() && user.checkCellPhoneNumber()) {

            System.out.println("\n===== LOGIN =====");

            System.out.print("Enter Username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter Password: ");
            String loginPassword = input.nextLine();

            boolean loginStatus = user.loginUser(loginUsername, loginPassword);

            System.out.println(user.returnLoginStatus(loginStatus));

            // QUICKCHAT
            if (loginStatus) {

                System.out.println("\nWelcome to QuickChat");

                int option;

                do {

                    System.out.println("\n===== MENU =====");
                    System.out.println("1. Send Messages");
                    System.out.println("2. Show recently sent messages");
                    System.out.println("3. Quit");

                    System.out.print("Choose option: ");
                    option = input.nextInt();
                    input.nextLine();

                    switch (option) {

                        case 1:

                            System.out.print("\nHow many messages do you want to send? ");

                            int numMessages = input.nextInt();
                            input.nextLine();

                            QuickChat[] messages = new QuickChat[numMessages];

                            for (int i = 0; i < numMessages; i++) {

                                System.out.print("\nEnter recipient number: ");

                                String recipient = input.nextLine();

                                System.out.print( "Enter your message: ");

                                String text = input.nextLine();

                                messages[i] = new QuickChat(recipient, text);

                                // Recipient validation
                                if (messages[i].checkRecipientCell()) {

                                    System.out.println("Cell phone number successfully captured.");

                                } else {

                                    System.out.println("Cell phone number incorrectly formatted.");

                                    continue;
                                }

                                // Message validation
                                if (messages[i].checkMessage()) {

                                    System.out.println("Message ready to send.");

                                } else {

                                    int extra = text.length() - 250;

                                    System.out.println("Message exceeds 250 characters by " + extra);

                                    continue;
                                }

                                // Send options
                                System.out.println("\n1. Send Message");
                                System.out.println("2. Discard Message");
                                System.out.println("3. Store Message");

                                System.out.print("Choose option: ");

                                int sendOption = input.nextInt();

                                input.nextLine();

                                System.out.println(messages[i].sentMessage(sendOption));

                                // Display message
                                System.out.println(messages[i].printMessages());
                            }

                            System.out.println("\nTotal messages sent: " + QuickChat.returnTotalMessages());

                            break;

                        case 2:

                            System.out.println("Coming Soon.");

                            break;

                        case 3:

                            System.out.println("Exiting QuickChat...");

                            break;

                        default:

                            System.out.println("Invalid option.");
                    }

                } while (option != 3);
            }

        } else {
            System.out.println("\nRegistration failed. Please try again!");
        }

        input.close();
    }
}