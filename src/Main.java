import africa.semicolon.truecaller.Controller.UserController;
import africa.semicolon.truecaller.dtos.request.AddContactReq;
import africa.semicolon.truecaller.dtos.request.RegisterRequest;

import java.util.Scanner;

public class Main {
    private static UserController userController = new UserController();
    private static void createAccount(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName(input("Enter your first name"));
        request.setLastName(input("Enter your last name"));
        request.setUserName(input("Enter your user name"));
        request.setPassword(input("Enter your password"));
        request.setEmail(input("Enter your email"));
        userController.registerUser(request);
    }
    private static void addContactToUser(){
        AddContactReq contactReq = new AddContactReq();
        contactReq.setUserEmail(input("Enter username"));
        contactReq.setPhoneNumber(input("Enter username"));
        contactReq.setEmail(input("Enter username"));
        contactReq.setFirstName(input("Enter username"));
        contactReq.setLastName(input("Enter username"));
        userController.addContact(contactReq);
    }
    public static void findContactBelongingToUser(){
        var contacts = userController.findCont(input("Enter email"));
        for (var contact: contacts){
            System.out.println(contact.toString());
        }
        displayMenu();
    }
    public static void displayMenu(){
        String mainMenuPrompt= """
                Welcome to fake caller
                1->Create an Account
                2->Add contact to a user
                3->Find contact belonging to user
                """;
        System.out.println(mainMenuPrompt);
        String userInput = keyboardInput.nextLine();
        switch (userInput.charAt(0)){
            case '1'-> createAccount();
            case '2'-> addContactToUser();
            case '3'-> findContactBelongingToUser();
        }
    }
    private static final Scanner keyboardInput = new Scanner(System.in);
    public static void main(String[] args) {
        displayMenu();
    }
    public static String input(String prompt){
        System.out.println(prompt);
        return keyboardInput.nextLine();
    }
}
