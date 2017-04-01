
public class EnglishSubjectFactory extends SubjectFactory{

	@Override
	protected String getSubjectName() {
		return "­^¤å";
	}

	@Override
	protected SumGradeStrategy getSubjectStrategy() {
		return new EnglishFinalGradeStrategy();
	}




}

