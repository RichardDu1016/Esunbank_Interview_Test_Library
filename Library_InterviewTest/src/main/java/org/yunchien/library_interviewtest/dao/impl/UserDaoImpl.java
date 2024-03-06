package org.yunchien.library_interviewtest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.yunchien.library_interviewtest.dao.UserDao;
import org.yunchien.library_interviewtest.dto.UserRegisterRequest;
import org.yunchien.library_interviewtest.model.User;
import org.yunchien.library_interviewtest.rowmapper.UserRowMapper;

import javax.naming.NameParser;
import java.util.*;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createUser(UserRegisterRequest userRegisterRequest) {

        String sql = "INSERT INTO `user` (phone_number, password, user_name, registration_time)" +
                " VALUES ( :phoneNumber, :password, :userName, :registrationTime);";

        Map<String, Object> map = new HashMap<>();
        map.put("phoneNumber", userRegisterRequest.getPhoneNumber());
        map.put("password" , userRegisterRequest.getPassword());
        map.put("userName" , userRegisterRequest.getUserName());

        Date now = new Date();
        map.put("registrationTime", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql , new MapSqlParameterSource(map), keyHolder);

        int userId = keyHolder.getKey().intValue();

        return  userId;
    }

    @Override
    public User getUserById(Integer userId) {
        String sql = "SELECT user_id, phone_number, password, user_name, registration_time, last_login_time FROM `user` WHERE user_id = :userId" ;
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if(userList.size() > 0){
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User getUserByPhone(String phoneNumber) {
        String sql = "SELECT user_id, phone_number, password, user_name, registration_time, last_login_time FROM `user` WHERE phone_number = :phoneNumber";

        Map<String, Object> map = new HashMap<>();
        map.put("phoneNumber", phoneNumber);

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

}
