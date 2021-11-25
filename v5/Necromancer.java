/** WIP
 * Necromancer
 *
 * Special: Undead: Summon an undead (up to two). Undeads have health and attack scaled to wizard lvl
 * - 10 defense
 * - 70 HP
 * - Speed + 0
 * - 1.4 attack Rating
 * - 50 strength
 * 
 * Undead: 
 * - base 50 hp
 * - 20 strength
 * - 0.5 attack rating
 * - 0 def
 * - 0 speed
 */
public class Necromancer extends Wizard {
    
    private int numOUndeads = 0;

    public Necromancer() {
      super();
      this.strength = 50;
      this.health = 70;
      this.maxHealth = 70;
      this.attackRating = 1.4;
      this.defense += 5;
    }
    public Necromancer(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Necromancer(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
      super(health, damage, strength, attackRating, defense, name, level);
    }
    public static String about() {
      return "Dabbled in the forbidden arts. Forever shunned by his wizard brethen. Powerful dark magic";
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      if (attackState.equals("specialize")) {
        //System.out.println("Swinging Hammer...");
        //ALWAYS ROUNDS TO NEAREST!!!
        if (numOUndeads < 2) {
            numOUndeads++;
        }
      } else {
        System.out.println("They hath swung shiled");
        e.lowerHP(this.damage, this.getType());
      }
      return this.damage;
    }
    public static void main(String[] args) {
        Monster elmo = new Monster();
        Tonk tonky = new Tonk();
        tonky.specialize();
        System.out.println(tonky.attack(elmo));
        System.out.println(tonky.attack(elmo));
        System.out.println(tonky.attack(elmo));
        System.out.println(tonky.attack(elmo));
        System.out.println(tonky.attack(elmo));
        System.out.println(tonky.attack(elmo));
        System.out.println(tonky.attack(elmo));
        System.out.println(tonky.attack(elmo));
        System.out.println(tonky.attack(elmo));
        System.out.println(tonky.attack(elmo));
    }
  }
  