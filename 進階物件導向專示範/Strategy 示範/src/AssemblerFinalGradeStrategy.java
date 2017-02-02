
public class AssemblerFinalGradeStrategy implements SumGradeStrategy{

	@Override
	public int getSumGrade(FinalSubject subject) {
		return subject.getFinalTermGrade();
	}

}
