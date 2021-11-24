//coins, will add more features in next update

public class Protagonist extends Character{
  protected int coins = 0;
  public Protagonist() {
    super();
  }
  public Protagonist(String name) {
    super(name);
  }
  public Protagonist(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
    super(health, damage, strength, attackRating, defense, name, level);
  }
  public int getCoins() {
    return this.coins;
  }
  public void giveCoins(int coins) {
    this.coins += coins;
  }



}
