
public class GuessOddNumberAI extends Player {

	public GuessOddNumberAI() {
	}
	
	public void setPlayerNumber(){
		playerNumber = randomInput.nextInt( 50 ) * 2 + 1 ;
	} // �w�]�_��AI�K�X��k
	public String toString() {
		return "�_��AI" ;
	} // Ū�W�_��AI��k
}
