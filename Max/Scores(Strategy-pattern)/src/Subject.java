
public class Subject {
	private CalculationStrategy myStrategy;
	private Scores scores;
	private int attend;
	private int homework;
	private int middleexam;
	private int finalexam;
	public Subject(CalculationStrategy myStrategy , Scores scores){
		this.myStrategy = myStrategy;
		this.scores = scores;
		calculationScore();
	}
	public void calculationScore() {
		System.out.print("�Ǵ��`���Z = ");
		System.out.println(myStrategy.calcuationScore(scores));
		if(myStrategy.calcuationScore(scores) < 60)
			System.out.println("���ߧA�Q��F");
		}
	
}
