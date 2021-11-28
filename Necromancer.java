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
      this.attackTypes = new String[] {"Fireball", "Vortex Summoning", "Undead Arise"};
    }
    public Necromancer(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Necromancer(int maxHealth, int strength, double attackRating, int defense, String name, int level, int speed, int coins) {
      this.health = maxHealth + 20;
      this.maxHealth = maxHealth + 20;
      this.strength = strength;
      this.attackRating = attackRating + 0.4;
      this.speed = speed;
      this.defense = defense + 5;
      this.coins = coins;
      this.level = level;
      this.name = name;
      this.attackTypes = new String[] {"Fireball", "Vortex Summoning", "Undead Arise"};
    }
    public static String about() {
      return "Dabbled in the forbidden arts. Forever shunned by his wizard brethen. Powerful dark magic";
    }
    public void lowerHP(int amount, String attackingClass) {
      if (numOUndeads > 0) {
        attackMiss = "\n" + attackingClass + " attacks you, but luckily thee undead saves thy and takes thy damage!";
        blake.lowerHP(amount, attackingClass);
        if (!blake.isAlive()) {
          attackMiss += "Alast, thy undead was not strong enough and died!";
          numOUndeads--;
        }
      } else {
        this.health -= amount;
        attackMiss = "";
      }
      
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      if (attackState.equals("Undead Arise")) {
        //System.out.println("Swinging Hammer...");
        //ALWAYS ROUNDS TO NEAREST!!!
        if (numOUndeads < 1) {
          this.test = "\nThee summons an undead! Thee attacks ";
          this.damage = 0;
          numOUndeads++;
          blake.health += 50;
        } else {
          this.test = "\nYikes! Thee skill cannot summon more than 1 undeads! Thee instead attacks ";
          e.lowerHP(this.damage, this.getType());
        }
      } else if (attackState.equals("Vortex Summoning")) {
        this.damage += 15;
        e.lowerHP(this.damage, this.getType());
        this.test = "\nThy has summoned new vortex from dimension! Thee attacks ";
      } else {
        this.test = "\nThy hath conjured fireball and attacked ";
        e.lowerHP(this.damage, this.getType());
      }
      return this.damage;
    }
    public static void main(String[] args) {
      
    }
  }
  