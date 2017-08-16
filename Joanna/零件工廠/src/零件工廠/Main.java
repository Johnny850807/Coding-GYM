package �s��u�t;

public class Main {

	public static void main(String[] args) {
		Factory<Screw , Car> carFactory = new Factory<Screw,Car>();
		carFactory.setComponent(new Screw());
		carFactory.setProduct(new Car());
		carFactory.hoardComponents(1);
		try {
			carFactory.produceProduct();
			System.out.println("�Ͳ�����");
		} catch (InsufficientPartsException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
