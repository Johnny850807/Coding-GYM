
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
				System.out.println(monster.getName() + " Ĺ�F ");
				break;
			}
			else{
				System.out.println("�� " + ++round +" �^�X :");
				heroChoiceAction = new HeroChoiceAction(hero);
				damage = heroChoiceAction.getDamage();
				monster.consumptionHeroHp(damage);
			}
			if(monster.hp <= 0 ){
				System.out.println(hero.getName() + " Ĺ�F ");
				break;
			}
			else{

				System.out.println("---------------�����]������-----------");
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
