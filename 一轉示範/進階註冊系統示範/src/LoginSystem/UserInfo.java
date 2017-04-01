package LoginSystem;

public class UserInfo {
	private String name;
	private String account;
	private String password;
	public UserInfo( String account, String password ,String name) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return String.format("�ʺ�: %s ,  �b��:  %s  ,  �K�X:  %s", name,account,password);
	}

	public String getName() {
		return name;
	}
	public String getAccount() {
		return account;
	}
	public String getPassword() {
		return password;
	}

}
