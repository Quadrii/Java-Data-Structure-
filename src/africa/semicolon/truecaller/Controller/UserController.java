package africa.semicolon.truecaller.Controller;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.dtos.request.AddContactReq;
import africa.semicolon.truecaller.dtos.request.RegisterRequest;
import africa.semicolon.truecaller.dtos.response.AddContactResponse;
import africa.semicolon.truecaller.dtos.response.RegisterUserResponse;
import africa.semicolon.truecaller.services.UserService;

import java.util.List;

public class UserController {
    private UserService userService = new UserService();
    public RegisterUserResponse registerUser(RegisterRequest registerRequest){
        System.out.println("User registered successfully");
        return userService.register(registerRequest);
    }

    public AddContactResponse addContact(AddContactReq addContactReq){
        System.out.println("Contact added successfully");
        return userService.addContact(addContactReq);
    }
    public List<Contact> findCont(String email){
        return userService.findContact(email);
    }
}
