import java.io.File;

import Builder.CsvBuilder;
import Builder.FileBuilder;
import Builder.TxtBuilder;
import Composite.MealsGettable;
import Util.Input;
import Visitor.AbundantVisitor;
import Visitor.MonotonousVisitor;
import Visitor.Visitor;

public class Main {

	public static void main(String[] args) {
		MealsGettable composite = 銘傳菜單Factory.create();
		FileBuilder builder = Input.nextInt("(1) CSV (2) TXT : ",1,2) == 1 ? 
				new CsvBuilder() :  new TxtBuilder();
		builder.fileName("Visitor Pattern");
		Visitor visitor = Input.nextInt("(1) 豐富型 (2) 單調型 : ",1,2) == 1 ? 
				new AbundantVisitor(builder) : new MonotonousVisitor(builder);
		
		for (MealsGettable m : composite)
			m.acceptVisitor(visitor);
		
		File file = builder.buildFile();
		System.out.println("完成 " + file.getAbsolutePath());
	}

}