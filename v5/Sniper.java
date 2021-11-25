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
    this.attackRating = 1.0;
    this.speed += 20;
    this.defense = 10;
  }
  public Sniper(String name) {
    this();
    this.name = name;
  }
  //HEY fix this:
  public Sniper(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
    super(health, damage, strength, attackRating, defense, name, level);
  }
  public static String about() {
    return "One shot, one kill. Likes to be alone, taking out enemies one by one. Good attack power, but long recharge";
  }
  public int attack(Character e) {
    calcNewDamage(this, e);
    if (turnCounter == 1) {
      if (attackState.equals("specialize")) {
          this.speed += 1;
          e.lowerHP(this.damage, this.getType());
          System.out.println("\nTraining with master elmo has paid off. Thy is now faster!");
      } else if(attackState.equals("3")) {
        double RNGesus = Math.random();
        if (RNGesus < 0.34) {
          System.out.println("Insert cool thing here");
          e.lowerHP(e.getHealth(), this.getType());
        } else {
          System.out.println("Yikes! Your bullet only grazed " + e.getType());
          e.lowerHP(this.damage / 3, this.getType());
        }
      } else {
        e.lowerHP(this.damage, this.getType());
      }
      
      turnCounter = 0;
      return this.damage;
    } else {
      System.out.println("Reloading shot...");
      turnCounter = 1;
      return 0;
    }
  }
}
