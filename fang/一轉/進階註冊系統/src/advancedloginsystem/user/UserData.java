package advancedloginsystem.user;

import advancedloginsystem.execption.UserDuplicateException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserData{
    private final List<User> users = new ArrayList<>();
    public final static String PATH = "帳密.txt";
    private final BufferedReader br;
    private final BufferedWriter bw;

    public UserData() throws IOException {
        File file = new File(PATH);
        br = new BufferedReader(new FileReader(file));
        bw = new BufferedWriter(new FileWriter(file, true));
        readFileToList();
    }

    private void readFileToList() throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] split = line.split(" ");
            User user = new User(split[0], split[1], split[2]);
            users.add(user);
        }
        br.close();
    }

    public User getUser(int pos) {
        return users.get(pos);
    }

    public void signUpUser(String name, String account, String password) throws IOException , UserDuplicateException {
        String userInfo = String.format("%s %s %s%n", name, account, password);
        bw.append(userInfo);
        bw.flush();
        users.add(new User(name, account, password));
        bw.close();
    }

    public int size() {
        return users.size();
    }
}
