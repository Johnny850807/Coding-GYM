import java.util.Scanner;

public class Student{
	// ���� �魫 ���Z �Ǹ�
	private float height ;
	private float weight ;
	private float grades ;
	private int id ;
	
	public static Scanner input = new Scanner(System.in);
	
	public static float setNumbers () {
	
	float number ;

	do
	{
		number = input.nextFloat();
	}	while( number < 1 ) ;
		return number ;
	}
	
	public float getHeight() {
		return height;
	}
	public void setHeight() {
		System.out.println("�п�J���� :");
		do
		{
		this.height = Student.setNumbers();
		if	(this.height > 250 )
			System.out.println("�Э��s��J���� :");
		}while(this.height > 250 );
		// ���]���H�g�̦h�ͪ���250���~
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight() {
		System.out.println("�п�J�魫  :");
		do
		{
		this.weight = Student.setNumbers();
		if	(this.weight > 300 )
			System.out.println("�Э��s��J�魫 :");
		}while(this.weight > 300 );
		// ���]�魫�p���O�̦h300���筫
	}
	public float getGrades() {
		return grades;
	}
	public void setGrades() {
		System.out.println("�п�J���Z :");
		do
		{
		this.grades = Student.setNumbers();
		if	(this.grades > 100)
			System.out.println("�Э��s��J���Z :");
		}while(this.grades > 100 );
		// ���p�ǥͤ��a�@���̦h���100��
	}
	public int getId() {
		return id;
	}
	public void setId() {
		System.out.println("�п�J�Ǹ� :");
		this.id = (int)Student.setNumbers() ;
		// �z���޿�J�r��,�ন�\��ڿ�
	}
}