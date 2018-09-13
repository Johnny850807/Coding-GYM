import java.io.*;

public class FileRecorder {
    private final static String PATH = "..\\..\\資源區\\IO進階登入\\帳密.txt";
    private UserManager userManger;
    private String line = null;

    public FileRecorder(UserManager userManger) {
        this.userManger = userManger;
    }

    public void readFile() throws IOException {
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
            userManger.addUser(new User(user[0], user[1], user[2]));
        }
        bufferedReader.close();
    }

    public void writeUserInfoToFile() throws IOException {
        FileWriter fileWriter = new FileWriter(PATH);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writeUserInfo(writer);
    }

    private void writeUserInfo(BufferedWriter writer) throws IOException {
        for (User user : userManger.getUsers()) {
            writer.append(user.getAccount() + " " + user.getPassword() + " " + user.getName());
            writer.newLine();
        }
        writer.close();
    }


}
