package 進階註冊系統;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {

	private final static String filePath = "..\\..\\資源區\\IO進階登入\\帳密.txt";
	UserList UI = UserList.getInstance();
	String line = null;
	String[] user;

	public File() {
		readFile();
	}

	public void readFile() {
		try {
			readAllUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readAllUser() throws Exception {
		FileReader FR = new FileReader(filePath);
		BufferedReader reader = new BufferedReader(FR);
		readLine(reader);
	}

	private void readLine(BufferedReader reader) throws IOException {
		while ((line = reader.readLine()) != null) {
			String[] user = new String[3];
			user = line.split(" ");
			UI.addUser(user[0], user[1], user[2]);
		}
		reader.close();
	}

	public void writeFile() {
		try {
			FileWriter FW = new FileWriter(filePath);
			BufferedWriter writer = new BufferedWriter(FW);
			writeUserInfo(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeUserInfo(BufferedWriter writer) throws IOException {
		for (User user : UI.getUsers()) {
			writer.append(user.getAccount() + " " + user.getPassword() + " " + user.getName());
			writer.newLine();
		}
		writer.close();
	}

}
