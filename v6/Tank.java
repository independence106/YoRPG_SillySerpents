//added subclass tank. TONK
public class Tank extends Protagonist{
  public Tank() {
    super();
    this.health = 200;
    this.level = 0;
    this.maxHealth = 200;
    this.attackState = "normalize";
    this.defense = 20;
    this.attackRating = 0.5;
    this.strength = 30;
    this.attackTypes = new String[] {"Shield Slap", "Shield O' Life"};
  }
  public Tank(String name) {
    this();
    this.name = name;
    this.strength = 30;
  }
  public Tank(int health, int strength, double attackRating, int defense, String name, int level) {
    super(health, strength, attackRating, defense, name, level);
  }
  public static String about() {
    return "\nTONK. ME TONK. Will take a beating from any monster. Passed tank school" +
           "\nwith full honors. Can heal himself too! Very useful.";
  }
  public int attack(Character e) {
    calcNewDamage(this, e);
    if (attackState.equals("Shield O' Life")) {
        if ((this.maxHealth - this.health ) > 20) {
          this.health += 20;
          this.test = "\nYoug hath used shield o' life! Heal thyself for 20HP! Thee attacks ";
        } else {
          this.health = this.maxHealth;
          this.test = "\nYoug hath used shield o' life! Heal thyself to max health for " + (this.maxHealth - this.health) + "HP! Thee attacks ";
        }
        this.damage = 0;
    } else {
        this.test = "\nThee slaps " + e.getType() + ". Thee attacks ";
        e.lowerHP(this.damage, this.getType()); 
    }
    return this.damage;
    
    
  }

}
