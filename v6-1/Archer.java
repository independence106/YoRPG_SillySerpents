//basically a worg, w/ an ability to "dodge an attack"
//added about method
public class Archer extends Protagonist{


  public Archer() {
    this.health = 75;
    this.maxHealth = 75;
    this.strength = 40;
    this.attackRating = 1.0;
    this.speed = 50;
    this.defense = 5;
    this.attackTypes = new String[] {"Snipe", "Speed Boost"};
    this.attackState = "0";

  }
  public Archer(String name) {
    this();
    this.name = name;
  }
  public Archer(int maxHealth, int strength, double attackRating, int defense, String name, int level) {
    super(maxHealth, strength, attackRating, defense, name, level);
  }
  
  public static String about() {
    return "\nPew Pew. Very nice class. Lotsa speed and dodging, good damage. Shoots things.";
  }
  
  public int attack(Character e) {
    calcNewDamage(this, e);
    if (attackState.equals("Speed Boost")) {
        //yes stackable speed is intended
        //only will do 1/2 damage
        this.speed += 1;
        this.damage /= 2;
        e.lowerHP(this.damage, this.getType());
        this.test = "\nTraining with master elmo has paid off. Thy is now faster! Speed +1! " + this.getName() + " shoots ";
    } else {
      this.test = "Steady...Aim...FIRE! " + this.getName() + " shoots ";
      e.lowerHP(this.damage, this.getType());
    }
    
    
    return this.damage;
  }
}
