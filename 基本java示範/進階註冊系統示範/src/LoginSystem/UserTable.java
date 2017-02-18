package LoginSystem;

import java.io.*;
import java.util.*;

import LoginSystem.Exception.AccountDuplicateException;
import LoginSystem.Exception.UserNotFoundException;

public class UserTable implements Closeable{
	private List<UserInfo> users = Collections.checkedList(new ArrayList<UserInfo>(), UserInfo.class);
	private final static String PATH = "..\\..\\資源區\\IO進階登入\\帳密.txt";
	private File file;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	public UserTable() throws IOException {
		initiateFile();
		selectDataFromUserTable();
	}
	
	private void initiateFile() throws IOException {
			file = new File(PATH);
			reader = new BufferedReader(new FileReader(file));
			writer = new BufferedWriter( new FileWriter(file,true) ); // the "true" means not to replace the old file but to append it.
	}
	
	private void selectDataFromUserTable(){
		try {
			readAllFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readAllFile() throws IOException{
		while(reader.ready())
		{
			String row = reader.readLine();
			StringTokenizer tokenizer = new StringTokenizer(row);
			users.add(new UserInfo(tokenizer.nextToken(),
					tokenizer.nextToken(),tokenizer.nextToken()));
		}
	}
	
	public void printUserList(){
		for ( UserInfo user : users )
			System.out.println(user);
	}
	
	public int searchUserIndex(String account , String password)
			throws UserNotFoundException
	{
		for ( int i = 0 ; i < users.size() ; i ++ )
			if ( account.equals(users.get(i).getAccount()) 
					&& password.equals(users.get(i).getPassword()))
				return i;
		throw new UserNotFoundException();
	}
	
	public UserInfo getUserByIndex(int index){
		return users.get(index);
	}
	
	public void addNewUser(String name , String account , String password) 
	throws IOException , AccountDuplicateException
	{
		checkAccountDuplicate(account);
		String row = String.format("%s %s %s%n", account , password , name);
		writer.append(row);
		users.add(new UserInfo(account,password,name));
	}
	
	private void checkAccountDuplicate(String account)
	throws AccountDuplicateException
	{
		for ( int i = 0 ; i < users.size() ; i ++ )
			if ( account.equals(users.get(i).getAccount()) )
				throw new AccountDuplicateException();
	}
	
	@Override
	public void close() throws IOException {
		reader.close();
		writer.close();
	}
	
}
