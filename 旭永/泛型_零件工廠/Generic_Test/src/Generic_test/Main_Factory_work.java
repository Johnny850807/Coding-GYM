package Generic_test;

public class Main_Factory_work {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("===================零件工廠開始運作===================");
		Factory<Screw,Robot> f=new Factory<>();
		
		f.addComponents(new Screw());
		f.addComponents(new Screw());
		f.addComponents(new Screw());
		f.addComponents(new Screw());
		f.addComponents(new Screw());
		f.addComponents(new Screw());
		f.addComponents(new Screw());
		f.addComponents(new Screw());
		
		try {
			
			System.out.println("===================開始製作產品===================");			
			
			
			f.product(new Robot());
		} catch (ComponentsNotEnough e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
