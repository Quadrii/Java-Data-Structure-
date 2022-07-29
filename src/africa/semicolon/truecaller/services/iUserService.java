package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.data.models.User;
import africa.semicolon.truecaller.dtos.request.AddContactReq;
import africa.semicolon.truecaller.dtos.request.RegisterRequest;
import africa.semicolon.truecaller.dtos.response.AddContactResponse;
import africa.semicolon.truecaller.dtos.response.RegisterUserResponse;

import java.util.List;

public interface iUserService{
    RegisterUserResponse register(RegisterRequest request);
    AddContactResponse addContact(AddContactReq AddContactResponse);
    User getUserByFirstName(String firstName);

    int getNumberOfUsers();

    List<Contact> findContact(String userEmail);
}
