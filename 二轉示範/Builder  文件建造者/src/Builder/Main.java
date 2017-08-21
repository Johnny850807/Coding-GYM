package Builder;

import java.io.File;
import java.util.TreeSet;

import Util.Input;

public class Main {

	public static void main(String[] args) {
		do
		{
			int type = Input.nextInt("輸入檔案類型: (0) csv (1) txt", 0, 1);
			FileBuilder builder = createBuilder(type);
			File file = builder.fileName(Input.nextLine("輸入檔案名稱 : "))
				.addContent(Input.nextLine("輸入三行檔案內容："))
				.addContent(Input.nextLine())
				.addContent(Input.nextLine())
				.buildFile();

			System.out.println("建造完成: " + file.getAbsolutePath());
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
