
public class GuessOddNumberAI extends Player {

	public GuessOddNumberAI() {
	}
	
	public void setPlayerNumber(){
		playerNumber = randomInput.nextInt( 50 ) * 2 + 1 ;
	} // 預設奇數AI密碼方法
	public String toString() {
		return "奇數AI" ;
	} // 讀名奇數AI方法
}
