
public class GuessEvenNumberAI extends Player {

	public GuessEvenNumberAI() {
	}
	public void setPlayerNumber(){
		playerNumber = randomInput.nextInt( 50 ) * 2  ;
	} // �w�]����AI�K�X��k
	public String toString() {
		return "����AI" ;
	} // Ū�W����AI��k
}
