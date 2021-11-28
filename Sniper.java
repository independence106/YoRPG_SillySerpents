/**
 * Sniper: One attack per 2 rounds
 *
 * Special: Head-shot - 30% chance to instakill mobs but not boss. 1% chance to 1 shot boss.
 * Sniper: (attack once every 2 turns)
 * - 10 Defense
 * - 75 HP
 * - 100 Strength
 * - Speed +20
 * - 1 attack Rating
 * Special:
 * -Head shot: 30% to instakill, 1% for bosses <-- 1% bosses not implemented yet
 */
public class Sniper extends Archer {
  
  private int turnCounter = 0;

  public Sniper() {
    super();
    this.strength = 100;
    this.health = 75;
    this.maxHealth = 75;
    this.attackRating = 1.0;
    this.speed += 20;
    this.defense = 10;
    this.attackTypes = new String[] {"Snipe", "Speed Boost", "One Shot - One Kill"};
    
  }
  public Sniper(String name) {
    this();
    this.name = name;
  }
  //HEY fix this:
  public Sniper(int maxHealth, int strength, double attackRating, int defense, String name, int level, int speed, int coins) {
    this.health = maxHealth;
    this.maxHealth = maxHealth;
    this.strength = strength + 60;
    this.attackRating = attackRating;
    this.speed = speed + 20;
    this.defense = defense + 5;
    this.coins = coins;
    this.level = level;
    this.name = name;
    this.attackTypes = new String[] {"Snipe", "Speed Boost", "One Shot - One Kill"};
  }
  public static String about() {
    return "One shot, one kill. Likes to be alone, taking out enemies one by one. Good attack power, but long recharge";
  }
  public int attack(Character e) {
    calcNewDamage(this, e);
    if (turnCounter == 0) {
      if (attackState.equals("specialize")) {
          this.speed += 1;
          this.damage /= 2;
          this.test = "\nTraining with master elmo has paid off. Thy is now faster! However you are tired and shoot ";
          e.lowerHP(this.damage, this.getType());

      } else if(attackState.equals("One Shot - One Kill")) {
        double RNGesus = Math.random();
        if (RNGesus < 0.34) {
          this.test = "You hear the crack of thy musket as thy bullet wizzes through the art and pierces " + e.getType() + ". Thy shot hits ";
          e.lowerHP(e.getHealth(), this.getType());
        } else {
          this.test = "\nYikes! Your bullet only grazed ";
          this.damage /= 3;
          e.lowerHP(this.damage, this.getType());
        }
      } else {
        this.test = "Thee shoots ";
        e.lowerHP(this.damage, this.getType());
      }
      
      turnCounter = 1;
      return this.damage;
    } else {
      this.test = "\nReloading Shot . . . Thee cannot attack! You attack ";
      this.damage = 0;

      turnCounter = 0;
      return 0;
    }
  }
}
