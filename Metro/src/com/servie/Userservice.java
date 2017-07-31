package com.servie;

import java.sql.SQLException;

import com.users.User;

public interface Userservice {
public boolean validate(User user) throws SQLException, Exception;

public boolean updateuser(User user) throws SQLException, Exception;
}
