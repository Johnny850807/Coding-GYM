package account;

import java.io.*;
import java.util.Scanner;

public class AccountSystem {
	
	private final File file=new File("./帳密.txt");
	
	private String nickname;
	
	private String account;
	private String password;
	private Scanner sc;

	
	
	
	public boolean LogIn()  {
		sc=new Scanner(System.in);
		System.out.print("輸入帳號");
		account=sc.nextLine();
		System.out.print("輸入密碼");
		password=sc.nextLine();
		
		
		FileReader fr=null;
		
		try
		{
			fr = new FileReader(file);		
		}		
		catch(FileNotFoundException e) 
		{
			System.out.print(e.getMessage());
		}
		
		
		
		BufferedReader br=new BufferedReader(fr);
				
		try {
			while(br.ready())
			{
				String DB_account=br.readLine();
				String[] readline_split = DB_account.split(" ");
								
				if(account.equals(readline_split[0]) && password.equals(readline_split[1])){
					System.out.println("登入成功 " + readline_split[2]);
					return true;
				}
			
			}
					
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		
		System.out.println("登入失敗!! 帳密不符合");
		Main.staring();
	
		
		return false;
	}
	
	public boolean SingUp(){
		
		sc=new Scanner(System.in);
		System.out.print("輸入要申請的帳號與密碼");
		account=sc.nextLine();
		password=sc.nextLine();
		System.out.print("輸入暱稱");
		nickname=sc.nextLine();
		
		
		
		if(checkRepeatAccount(account)==false){
			writedata(account, password, nickname);
		}else{	
			return false;
		}
		
		
		return true;
	}
	
	
	
	
	
	
	private boolean checkRepeatAccount(String account)  {
		
		FileReader fr=null;
		
		try
		{
			fr = new FileReader(file);		
		}		
		catch(FileNotFoundException e) 
		{
			System.out.print(e.getMessage());
		}
		
		BufferedReader br=new BufferedReader(fr);
		
		
		try {
			while(br.ready())
			{
				String DB_account=br.readLine();
				String[] readline_split = DB_account.split(" ");
		
				
				if(account.equals(readline_split[0])){
					System.out.println("註冊失敗!!! 帳號已存在");
					
					return true;
				}
		
			}
			
			
			System.out.println("註冊成功!!!");
			Main.staring();
		
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	
		
		return false;
	}
	
	private void writedata(String account,String password,String nickname){
		
		FileWriter fw = null;
		
		try {
			fw=new FileWriter(file,true);
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}


		BufferedWriter bw=new BufferedWriter(fw);

		try {
			
			bw.write(account+" ");
			bw.write(password+" ");
			bw.write(nickname);
			bw.write("\r\n");
			
			
		} catch (IOException e) 
		{
			System.out.print(e.getMessage());
		}
		
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
