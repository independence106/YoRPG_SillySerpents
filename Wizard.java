//added subclass wizard
public class Wizard extends Protagonist{

  public Wizard() {
    super();
    this.defense = 0;
    this.health = 50;
    this.maxHealth = 50;
    this.strength = 50;
    this.speed -= 20;
    this.attackRating = 1.0;
    this.attackTypes = new String[] {"Fireball", "Vortex Summoning"};
  }
  public Wizard(String name) {
    this();
    this.name = name;

  }
  public Wizard(int health, int strength, double attackRating, int defense, String name, int level) {
    super(health, strength, attackRating, defense, name, level);
  }
  public static String about() {
    return "\nAbrahahsdfa. Very forgetful about his spellbook" +
           "\nMay occasionally turn something into a cat. Kinda cuckoo";
  }
  public int attack(Character e) {
    calcNewDamage(this, e);
    if (attackState.equals("Vortex Summoning")) {
        this.damage += 15;
        e.lowerHP(this.damage, this.getType());
        this.test = "\nThy has summoned new vortex from dimension! Thee attacks ";
    } else {
      this.test = "\nThee conjures fireball and attacks ";
      e.lowerHP(this.damage, this.getType());
    }
    
    
    return this.damage;
  }
}
