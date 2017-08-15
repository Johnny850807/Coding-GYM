package ¹s¥ó¤u¼t;

public class Factory<C extends Component, P extends Product> {
	
	private C component;
	private P product;
	private int componentAmount = 0;

	public P getProduct() {
		return product;
	}

	public void setProduct(P product) {
		this.product = product;
	}
	
	public C getComponent() {
		return component;
	}

	public void setComponent(C component) {
		this.component = component;
	}
	
	public int getComponentAmount() {
		return component.getComponentAmount();
	}

	public void hoardComponents(int componentAmount) {
		this.componentAmount = component.increaseComponentAmount(componentAmount);
	}
	
	public void produceProduct() throws InsufficientPartsException {
		int consumeComponentAmount = product.getConsumeComponentAmount();
		boolean haveConsumed = component.consumeComponents(consumeComponentAmount);
		if (haveConsumed) 
			componentAmount = component.getComponentAmount();
		else 
			throw new InsufficientPartsException();
	}

}
