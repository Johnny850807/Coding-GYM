package Builder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvBuilder implements FileBuilder{
	private String fileName;
	private List<String> contents = new ArrayList<>();
	
	@Override
	public FileBuilder fileName(String fileName) {
		this.fileName = fileName + ".csv";
		return this;
	}

	@Override
	public FileBuilder addContent(String content) {
		contents.add(content);
		return this;
	}

	@Override
	public File buildFile() {
		File file = new File(fileName);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
			StringBuilder builder = new StringBuilder();
			for (String content : contents)
				builder.append(content).append(",");
			String text = builder.toString();
			text = text.substring(0, text.length()-1);  //§R°£³r¸¹
			writer.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file;
	}

}
