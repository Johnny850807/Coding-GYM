package �i�����U�t��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class File {
	private static File instance;
	
	private File() {
		super();
		readFile();
	}
	
	public static File getInstance() {
		if (instance == null)
			instance = new File();
		return instance;
	}
	
	
	public void readFile() {
		try {
			FileReader fr = new FileReader("..\\..\\�귽��\\IO�i���n�J\\�b�K.txt");
			BufferedReader br = new BufferedReader(fr);
			
			ArrayList<User> users = new ArrayList<User>();
			UserInformation ui = UserInformation.getInstance();
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] result = line.split(" ");
				ui.addUserInformation(result[0], result[1], result[2]);
			}
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeFile() {

		try {
			FileWriter fw = new FileWriter("..\\..\\�귽��\\IO�i���n�J\\�b�K.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			UserInformation ui = UserInformation.getInstance();
			for (User u : ui.getUsers()) {
				bw.append(u.displayInformation());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	



	
	
}
