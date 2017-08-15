
public class Student {
	private int id;
		
	public Student(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "¾Ç¥Í½s¸¹(" + id + ")";
	}

	
}
