package member.nyngwang.area;

public class Triangle extends Shape {
	protected double base;
	protected double height;
	
	public Triangle setBase(double base) {
		this.base = base;
		onAreaChange();
		return this;
	}
	
	public Triangle setHeight(double height) {
		this.height = height;
		onAreaChange();
		return this;
	}

	@Override
	public void onAreaChange() {
		this.area = 0.5 * this.base * this.height;
	}
}
