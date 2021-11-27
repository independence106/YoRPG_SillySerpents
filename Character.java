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
  protected int coins;

  protected String test = "";
  protected String attackMiss = "";

  final static String[] classTypes = {"Archer", "Sniper", "Gunner", "Tank", "Tonk", "Fortress", "Wizard", "Arcane", "Necromancer", "Swordsman", "Paladin", "Barbarian"};

  protected String[] attackTypes = {"Bash", "RNGesus Bash"};

  public Character() {
    this.health = 100;
    this.damage = 15;
    this.level = 0;
    this.maxHealth = 100;
    this.attackState = "0";
    this.defense = 5;
    this.attackRating = 0.5;
    this.strength = 30;
    this.speed = 50;
    this.type = this.getClass().getSimpleName();
    this.coins = 0;
    
  }
  public Character(String name) {
    this();
    this.name = name;
  }
  public Character(int health, int strength, double attackRating, int defense, String name, int level) {
    this.health = health;
    this.strength = strength;
    this.attackRating = attackRating;
    this.defense = defense;
    this.name = name;
    this.level = level;
    this.maxHealth = health;
    this.attackState = "0";
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
  public int getCoins() {
    return this.coins;
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
  public void getAttackType() {
    System.out.println("\n");
    for (int i = 0; i < this.attackTypes.length; i++) {
      System.out.println((i + 1) + ". " + attackTypes[i]);
    }
  }
  
  public String toString() {
    return "Name: " + getName() + "\nLevel: " + this.level + 
           "\nHealth: " + this.health + "/ " + this.getMaxHealth() + "\nAttack State: " + 
           this.attackState + "\nAttack Rating: " + (Math.round(this.attackRating * 100.0) /100.0)
           + "\nStrength: " + this.strength + "\nSpeed: " + this.speed;
  }
  public void setAttackType(String type) {
    this.attackState = type;
  }
  public void lowerHP(int amount) {
    if((Math.random() * speed) < 50) {
      this.health -= amount;
      this.attackMiss = "";
    } else {
      this.attackMiss = "\nThy speed has prevented thee from taking damage! Lucky!";
    }
  }
  public void lowerHP(int amount, String attackingClass) {
    if((Math.random() * speed) < 50) {
      this.health -= amount;
      this.attackMiss = "";
    } else {
      this.attackMiss = "\n" + this.type + " speed has prevented thee from taking damage! Lucky!";
    }
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
  public void giveCoins(int coins) {
    this.coins += coins;
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
    if (attackState.equals("RNGesus Bash")) {
      //System.out.println("Swinging Hammer...");
      int amplifier = (int) (Math.random() * 10);
      if (amplifier > 5) {
        this.damage += amplifier * 2;
        e.lowerHP(this.damage, this.getType());
        this.test = "WOWEE! Thy gods have blessed thee I see! Extra DAMAGE! You attack ";
      } else {
        this.test = "Youg swung too hard, and bashed thy skull. Ye lost 5 health! You attack ";
        lowerHP(5);
        e.lowerHP(this.damage, this.getType());
      }
    } else {
      this.test = "You swing with thy club and attack ";
      e.lowerHP(this.damage, this.getType());
    }
    return this.damage;
  }
  
}
