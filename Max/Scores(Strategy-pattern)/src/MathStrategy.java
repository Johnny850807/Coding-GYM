
public class MathStrategy implements CalculationStrategy{
	@Override
	public int calcuationScore(Scores scores) {
		return (int) ( (scores.getAttend() * 0.5 + scores.getHomework() * 0.5) * 0.0 +
				scores.getMiddleExam()*0.0 + scores.getFinalExam() * 1 );
	}
}
