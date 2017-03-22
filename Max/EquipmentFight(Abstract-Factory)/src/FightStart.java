
public class FightStart {
	private Hero hero;
	private Monster monster;
	private HeroChoiceAction heroChoiceAction;
	private MonsterAction monsterAction;
	private int round = 0;
	private int damage = 0;
	private boolean gameOver = false;
	public FightStart(Hero hero , Monster monster){
		this.hero = hero;
		this.monster = monster;
		fightStart();
	}
	public void fightStart(){
		while(true){
			if(hero.hp <= 0 ){
				System.out.println(monster.getName() + " 贏了 ");
				break;
			}
			else{
				System.out.println("第 " + ++round +" 回合 :");
				heroChoiceAction = new HeroChoiceAction(hero);
				damage = heroChoiceAction.getDamage();
				monster.consumptionHeroHp(damage);
			}
			if(monster.hp <= 0 ){
				System.out.println(hero.getName() + " 贏了 ");
				break;
			}
			else{

				System.out.println("---------------等待魔王攻擊-----------");
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				monsterAction = new MonsterAction(monster);
				damage = monsterAction.getDamage();
				hero.consumptionHeroHp(damage);
			}
		
		}
	}
	
}
