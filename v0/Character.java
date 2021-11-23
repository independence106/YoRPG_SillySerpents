public class Character {
  //attributes
  protected int health;
  protected int maxHealth;
  protected int damage;
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
    this.defense = 1;
    this.attackRating = 0.1;
    this.strength = 20;
    
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
  public int getDefense() {
    return this.defense; 
  }
  public String toString() {
    return "Name: " + getName() + "\nLevel: " + this.level + 
           "\nHealth: " + this.health + "\nAttack State: " + 
           this.attackState + "\nAttack Rating: " + this.attackRating;
  }
  public void specialize() {
    this.attackState = "specialize";
  }
  public void normalize() {
    this.attackState = "normalize";
  }
  public void lowerHP(int amount) {
    this.health -= amount;
  }
  public boolean isAlive() {
    return health > 0;
  }
  public void calcNewDamage(Character c) {
    this.damage = (int) ((this.strength * this.attackRating) - c.getDefense());
  }
  public void increaseLevel(int health, int strength) {
    this.maxHealth += health;
    this.strength += strength;
    this.level++;
  }
  public void resetHealth() {
    this.health = maxHealth;
  }
  public int attack(Character e) {
    calcNewDamage(this);
    if (attackState.equals("specialize")) {
      //System.out.println("Swinging Hammer...");
      int amplifier = (int) (Math.random() * 10);
      if (amplifier > 5) {
        damage += amplifier * 2;

      } else {
        System.out.println("Youg swung too hard, and bashed thy skull. Ye lost 5 health!");
        lowerHP(5);

      }
    }
    e.lowerHP(this.damage);
    return this.damage;
  }
}
