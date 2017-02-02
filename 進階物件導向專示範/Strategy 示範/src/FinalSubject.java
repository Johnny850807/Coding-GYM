
public class FinalSubject {
	private String name;
	private int participantGrade;
	private int homeWorkGrade;
	private int middleTermGrade;
	private int finalTermGrade;
	private SumGradeStrategy sumGradeStrategy;
	
	public FinalSubject(){}
	
	public int getSumGrade(){
		/**TODO: delegation **/
		return sumGradeStrategy.getSumGrade(this);
	}
	
	public void printSumGradeInfo(){
		System.out.printf("%s -- 學期總成績  %d%n" , name ,  getSumGrade());
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParticipantGrade() {
		return participantGrade;
	}

	public void setParticipantGrade(int participantGrade) {
		this.participantGrade = participantGrade;
	}

	public int getHomeWorkGrade() {
		return homeWorkGrade;
	}

	public void setHomeWorkGrade(int homeWorkGrade) {
		this.homeWorkGrade = homeWorkGrade;
	}

	public int getMiddleTermGrade() {
		return middleTermGrade;
	}

	public void setMiddleTermGrade(int middleTermGrade) {
		this.middleTermGrade = middleTermGrade;
	}

	public int getFinalTermGrade() {
		return finalTermGrade;
	}

	public void setFinalTermGrade(int finalTermGrade) {
		this.finalTermGrade = finalTermGrade;
	}

	public SumGradeStrategy getSumGradeStrategy() {
		return sumGradeStrategy;
	}

	public void setSumGradeStrategy(SumGradeStrategy sumGradeStrategy) {
		this.sumGradeStrategy = sumGradeStrategy;
	}
	
	
}
