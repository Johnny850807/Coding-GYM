
public class ChineseSubjectFactory extends SubjectFactory{

	@Override
	protected String getSubjectName() {
		return "°ê¤å";
	}

	@Override
	protected SumGradeStrategy getSubjectStrategy() {
		return new ChineseFinalGradeStrategy();
	}




}
