public class Login {
    public static final String account = "123";
    private static final String password = "567";

    public Login(){

    }

    public static void LoginResults(String InputAccount , String InputPassword)
            throws AccountNotFoundException,PasswordNotFoundException,PairInfoNotFoundException
    {
        boolean accountError = checkAccountError(InputAccount);
        boolean passwordError = checkPasswordError(InputPassword);
        if( accountError && passwordError)
            throw new PairInfoNotFoundException();
        if(accountError)
            throw new AccountNotFoundException();
        if(passwordError)
            throw new PasswordNotFoundException();
    }
    public static boolean checkAccountError(String InputAccount){
        return !InputAccount.equals(account);
    }
    public static boolean checkPasswordError(String InputPassword){
        return !InputPassword.equals(password);
    }
}