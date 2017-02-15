package 成績;

public class Source {
	protected String subject;
	protected double sumSource;
	protected double attendSource;
	protected double midExamSource;
	protected double finalExamSource;
	protected double workSource;
	protected Calculate calculate;
	public Source(String subject,double attendSource,double midExamSource,double finalExamSource,double workSource,Calculate calculate)
	{
		this.attendSource = attendSource;
		this.midExamSource = midExamSource;
		this.finalExamSource = finalExamSource;
		this.workSource = workSource;
		this.subject = subject;
		this.calculate = calculate;
		sumSource = 0;
	}
	public void sumSource()
	{
		sumSource = calculate.sumSource(attendSource, workSource, midExamSource, finalExamSource);
	}
	public void display()
	{
		System.out.println("---------------" + subject + "----------------");
		System.out.println("出席成績:" + attendSource);
		System.out.println("期中成績:" + midExamSource);
		System.out.println("期末成績:" + finalExamSource);
		System.out.println("作業成績:" + workSource);
		System.out.println("總成績:" + sumSource);
	}
}
