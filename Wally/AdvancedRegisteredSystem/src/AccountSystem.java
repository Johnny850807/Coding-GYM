import java.io.*;

public abstract class AccountSystem {

	protected static boolean isRepeated ;

	protected static String path = "..//..//資源區//IO進階登入//帳密.txt";
	
	protected static StringBuilder accountRecord = new StringBuilder();
	protected static StringBuilder theAccountWaittingForCheck = new StringBuilder();
	protected static StringBuilder userName = new StringBuilder();

	public static void inputAccountForLogInOrRegistered() {
		
		try {
			
			theAccountWaittingForCheck = inputAccount();
			isRepeated = checkInputUserAccountIsSameAsAccountRecord();
			
		}catch( IOException e) {
			
		}	
		
	}

	protected static StringBuilder inputAccount() {
		
		
		StringBuilder inputUserAccount = new StringBuilder();
		StringBuilder inputUserName = new StringBuilder();

		System.out.println("請輸入帳號 ");
		inputUserAccount.append(Main.input.nextLine()).append(" ") ;
		
		System.out.println("請輸入密碼 ");
		inputUserAccount.append(Main.input.nextLine()).append(" ")  ;
		
		System.out.println("請輸入使用者名稱 ");
		inputUserName.append(Main.input.nextLine());
		inputUserAccount.append(inputUserName.toString())  ;
		
		setUserName( inputUserName );
				
		return inputUserAccount ;
	}
	
	protected static  boolean checkInputUserAccountIsSameAsAccountRecord() throws IOException {
		
		accountRecord = getOldAccounts();
		
		if (accountRecord.indexOf((theAccountWaittingForCheck).toString())  > -1 ){
			return true ;
		}else {
			return false ;
		}
		
	}
	
	protected static  StringBuilder getOldAccounts() throws IOException {
		
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);	
		
		StringBuilder oldAccounts = new StringBuilder();
		
		while (br.ready()) {
			oldAccounts.append(br.readLine()).append("\r");
		}
		br.close();
		return oldAccounts;
		
	}
	
	protected  void createNewAccount( StringBuilder inputUserAccount ) throws IOException {
		
		FileWriter fw = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fw);

		accountRecord.append(inputUserAccount.toString());
		
		fw.write(accountRecord.toString());
		fw.flush();
		fw.close();
		
	}
		
	protected  StringBuilder getUserName() {
		return userName;
	}

	protected static  void setUserName( StringBuilder userName ) {
		AccountSystem.userName = userName;
	}
	protected static  boolean isRepeated() {
		return isRepeated;
	}
	
}
