package ¦¨ÁZ;

public class CodeCalculate implements Calculate{
	@Override
	public double sumSource(double attendSource, double workSource, double midExamSource, double finalExamSource) {
		// TODO Auto-generated method stub
		return (attendSource*0.5 + workSource*0.5)*0.2 + midExamSource*0.4 + finalExamSource*0.4;
	}

}
