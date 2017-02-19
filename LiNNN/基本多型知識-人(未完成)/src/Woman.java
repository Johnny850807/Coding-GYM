
public class Woman extends Human {

	String[] tokens = str1.split("");
	
	public void eat(){
		for(int i = 0; i < str1.length(); i++){
			if (tokens[i].equals('g') || tokens[i].equals('G')){
				System.out.println("Orzz");
			} else break;
		}
	}
	
	public void sleep(){
		for(int i = 0; i < str1.length(); i++){
			if (tokens[i].equals('g') || tokens[i].equals('G')){
				System.out.println(":)");
			} else break;
		}
	}
}
