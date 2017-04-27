import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repository {
	private int id;
	@SerializedName("name")
	private String name;
	@SerializedName("description")
	private String description;
	
	
	public Repository(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "專案 " + id + "\n--名稱: "+name+"\n--敘述: "+description+"\n";
	}
	
	
	
	
}