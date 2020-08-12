import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class UserList {

    private File file;
    private BufferedReader read;
    private BufferedWriter write;
    private List<UserInfo> user = Collections.checkedList(new ArrayList<UserInfo>(), UserInfo.class);
    private static final String PATH = "D:\\Java練習\\登入系統練習帳密.txt";

    public UserList() throws IOException {
        initializtationFile();
        readAllFile();
    }

    public void initializtationFile() throws IOException {
        file = new File(PATH);
        read = new BufferedReader(new FileReader(file));
        write = new BufferedWriter(new FileWriter(file, true));

    }

    public void readAllFile() throws IOException {
        while (read.ready()) {
            String input = read.readLine();
            StringTokenizer tok = new StringTokenizer(input);
            user.add(new UserInfo(tok.nextToken(), tok.nextToken(), tok.nextToken()));
        }
    }

    public void judgementLoginInput(String account, String password) throws UserInputError, IOException {
        ;
        readAllFile();
        for (int i = 0; i < user.size(); i++) {
            if (account.equals(user.get(i).getAccount()) && password.equals(user.get(i).getPassword())) {
                System.out.println("歡迎登入 !! " + user.get(i).getID());
                return;
            }
        }
        throw new UserInputError();
    }

    public void NewUser(String account, String password, String id)
            throws IOException, AccountDuplicate {
        checkAccount(account);

        String writein = String.format("%s %s %s%n", account, password, id);
        write.append(writein);
        user.add(new UserInfo("account", "password", "ID"));
        write.flush();

        System.out.println("註冊成功");
    }

    public void checkAccount(String account)
            throws AccountDuplicate, IOException {
        for (int i = 0; i < user.size(); i++) {
            if (account.equals(user.get(i).getAccount())) {
                throw new AccountDuplicate();
            }
        }
    }

    public void printUserList() {
        for (UserInfo user : user)
            System.out.println(user);
    }

}
