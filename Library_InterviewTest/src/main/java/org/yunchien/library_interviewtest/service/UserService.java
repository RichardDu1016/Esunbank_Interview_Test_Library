package org.yunchien.library_interviewtest.service;

import org.yunchien.library_interviewtest.dto.UserLoginRequest;
import org.yunchien.library_interviewtest.dto.UserRegisterRequest;
import org.yunchien.library_interviewtest.model.User;

public interface UserService {
    Integer register (UserRegisterRequest userRegisterRequest);
    User getUserById (Integer userId);
    User login (UserLoginRequest userLoginRequest);

}
