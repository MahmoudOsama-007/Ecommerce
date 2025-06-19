package com.Eccormerce.service.interf;

import com.Eccormerce.dto.LoginRequest;
import com.Eccormerce.dto.Response;
import com.Eccormerce.dto.UserDto;
import com.Eccormerce.entity.User;

public interface UserService {
    Response registerUser(UserDto registrationRequest);
    Response loginUser(LoginRequest loginRequest);
    Response getAllUsers();
    User getLoginUser();
    Response getUserInfoAndOrderHistory();
}
