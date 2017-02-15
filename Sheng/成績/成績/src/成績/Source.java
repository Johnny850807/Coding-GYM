package ���Z;

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
		System.out.println("�X�u���Z:" + attendSource);
		System.out.println("�������Z:" + midExamSource);
		System.out.println("�������Z:" + finalExamSource);
		System.out.println("�@�~���Z:" + workSource);
		System.out.println("�`���Z:" + sumSource);
	}
}
