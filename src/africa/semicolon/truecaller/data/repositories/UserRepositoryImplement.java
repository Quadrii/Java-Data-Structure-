package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImplement implements UserRepository{
    private List<User> users = new ArrayList<>();
    private int counter;
    @Override
    public User save(User user) {
        var theUser = findById(user.getId());
        if (theUser == null) {
            counter++;
            user.setId(counter);
            users.add(user);
        } else {
            theUser.setUserName(user.getUserName());
            theUser.setFirstName(user.getFirstName());
            theUser.setLastName(user.getLastName());
            theUser.setPassword(user.getPassword());
            theUser.setEmail(user.getEmail());
        }
        return user;
    }

    @Override
    public void delete(User user) {
        for (User myUser : users){
            if (myUser == user){
                users.remove(myUser);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        User user = findById(id);
        users.remove(user);
        System.out.println("Contact deleted");
    }

    @Override
    public User findById(int id) {
        for (var theUser : users){
            if (theUser.getId() == id){
                return theUser;
            }
        }
        return null;
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        for (var myUser : users){
            if (myUser.getFirstName() == firstName){
                return users;
            }
        }
        return null;
    }

    @Override
    public List<User> findByLastName(String lastName) {
        for (var myUser : users){
            if (myUser.getLastName() == lastName){
                return users;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        for (var user : users){
            return users;
        }
        return null;
    }

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public User findByEmail(String email) {
        for (var theUser : users){
            if (theUser.getEmail().equalsIgnoreCase(email)){
                return theUser;
            }
        }
        return null;
    }
}
