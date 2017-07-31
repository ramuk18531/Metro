package com.Repo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connections.DBConnection;
import com.constants.Constant;
import com.users.User;

public class UserepoImpl implements UserRepo{

	@Override
	public boolean validate(User user) throws Exception, SQLException {
		java.sql.PreparedStatement pr=DBConnection.getDBConnection().prepareStatement(Constant.VALIDATE_USER);
		System.out.println("Iam in USERREPOIMPL");
		pr.setString(1, user.getUsername());
		pr.setString(2, user.getPassword());
		
		ResultSet rs=pr.executeQuery();
		if(rs.next())
		{	
			return true;
		
		}	
		else{
			System.out.println("USERREPO failed");
		}	
			
	
	return false;

	}

	@Override
	public boolean updateuser(User user) throws Exception, SQLException {
		PreparedStatement pr= DBConnection.getDBConnection().prepareStatement(Constant.UPDATE_USER);
		pr.setString(1, user.getFirstname());
		pr.setString(2, user.getLastname());

		pr.setString(3, user.getUsername());
		pr.setString(4, user.getPassword());
		pr.setString(5, user.getCpassword());
		pr.setString(6, user.getEmail());
		pr.setString(7, user.getPhone());
		pr.setString(8, user.getAge());
		
		pr.executeUpdate();
		pr.close();
	return true;
	}
}