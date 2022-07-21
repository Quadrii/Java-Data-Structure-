package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepoImplementTest {
    @Test
    public void saveUserTest(){
        UserRepository userRepository = new UserRepositoryImplement();
        User user = new User();
        user.setFirstName("Collins");
        user.setLastName("Andrew");
        user.setUserName("cole");
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }
    @Test
    public void findsavedUserTest(){
        UserRepository userRepository = new UserRepositoryImplement();
        User user = new User();
        user.setFirstName("Collins");
        user.setLastName("Andrew");
        user.setUserName("cole");
        userRepository.save(user);
        assertEquals(1, userRepository.count());
        User savedUser = userRepository.findById(1);
        assertEquals("Collins", savedUser.getFirstName());
    }
    @Test
    public void findSavedUserByLastName(){
        UserRepository userRepository = new UserRepositoryImplement();
        User user = new User();
        user.setFirstName("Collins");
        user.setLastName("Andrew");
        user.setUserName("cole");
        userRepository.save(user);
        assertEquals(1, userRepository.count());
        User savedUser = userRepository.findById(1);
        assertEquals("Andrew", savedUser.getLastName());
    }
    @Test
    public void deleteUser(){
        UserRepository userRepository = new UserRepositoryImplement();
        User user = new User();
        user.setFirstName("Collins");
        user.setLastName("Andrew");
        user.setUserName("cole");
        userRepository.save(user);
        assertEquals(1, userRepository.count());
        userRepository.delete(1);
        assertEquals(0, userRepository.count());
    }
    @Test
    public void findAllUserTest(){
        UserRepository userRepository = new UserRepositoryImplement();
        User user = new User();
        user.setFirstName("Collins");
        user.setLastName("Andrew");
        user.setUserName("cole");
        userRepository.save(user);

        user.setFirstName("Tolu");
        user.setLastName("Isaac");
        user.setUserName("tolusky");
        userRepository.save(user);
        List<User> users = userRepository.findAll();
        assertEquals(2, users.size());
    }


}
