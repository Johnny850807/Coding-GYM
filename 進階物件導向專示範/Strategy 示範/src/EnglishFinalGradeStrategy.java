
public class EnglishFinalGradeStrategy implements SumGradeStrategy{

	@Override
	public int getSumGrade(FinalSubject subject) {
		int commonGrade = countSubjectCommonGrade(subject);
		return (int) (commonGrade * 0.4 + ( subject.getMiddleTermGrade() + subject.getFinalTermGrade() ) * 0.3) ;
	}

	private int countSubjectCommonGrade(FinalSubject subject){
		return (int) (subject.getHomeWorkGrade()*0.6 + subject.getParticipantGrade()*0.4);
	}
	
}
