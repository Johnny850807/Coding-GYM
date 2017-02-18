package LoginSystem;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

import LoginSystem.Exception.AccountDuplicateException;
import LoginSystem.Exception.UserNotFoundException;

public class LoginSystem implements Closeable {
	private UserTable userTable;
	
	public LoginSystem(){
		try {
			initiate();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initiate() throws IOException{
		userTable = new UserTable();
	}
	
	public UserInfo searchUser(String account , String password )
	throws UserNotFoundException
	{
		int index = userTable.searchUserIndex(account, password);
		return userTable.getUserByIndex(index);
		
	}
	
	public void registerUser(String name , String account , String password) 
			throws IOException, AccountDuplicateException{
		userTable.addNewUser(name, account, password);
	}

	@Override
	public void close() throws IOException {
		System.out.println("¨t²ÎÃö³¬");
		userTable.close();
	}
}
