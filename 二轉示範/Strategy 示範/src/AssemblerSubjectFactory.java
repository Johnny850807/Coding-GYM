
public class AssemblerSubjectFactory extends SubjectFactory{

	@Override
	protected String getSubjectName() {
		return "²Õ¦X»y¨¥";
	}

	@Override
	protected SumGradeStrategy getSubjectStrategy() {
		return new AssemblerFinalGradeStrategy();
	}




} 