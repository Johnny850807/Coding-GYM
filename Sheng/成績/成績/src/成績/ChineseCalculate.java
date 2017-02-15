package ¦¨ÁZ;

public class ChineseCalculate implements Calculate{
	@Override
	public double sumSource(double attendSource, double workSource, double midExamSource, double finalExamSource) {
		// TODO Auto-generated method stub
		return (attendSource*0.5 + workSource*0.5)*0.4 + midExamSource*0.3 + finalExamSource*0.3;
	}
}
