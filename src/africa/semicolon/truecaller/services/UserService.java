package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.data.models.User;
import africa.semicolon.truecaller.data.repositories.ContactRepoImplement;
import africa.semicolon.truecaller.data.repositories.ContactRepository;
import africa.semicolon.truecaller.data.repositories.UserRepository;
import africa.semicolon.truecaller.data.repositories.UserRepositoryImplement;
import africa.semicolon.truecaller.dtos.request.AddContactReq;
import africa.semicolon.truecaller.dtos.request.RegisterRequest;
import africa.semicolon.truecaller.dtos.response.AddContactResponse;
import africa.semicolon.truecaller.dtos.response.RegisterUserResponse;
import africa.semicolon.truecaller.exceptions.UserExistsException;

import java.util.List;

public class UserService implements iUserService{
    private UserRepository userRepository;
    private ContactRepository contactRepository;
    private  final iContactService contactService;
    public UserService(){
        this.userRepository = new UserRepositoryImplement();
        this.contactRepository = new ContactRepoImplement();
        this.contactService =new ContactService();
    }
    @Override
    public RegisterUserResponse register(RegisterRequest request) throws UserExistsException {
        var savedUser = userRepository.findByEmail(request.getEmail());
        if (savedUser != null)throw new UserExistsException(request.getEmail() + " already exists.");
        User user = new User();
        user.setUserName(request.getUserName());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        userRepository.save(user);
        return null;
    }



    @Override
    public AddContactResponse addContact(AddContactReq AddContactResponse) {
        Contact contact = new Contact();
        contact.setEmail(AddContactResponse.getEmail());
        contact.setFirstName(AddContactResponse.getFirstName());
        contact.setLastName(AddContactResponse.getLastName());
        contact.setPhoneNumber(AddContactResponse.getPhoneNumber());
        contact.setUserEmail(AddContactResponse.getUserEmail());
        Contact savedContact = contactService.addNewContact(contact);
        User user = userRepository.findByEmail((AddContactResponse.getUserEmail()));
        user.getContacts().add(savedContact);
        userRepository.save(user);
        return null;
    }

    @Override
    public int getNumberOfUsers() {
        return userRepository.count();
    }

    @Override
    public User getUserByFirstName(String firstName) {
        User user =  userRepository.findByFirstName(firstName);
        return user;
    }


    @Override
    public List<Contact> findContact(String userEmail) {
        User user = userRepository.findByEmail(userEmail);
        return user.getContacts();
    }
}
