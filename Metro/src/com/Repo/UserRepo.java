package com.Repo;

import java.sql.SQLException;

import com.users.User;

public interface UserRepo {
		public boolean validate(User user) throws Exception, SQLException;
public boolean updateuser(User user) throws Exception,SQLException;


}
