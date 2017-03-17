
public class ChineseStrategy implements CalculationStrategy{
	@Override
	public int calcuationScore(Scores scores) {
		return (int) ( (scores.getAttend() * 0.3 + scores.getHomework() * 0.7) * 0.4 +
				scores.getMiddleExam()*0.2 + scores.getFinalExam() * 0.4 );
	}
}
