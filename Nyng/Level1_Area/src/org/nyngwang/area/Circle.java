package org.nyngwang.area;

public class Circle extends Shape {
	protected double radius;
	protected final double PI = 3.14159265;
	
	public Circle setRadius(double radius) {
		this.radius = radius;
		onAreaChange();
		return this;
	}
	
	@Override
	public void onAreaChange() {
		this.area = this.radius * this.radius * PI;
	}
}
