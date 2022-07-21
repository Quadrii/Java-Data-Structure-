package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.dtos.request.RegisterRequest;
import africa.semicolon.truecaller.dtos.response.RegisterUserResponse;

public interface iUserService{
    RegisterUserResponse register(RegisterRequest request);

    int getNumberOfUsers();
}
