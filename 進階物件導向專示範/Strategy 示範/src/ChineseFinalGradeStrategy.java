
public class ChineseFinalGradeStrategy implements SumGradeStrategy{

	@Override
	public int getSumGrade(FinalSubject subject) {
		int commonGrade = countSubjectCommonGrade(subject);
		return (int) (commonGrade * 0.4 + subject.getMiddleTermGrade() * 0.2 + subject.getFinalTermGrade() * 0.4 ) ;
	}

	private int countSubjectCommonGrade(FinalSubject subject){
		return (int) (subject.getHomeWorkGrade()*0.3 + subject.getParticipantGrade()*0.7);
	}
	
}
