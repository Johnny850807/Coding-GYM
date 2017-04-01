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
		return String.format("¼ÊºÙ: %s ,  ±b¸¹:  %s  ,  ±K½X:  %s", name,account,password);
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
