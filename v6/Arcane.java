/** WIP
 * Arcane
 *
 * Special: WIP
 * - 6 defense
 * - 60 HP
 * - Speed - 5
 * - 1.7 attack Rating
 * - 110 strength
 */
public class Arcane extends Wizard {

    public Arcane() {
      super();
      this.strength = 110;
      this.health = 60;
      this.maxHealth = 60;
      this.attackRating = 1.7;
      this.speed -= 5;
      this.defense += 1;
      this.attackTypes = new String[] {"Bash", "specialize"};
    }
    public Arcane(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Arcane(int maxHealth, int strength, double attackRating, int defense, String name, int level, int speed, int coins) {
      this.health = maxHealth + 10;
      this.maxHealth = maxHealth + 10;
      this.strength = strength + 60;
      this.attackRating = attackRating + 0.7;
      this.speed = speed - 5;
      this.defense = defense + 1;
      this.coins = coins + 10;
      this.level = level;
      this.name = name;
      this.attackTypes = new String[] {"Bash", "specialize"};

    }
    public static String about() {
      return "Went to wizandia to study under the great wizards Tiggy and Tiffany. Came back with a new arsenal of spells";
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      if (attackState.equals("specialize")) {
        //System.out.println("Swinging Hammer...");
        //ALWAYS ROUNDS TO NEAREST!!!
      } else {
        this.test = "WIP";
        System.out.println("They hath swung shiled");
        e.lowerHP(this.damage, this.getType());
      }
      return this.damage;
    }
  }
  