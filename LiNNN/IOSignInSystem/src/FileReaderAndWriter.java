import java.io.*;

public class FileReaderAndWriter {
    private final static String PATH = "..\\..\\資源區\\IO進階登入\\帳密.txt";
    private UserList userList = new UserList();
    private String line = null;
    private String[] user;

    public FileReaderAndWriter()  {
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile() throws IOException {
        readAllUser();
    }

    private void readAllUser() throws IOException {
        FileReader fileReader = new FileReader(PATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        readUserLineByLine(bufferedReader);
    }

    private void readUserLineByLine(BufferedReader bufferedReader) throws IOException {
        while ((line = bufferedReader.readLine()) != null) {
            String[] user = line.split(" ");
            userList.addUser(new User(user[0], user[1], user[2]));
        }
        bufferedReader.close();
    }

    public void writeUserInfoToFile() throws IOException {
        FileWriter FW = new FileWriter(PATH);
        BufferedWriter writer = new BufferedWriter(FW);
        writeUserInfo(writer);
    }

    private void writeUserInfo(BufferedWriter writer) throws IOException {
        for (User user : userList.getUsers()) {
            writer.append(user.getAccount() + " " + user.getPassword() + " " + user.getName());
            writer.newLine();
        }
        writer.close();
    }


}
