
public abstract class PropertyDecorator implements Property{
	Property property;  //�]��
	PropertyDecorator(Property pro){
		this.property = pro;
	}
}
