package org.yunchien.library_interviewtest.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.yunchien.library_interviewtest.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setPassword(rs.getString("password"));
        user.setUserName(rs.getString("user_name"));
        user.setRegistrationTime(rs.getDate("registration_time"));
        user.setLastLoginTime(rs.getDate("last_login_time"));
        return user;
    }
}
