package Generic_test;

public class Main_Factory_work {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("===================�s��u�t�}�l�B�@===================");
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
			
			System.out.println("===================�}�l�s�@���~===================");			
			
			
			f.product(new Robot());
		} catch (ComponentsNotEnough e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
