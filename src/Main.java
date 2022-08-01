import africa.semicolon.truecaller.Controller.UserController;
import africa.semicolon.truecaller.dtos.request.AddContactReq;
import africa.semicolon.truecaller.dtos.request.RegisterRequest;

import java.util.Scanner;

public class Main {
    private static final Scanner keyboardInput = new Scanner(System.in);

    private static UserController userController = new UserController();
    public static String input(String prompt){
        System.out.println(prompt);
        return keyboardInput.nextLine();
    }
    private static void createAccount(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName(input("Enter your first name"));
        request.setLastName(input("Enter your last name"));
        request.setUserName(input("Enter your user name"));
        request.setPassword(input("Enter your password"));
        request.setEmail(input("Enter your email"));
        userController.registerUser(request);
        displayMenu();
    }
    private static void addContactToUser(){
        AddContactReq contactReq = new AddContactReq();
        contactReq.setUserEmail(input("Enter user email"));
        contactReq.setFirstName(input("Enter first name"));
        contactReq.setLastName(input("Enter last name"));
        contactReq.setEmail(input("Enter email"));
        contactReq.setPhoneNumber(input("Enter phone Number"));
        userController.addContact(contactReq);
        displayMenu();
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
    public static void main(String[] args) {
        displayMenu();
    }

}
