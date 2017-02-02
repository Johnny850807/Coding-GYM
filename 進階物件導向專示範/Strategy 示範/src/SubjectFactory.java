import java.util.Scanner;

public abstract class SubjectFactory {
	protected FinalSubject subject;
	protected static Scanner userInput = new Scanner(System.in);
	
	public FinalSubject createSubject(){
		subject = new FinalSubject();
		setupSubjectAccordingToUserInput();
		return subject;
	}
	
	private void setupSubjectAccordingToUserInput(){
		subject.setName(getSubjectName());
		subject.setSumGradeStrategy(getSubjectStrategy());
		subject.setParticipantGrade(inputParticipant());
		subject.setHomeWorkGrade(inputHomeworkGrade());
		subject.setMiddleTermGrade(inputMiddleGrade());
		subject.setFinalTermGrade(inputFinalGrade());
	}
	
	private int inputParticipant(){
		System.out.println("出席成績:");
		return userInput.nextInt();
	}
	
	private int inputHomeworkGrade(){
		System.out.println("作業成績:");
		return userInput.nextInt();
	}
	
	private int inputMiddleGrade(){
		System.out.println("期中成績:");
		return userInput.nextInt();
	}
	
	private int inputFinalGrade(){
		System.out.println("期末成績:");
		return userInput.nextInt();
	}
	
	
	protected abstract String getSubjectName();
	
	protected abstract SumGradeStrategy getSubjectStrategy();
	
	
}
