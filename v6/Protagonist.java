//coins, will add more features in next update

public class Protagonist extends Character{
  protected int coins = 100;
  //power, defense, attackrating, health, speed, and special hehe!
  int[] artifacts = new int[6];
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
  public void update() {
    this.maxHealth += artifacts[3];
    this.health = maxHealth;
    this.strength += artifacts[0];
    this.attackRating += (double) (artifacts[2]);
    this.defense += artifacts[1];
    this.speed += artifacts[4];
  }
  
  public void artifactChange(int index) {
    artifacts[index] = Shop.boost[index];
  }
  public void giveCoins(int coins) {
    this.coins += coins;
  }



}
