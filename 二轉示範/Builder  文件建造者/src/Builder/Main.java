package Builder;

import java.io.File;
import java.util.TreeSet;

import Util.Input;

public class Main {

	public static void main(String[] args) {
		do
		{
			int type = Input.nextInt("��J�ɮ�����: (0) csv (1) txt", 0, 1);
			FileBuilder builder = createBuilder(type);
			File file = builder.fileName(Input.nextLine("��J�ɮצW�� : "))
				.addContent(Input.nextLine("��J�T���ɮפ��e�G"))
				.addContent(Input.nextLine())
				.addContent(Input.nextLine())
				.buildFile();

			System.out.println("�سy����: " + file.getAbsolutePath());
		}while(true);
	}
	
	private static FileBuilder createBuilder(int type){
		switch(type)
		{
		case 0:
			return new CsvBuilder();
		default:
			return new TxtBuilder();
		}
	}

}
