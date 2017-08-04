package 進階註冊系統;

import java.util.ArrayList;

public class UserList {
	private static UserList instance;
	ArrayList<User> users = new ArrayList<>();

	public static UserList getInstance() {
		if (instance == null)
			instance = new UserList();
		return instance;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void addUser(String account, String password, String name) {
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setName(name);
		users.add(user);
	}

	public String checkSignIn(String account, String password) throws UserNotFoundException {
		for (User user : users) {
			if (user.getAccount().equals(account) && user.getPassword().equals(password))
				return String.format("歡迎登入! %s ", user.getName());
		}
		throw new UserNotFoundException();
	}

	public void checkAccountDuplicated(String account) throws AccountDuplicatedException {
		for (User user : users) {
			if (user.getAccount().equals(account))
				throw new AccountDuplicatedException();
		}
	}

}
