package Builder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtBuilder implements FileBuilder{
	private String fileName;
	private List<String> contents = new ArrayList<>();
	
	@Override
	public FileBuilder fileName(String fileName) {
		this.fileName = fileName + ".txt";
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
			for (String content : contents)
				writer.write(content + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file;
	}

}

