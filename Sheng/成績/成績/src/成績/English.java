package ¦¨ÁZ;

public class English extends Source{

	public English(int attendSource, int midExamSource, int finalExamSource, int workSource) {
		super(attendSource, midExamSource, finalExamSource, workSource);
		// TODO Auto-generated constructor stub
		subject = "¬Õ¤å";
	}

	@Override
	public void calculate() {
		// TODO Auto-generated method stub
		sumSource = (attendSource*0.4 + workSource*0.6)*0.4 + midExamSource*0.3 + finalExamSource*0.3;
	}

}
