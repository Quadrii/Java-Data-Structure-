package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.User;
import africa.semicolon.truecaller.data.repositories.UserRepository;
import africa.semicolon.truecaller.data.repositories.UserRepositoryImplement;
import africa.semicolon.truecaller.dtos.request.RegisterRequest;
import africa.semicolon.truecaller.dtos.response.RegisterUserResponse;
import africa.semicolon.truecaller.exceptions.UserExistsException;

public class UserService implements iUserService{
    private UserRepository userRepository = new UserRepositoryImplement();
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
    public int getNumberOfUsers() {
        return userRepository.count();
    }

}
