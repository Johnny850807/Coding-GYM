import java.util.List;
public class Check extends Random {
	
	public void check(List keyIn, List array) {
		int getA = 0, getB = 0;
		Random rd = new Random();
		
		for ( int i = 0 ; i < 4 ; i++ ) {
			for ( int k = 0 ; k < 4 ; k++ ) {
				
				if (keyIn.get(i) == array.get(k)) { /*???????*/
					if ( i == k ) {
						getA++;
					}
					else 
						getB++;
				}
				
			}
		}
		
		if ( getA < 4 ) {
			System.out.println(getA+"A"+getB+"B");
		}
		else 
			System.out.println("«¢«¢´Î´Î");
		
	}
}
