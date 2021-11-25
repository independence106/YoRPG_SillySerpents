/**
 * Barbarian
 *
 * Special: Bloodlurst: For every 5% of HP lost, deal 2% more damage
 * - 10 defense
 * - 125 HP
 * - Speed +10
 * - 1.4 attack Rating
 * - 70 strength
 */
public class Barbarian extends Swordsman {
  
    public Barbarian() {
      super();
      this.strength = 70;
      this.health = 125;
      this.attackRating = 1.4;
      this.speed += 10;
      this.defense = 10;
    }
    public Barbarian(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Barbarian(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
      super(health, damage, strength, attackRating, defense, name, level);
    }
    public static String about() {
      return "Veteran warrior in the old holy campaigns against demons. Excellent warrior!";
    }

    public void calcNewDamage(Character c, Character attackee) {
      this.damage = (int) ((this.strength * this.attackRating) - attackee.getDefense());
      
      if (this.damage <= 0) {
        this.damage = 5;
      }
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      if (attackState.equals("specialize")) {
        //System.out.println("Swinging Hammer...");
        
      } else {
        e.lowerHP(this.damage, this.getType());
      }
      return this.damage;
    }
    public static void main(String[] args) {
      Monster e = new Monster();
      Paladin elmo = new Paladin();
      elmo.specialize();
      System.out.println(elmo.attack(e));
      System.out.println(elmo.attack(e));
      System.out.println(elmo.attack(e));
    }
  }
  