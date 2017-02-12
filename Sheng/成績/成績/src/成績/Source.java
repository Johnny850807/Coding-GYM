package 成績;

public abstract class Source {
	protected String subject;
	protected double sumSource;
	protected double attendSource;
	protected double midExamSource;
	protected double finalExamSource;
	protected double workSource;
	public Source(int attendSource,int midExamSource,int finalExamSource,int workSource)
	{
		this.attendSource = attendSource;
		this.midExamSource = midExamSource;
		this.finalExamSource = finalExamSource;
		this.workSource = workSource;
		sumSource = 0;
		subject = "未輸入";
	}
	public abstract void calculate();
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
