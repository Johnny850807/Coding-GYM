package Generic_test;

public class Factory<C extends Components ,P extends Produce>  {
	
//	private static int Components_count_for_Robot=0;
	private static int Components_count_Screw=0;
	private static int Components_count_Box=0;
	private static int Components_count_Module=0;
	

	

	
	
	
		public void addComponents(C c){
			if(c instanceof Screw){
				Components_count_Screw++;
				System.out.println("Screw零件+1");
				System.out.println("Screw零件數量:"+Components_count_Screw);
			}
			else if(c instanceof Box){
				Components_count_Box++;
				System.out.println("Box零件+1");
				System.out.println("Box零件數量:"+	Components_count_Box);
			}else if(c instanceof Module){
				Components_count_Module++;
				System.out.println("Module零件+1");
				System.out.println("Module零件數量:"+Components_count_Module);
			}
			
			
		}
		
		
		
		public void product(P p) throws ComponentsNotEnough{
			
			if(p instanceof Car){
				
				if(Components_count_Screw-3<0){
					throw new ComponentsNotEnough();
					
				}else{
					Components_count_Screw-=3;
					System.out.println("獲得Car");
				}
				
			}else if(p instanceof Robot){
				
				if(Components_count_Screw-7<0){
					throw new ComponentsNotEnough();
				}else{
					Components_count_Screw-=7;
					System.out.println("獲得Robot");
				}
				
			}
			

			
		}
	
			
			
			

}
