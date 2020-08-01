import java.io.IOException;

public class Login {

    private UserList list;

    public Login()  {
       initialization();
    }

    public void initialization(){
        try{
            list = new UserList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login(String account,String password) {
        try {
            list.judementLoginInput(account, password);
        }catch(UserInputError | IOException e){
            e.printStackTrace();
        }
    }

    public void register(String account,String password,String id){
        try{
            list.readAllFile();
            list.NewUser(account,password,id);
        }catch(AccountDuplicate | IOException e){
            e.printStackTrace();
        }
    }
    public void print(){
        list.printUserList();
    }
}
