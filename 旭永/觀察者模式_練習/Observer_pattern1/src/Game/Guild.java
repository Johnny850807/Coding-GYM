package Game;

import java.util.ArrayList;

public class Guild implements Observable{
	
	private ArrayList adventures_list;
	
	private String mission;
	
	
		public Guild(){
			adventures_list=new ArrayList();
		}

		@Override
		public void register_Adventurers(Observer o) {
			adventures_list.add(o);
		}

		@Override
		public void remove_Adventurers(Observer o) {
				int i=adventures_list.indexOf(o);
				adventures_list.remove(i);
		}

		@Override
		public void notify_Adventurers() {
			for(int i=0;i<adventures_list.size();i++){
				Observer adventures =(Observer)adventures_list.get(i);
				adventures.updata(mission);
				}
		
		}
	
		public void setmission(String New_mission){
			this.mission=New_mission;
			notify_Adventurers();
		
		}

}
