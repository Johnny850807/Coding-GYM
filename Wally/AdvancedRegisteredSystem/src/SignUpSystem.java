import java.io.IOException;

public class SignUpSystem extends AccountSystem {
	
	SignUpSystem() throws IOException{
		
	inputAccountForLogInOrRegistered();
	signUpResult( isRepeated );
		
	}

	private void signUpResult( boolean isAccountRepeated ) throws IOException {
		
		StringBuilder theAccountCheckd =  theAccountWaittingForCheck ;
		
		try {
			if ( isAccountRepeated ) {
				throw new AccountExistedException() ;
			}
			else {
				createNewAccount( theAccountCheckd );
			}
		}catch( AccountExistedException aee ){
			
		}
	
	}	
	
}
