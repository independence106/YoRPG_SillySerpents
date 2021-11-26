/**
 * Tonk
 *
 * Special: Taunt: Next two attacks, monster can 50% chance of missing (cooldown 4 turns) <-- not implemented
 * - 30 defense
 * - 300 HP
 * - Speed -5
 * - 0.4 attack Rating
 * - 25 strength
 */
public class Tonk extends Tank {
    
    private boolean taunt = true;
    private int counter = 0;
    public Tonk() {
      super();
      this.strength = 25;
      this.health = 300;
      this.maxHealth = 300;
      this.attackRating = 0.4;
      this.speed -= 5;
      this.defense = 30;
    }
    public Tonk(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Tonk(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
      super(health, damage, strength, attackRating, defense, name, level);
    }
    public static String about() {
      return "Tank's Big brother, earned a new set of armor forged by the holy dwarves";
    }
    public boolean getTauntStatus() {
        return taunt;
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      if (attackState.equals("specialize")) {
        //System.out.println("Swinging Hammer...");
        //ALWAYS ROUNDS TO NEAREST!!!
        double RNGesus = Math.random();
        if (RNGesus > 0.5) {
            if (counter >= 4) {
                taunt = false;
                counter = 0;
            }
            if (counter == 0) {
                System.out.println("You hath taunted thy enemy");
                taunt = true;
            } else {
                System.out.println("Cannot use ability tant for " + (4 - counter) + " turns.");
            }
        } else {
            System.out.println("Taunt ability hath failed and you doth dealt no damage");
        }

      } else {
        System.out.println("They hath swung shiled");
        e.lowerHP(this.damage, this.getType());
      }
      counter++;
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
  