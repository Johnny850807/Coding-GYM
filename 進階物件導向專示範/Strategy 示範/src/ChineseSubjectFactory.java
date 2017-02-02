
public class ChineseSubjectFactory extends SubjectFactory{

	@Override
	protected String getSubjectName() {
		return "���";
	}

	@Override
	protected SumGradeStrategy getSubjectStrategy() {
		return new ChineseFinalGradeStrategy();
	}




}
