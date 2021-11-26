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
    }
    public Arcane(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Arcane(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
      super(health, damage, strength, attackRating, defense, name, level);
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
  