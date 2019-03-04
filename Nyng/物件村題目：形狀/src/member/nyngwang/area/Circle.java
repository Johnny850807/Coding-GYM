package member.nyngwang.area;

import java.lang.Math;

public class Circle extends Shape {
	protected double radius;
	
	public Circle setRadius(double radius) {
		this.radius = radius;
		onAreaChange();
		return this;
	}
	
	@Override
	public void onAreaChange() {
		this.area = this.radius * this.radius * Math.PI;
	}
}
