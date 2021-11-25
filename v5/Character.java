//cleaned up some code

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
  protected int speed;
  protected String type = "";

  public Character() {
    this.health = 100;
    this.damage = 15;
    this.level = 0;
    this.maxHealth = 100;
    this.attackState = "normalize";
    this.defense = 1;
    this.attackRating = 0.5;
    this.strength = 30;
    this.speed = 50;
    this.type = this.getClass().getSimpleName();
    
  }
  public Character(String name) {
    this();
    this.name = name;
  }
  public Character(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
    this.health = health;
    this.damage = damage;
    this.strength = strength;
    this.attackRating = attackRating;
    this.defense = defense;
    this.name = name;
    this.level = level;
    this.maxHealth = health;
    this.attackState = "normalize";
    this.speed = 50;
    this.type = this.getClass().getSimpleName();
  }
  //Methods to get certain attributes
  public String getName() {
    return this.name;
  }
  public int getHealth() {
    return this.health;
  }
  public int getMaxHealth() {
    return this.maxHealth;
  }
  public int getDefense() {
    return this.defense; 
  }
  public int getLevel() {
    return this.level;
  }
  public int getSpeed() {
    return this.speed;
  }
  public double getAttackRating() {
    return this.attackRating;
  }
  public int getStrength() {
    return this.strength;
  }
  public String getType() {
    return this.type;
  }
  public String getAttackState() {
    return this.attackState;
  }
  
  public String toString() {
    return "Name: " + getName() + "\nLevel: " + this.level + 
           "\nHealth: " + this.health + "\nAttack State: " + 
           this.attackState + "\nAttack Rating: " + (Math.round(this.attackRating * 100.0) /100.0)
           + "\nStrength: " + this.strength + "\nSpeed: " + this.speed;
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
  public void lowerHP(int amount, String attackingClass) {
    
    this.health -= amount;
  }
  public boolean isAlive() {
    return health > 0;
  }
  public void calcNewDamage(Character c, Character attackee) {
    this.damage = (int) ((this.strength * this.attackRating) - attackee.getDefense());
    if (this.damage <= 0) {
      this.damage = 5;
    }
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
    calcNewDamage(this, e);
    if (attackState.equals("specialize")) {
      //System.out.println("Swinging Hammer...");
      int amplifier = (int) (Math.random() * 10);
      if (amplifier > 5) {
        damage += amplifier * 2;
        e.lowerHP(this.damage, this.getType());
        System.out.println("WOWEE! Thy gods have blessed thee I see! Extra DAMAGE!");
      } else {
        System.out.println("Youg swung too hard, and bashed thy skull. Ye lost 5 health!");
        lowerHP(5);
        e.lowerHP(this.damage, this.getType());
      }
    } else {
      e.lowerHP(this.damage, this.getType());
    }
    return this.damage;
  }
  
}
