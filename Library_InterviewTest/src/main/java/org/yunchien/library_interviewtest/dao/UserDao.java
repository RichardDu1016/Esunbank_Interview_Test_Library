package org.yunchien.library_interviewtest.dao;

import org.yunchien.library_interviewtest.dto.UserRegisterRequest;
import org.yunchien.library_interviewtest.model.User;

public interface UserDao {

    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByPhone(String phoneNumber);


}
