
public class SignInSystem extends AccountSystem {

	SignInSystem(){
	
	inputAccountForLogInOrRegistered();
	signInResult( isRepeated );
	
	}
	
	private void signInResult( boolean isAccountRepeated ) {
		
		try {
			if ( isAccountRepeated ) {
				System.out.println("歡迎登入 !! " + getUserName());
			}
			else {
				throw new AccountNotFoundException() ;
			}
		}catch(AccountNotFoundException anfe ){
			
		}
		
	}
	
}
