package ���Z;

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
		subject = "����J";
	}
	public abstract void calculate();
	public void display()
	{
		System.out.println("---------------" + subject + "----------------");
		System.out.println("�X�u���Z:" + attendSource);
		System.out.println("�������Z:" + midExamSource);
		System.out.println("�������Z:" + finalExamSource);
		System.out.println("�@�~���Z:" + workSource);
		System.out.println("�`���Z:" + sumSource);
	}
}
