
public class EnglishSubjectFactory extends SubjectFactory{

	@Override
	protected String getSubjectName() {
		return "�^��";
	}

	@Override
	protected SumGradeStrategy getSubjectStrategy() {
		return new EnglishFinalGradeStrategy();
	}




}

