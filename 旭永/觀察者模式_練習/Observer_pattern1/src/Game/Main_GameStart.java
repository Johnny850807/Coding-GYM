package Game;

public class Main_GameStart {

	public static void main(String[] args) {
		
		//公會
		Guild guild=new Guild();
		
		
		//冒險者們
		warrior Andy=new warrior("Andy");
		Archer Roget=new Archer("Roget");
		
		//向公會註冊 要接收新任務
		guild.register_Adventurers(Andy);
		guild.register_Adventurers(Roget);
		
		
		//新任務派送
		guild.setmission("新任務 打擊猖狂的野怪!!");
		guild.setmission("新任務 碎魂o牙的逆襲!!");

	}

}
