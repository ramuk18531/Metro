package com.servie;

import java.sql.SQLException;

import com.Repo.UserRepo;
import com.Repo.UserepoImpl;

import com.users.User;

public class UserserviceImpl implements Userservice {
	private UserepoImpl userRepo;
	public UserserviceImpl()
{
userRepo=new UserepoImpl();		
}
	
	@Override
	public boolean validate(User user) throws SQLException, Exception {
		
		if(userRepo.validate(user)==true)
		{
			return true;
		}
		else{
		System.out.println("iam here in Userservice");
		return false;
	}
	}

	@Override
	public boolean updateuser(User user) throws SQLException, Exception {
		
		if(userRepo.updateuser(user)==true)
		{
			return true;
		}
		else{
		System.out.println("iam here in Userservice");
		return false;
	}
		
		
	}

}
