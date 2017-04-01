import java.util.Scanner;

public class Main {
	private static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) {
		/** TODO �ݨD:  
		 * 	���   ����  ( �X�u30% + �@�~70% ) 40%, ���� 20% , ���� 40%
		 *  �^��   ����  ( �X�u40% + �@�~60% ) 40%, ���� 30% , ���� 30%
		 *  �զX�y��   ����  ( �X�u50% + �@�~50% ) 0%, ���� 0% , ���� 100%
		 * **/
		
		while(true){
			printInterface();
			countSumGradeAndPrint(inputSubjectType());
		}

	}
	
	private static void printInterface(){
		System.out.println("��ܭp���`���Z���: (1)��� (2)�^�� (3)�զX�y�� : ");
	}
	
	private static int inputSubjectType(){
		int input;
		do
		{
			input = userInput.nextInt();
			if (input < 1 || input > 3)
				System.out.println("��J���~ !!");
		}while ( input < 1 || input > 3 );
		return input;
	}
	
	private static void countSumGradeAndPrint(int subjectType){
		switch(subjectType)
		{
		case 1:
			new ChineseSubjectFactory().createSubject().printSumGradeInfo();
			break;
		case 2:
			new EnglishSubjectFactory().createSubject().printSumGradeInfo();
			break;
		case 3:
			new AssemblerSubjectFactory().createSubject().printSumGradeInfo();
			break;
		}
	}
	

}
