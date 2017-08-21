package Builder;

import java.io.File;
import java.util.List;

public interface FileBuilder {
	public FileBuilder fileName(String fileName);
	public FileBuilder addContent(String content);
	public File buildFile();
}
