
public class AssemblerSubjectFactory extends SubjectFactory{

	@Override
	protected String getSubjectName() {
		return "�զX�y��";
	}

	@Override
	protected SumGradeStrategy getSubjectStrategy() {
		return new AssemblerFinalGradeStrategy();
	}




} 