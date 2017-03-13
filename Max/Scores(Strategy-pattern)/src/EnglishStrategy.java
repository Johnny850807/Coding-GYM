
public class EnglishStrategy implements CalculationStrategy{
	@Override
	public int calcuationScore(Scores scores) {
		return (int) ( (scores.getAttend() * 0.4 + scores.getHomework() * 0.6) * 0.4 +
				scores.getMiddleExam()*0.3 + scores.getFinalExam() * 0.3 );
	}
}
