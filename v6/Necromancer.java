/** WIP (Currently teseting 1 undead)
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
    
    protected int numOUndeads = 0;
    //very unchad code
    UndeadOProtag blake = new UndeadOProtag();
    UndeadOProtag johnny = new UndeadOProtag();

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
    public void lowerHP(int amount, String attackingClass) {
      if (numOUndeads > 0) {
        blake.lowerHP(amount, attackingClass);
        if (!blake.isAlive()) {
          numOUndeads--;
        }
      } else {
        System.out.println("doing this");
        this.health -= amount;
      }
      
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      if (attackState.equals("specialize")) {
        //System.out.println("Swinging Hammer...");
        //ALWAYS ROUNDS TO NEAREST!!!
        if (numOUndeads < 1) {
            System.out.println("doing this");
            numOUndeads++;
        } else {
          System.out.println("Yikes! Thee skill cannot summon more than 2 undeads!");
          e.lowerHP(this.damage, this.getType());
          
        }
      } else {
        System.out.println("They hath swung shiled");
        e.lowerHP(this.damage, this.getType());
      }
      return this.damage;
    }
    public static void main(String[] args) {
        Monster elmo = new Monster();
        Necromancer tonky = new Necromancer();

        tonky.specialize();
        System.out.println(tonky.attack(elmo));
        System.out.println(tonky.numOUndeads);
        System.out.println(elmo.attack(tonky));
        System.out.println(tonky.health);
        System.out.println(elmo.attack(tonky));
        System.out.println(elmo.attack(tonky));
        System.out.println(elmo.attack(tonky));
        System.out.println(elmo.attack(tonky));
        System.out.println(elmo.attack(tonky));
        System.out.println(tonky.blake.isAlive());
        System.out.println(tonky.health);
    }
  }
  