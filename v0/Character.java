//Basic Skeletons w/o methods

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
  
}
