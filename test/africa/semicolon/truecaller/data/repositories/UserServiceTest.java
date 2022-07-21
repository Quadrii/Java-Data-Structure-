package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.dtos.request.RegisterRequest;
import africa.semicolon.truecaller.exceptions.UserExistsException;
import africa.semicolon.truecaller.services.UserService;
import africa.semicolon.truecaller.services.iUserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest {
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
}
