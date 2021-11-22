public class Character {
  //attributes
  protected int health;
  protected int maxHealth;
  protected double damage;
  protected int strength;
  protected double attackRating;
  protected int defense;
  protected String attackState = "";
  protected String name = "";
  protected int level;

  public Character() {
    this.health = 100;
    this.damage = 15;
    this.level = 0;
    this.maxHealth = 100;
    this.attackState = "normalize";
  }
  public Character(String name) {
    this();
    this.name = name;
  }
  
  public String getName() {
    return this.name;
  }
  public int getHealth() {
    return this.health;
  }
  public void getDefense() [
    return this.defense; 
  }
  public String toString() {
    return "Name: " + getName() + "\nLevel: " + this.level + "\nHealth: " + this.health + "\nAttack State" + this.attackState;
  }
  public void specialize() {
    this.attackState = "specialize";
  }
  public void normalize() {
    this.attackState = "normalize";
  }
  public void lowerHP(int amount) {
    this.health -= amount;
    
  public boolean isAlive() {
    return health >= 0;
  }
  public void takeDamage(int damage) {
    this.health -= damage;
  }
  public void calcNewDamage(Character char) {
    this.damage = (this.strenth * this.attackRating) - char.getDefense();
  }
  public void increaseLevel(int health, int damage) {
    this.maxHealth += health;
    this.damage += damage;
    this.level++;
  }
  public void resetHealth() {
    this.health = maxHealth;
  }
  public int attack() {
    return 0;
  }
}
