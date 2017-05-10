public class Main {
	public static void main(String[] args){
		Factory<Box , Robot> br = new Factory();
		br.addComponent(new Box());
		br.addComponent(new Box());
		br.addComponent(new Box());
		br.addComponent(new Box());
		br.addComponent(new Box());
		br.addComponent(new Box());
		br.print();
		br.generateProduct(new Robot());
		br.print();
		br.generateProduct(new Robot());
		br.print();
		br.generateProduct(new Robot());
		br.print();
		Factory<Screw,Car> sc = new Factory();
		sc.addComponent(new Screw());
		sc.addComponent(new Screw());
		sc.addComponent(new Screw());
		sc.print();
		sc.generateProduct(new Car());
		
	}
}
