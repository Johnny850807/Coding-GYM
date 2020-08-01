public class Main {
    public static void main(String[] args) {
        Pokemon pokemon = new Fire(new Water(new NormalPokemon()));

        Pokemon enemy = new Grass(new NormalPokemon());
        System.out.println(pokemon.getName() + "受到" + enemy.getName() + "攻擊..初始威力" + enemy.getDamage());
        System.out.println("傷害最終判定為..." + pokemon.damageCount(enemy, enemy.getDamage()));

    }
}
