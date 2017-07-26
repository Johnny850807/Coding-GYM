package ¶i¶¥µù¥U¨t²Î;

import java.util.ArrayList;

public class UserInformation {
	private static UserInformation instance;
	private ArrayList<User> users = new ArrayList<User>();

	public ArrayList<User> getUsers() {
		return users;
	}

	private UserInformation() {
		super();
	}

	public static UserInformation getInstance(){
		if (instance == null)
			instance = new UserInformation();
		return instance;
	}
	
	public void addUserInformation(String account, String password, String name) {
		User u = new User();
		u.setAccount(account);
		u.setPassword(password);
		u.setName(name);
		users.add(u);
	}
	
	public String compare(String account, String password) throws UserInformationNotFoundException {
		for (User u : users) {
			if(u.getAccount().equals(account) && u.getPassword().equals(password))
				return u.getName();
		}
		throw new UserInformationNotFoundException();
	}
	
	public void compare(String account) throws UserAccountIsExistedException {
		for (User u : users) {
			if(u.getAccount().equals(account)) 
				throw new UserAccountIsExistedException();
		}
	}
	
}
