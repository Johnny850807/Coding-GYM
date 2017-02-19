
public class Man extends Human {

	String[] tokens = str1.split("");
	
	public void eat(){
		for(int i = 0; i < str1.length(); i++){
			if (tokens[i].equals('B') || tokens[i].equals('b')){
				System.out.println("¦n¦n¦Y");
			} else break;
		}
	}
	
	public void sleep(){
		for(int i = 0; i < str1.length(); i++){
			if (tokens[i].equals('B') || tokens[i].equals('b')){
				System.out.println("ZZZ");
			} else break;
		}
	}
}
