package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.dtos.request.AddContactReq;
import africa.semicolon.truecaller.dtos.request.RegisterRequest;
import africa.semicolon.truecaller.exceptions.UserExistsException;
import africa.semicolon.truecaller.services.ContactService;
import africa.semicolon.truecaller.services.UserService;
import africa.semicolon.truecaller.services.iUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    iUserService servicee;
    private ContactService contactService;
    private UserRepository userRepository;
    @BeforeEach
    void setUp(){
        userRepository = new UserRepositoryImplement();
        contactService = new ContactService();
        servicee = new UserService();
        contactService = new ContactService();
    }
    @Test
    public void registerTest(){
        iUserService userService = new UserService();
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Ayo");
        request.setUserName("wizard");
        request.setLastName("Balogun");
        request.setPassword("24353627");
        request.setEmail("ayo@gmail.com");
        userService.register(request);
        assertEquals(1, userService.getNumberOfUsers());
    }

    @Test
    public void duplicateEmailTest(){
        RegisterRequest request = new RegisterRequest();
        RegisterRequest request1 = new RegisterRequest();
        iUserService userService = new UserService();
        request.setFirstName("Ayo");
        request.setUserName("wizard");
        request.setLastName("Balogun");
        request.setPassword("24353627");
        request.setEmail("ayo@gmail.com");
        userService.register(request);

        request1.setFirstName("Ade");
        request1.setUserName("graps");
        request1.setLastName("Oluyole");
        request1.setPassword("24353623");
        request1.setEmail("ayo@gmail.com");
        assertEquals(1, userService.getNumberOfUsers());
        assertThrows(UserExistsException.class, () -> userService.register(request1));

    }
    @Test
    public void findByFirstName(){
        RegisterRequest request = new RegisterRequest();
        request.setPassword("27263637");
        request.setEmail("olasco@yahoo.com");
        request.setLastName("Afolabi");
        request.setFirstName("Olaseni");
        request.setUserName("olasco");
        servicee.register(request);
        assertNotNull(servicee.getUserByFirstName("Olaseni"));
    }
    @Test
    public void addContactTest(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Ayo");
        request.setUserName("wizard");
        request.setLastName("Balogun");
        request.setPassword("24353627");
        request.setEmail("ayo@gmail.com");
        servicee.register(request);
        assertEquals(1, servicee.getNumberOfUsers());

        AddContactReq contactReq = new AddContactReq();
        contactReq.setPhoneNumber("25256173");
        contactReq.setFirstName("Laolu");
        contactReq.setLastName("Fadeyi");
        contactReq.setEmail("laolu@yahoo.com");
        contactReq.setUserEmail(request.getEmail());
        servicee.addContact(contactReq);
        assertEquals(1, servicee.findContact(request.getEmail()).size());
    }
}
