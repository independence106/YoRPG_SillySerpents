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
      this.maxHealth = 125;
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
      return "Cast out from the Holy armies. Learned from the dark forces to gain power. Very poweful attacks, not so much defense";
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      if (attackState.equals("specialize")) {
        //System.out.println("Swinging Hammer...");
        //ALWAYS ROUNDS TO NEAREST!!!
        double percentageOHealthDivided5 = (1 - ((this.health * 1.0) / (this.maxHealth * 1.0))) / 0.05;
        calcNewDamage(this, e);
        this.damage = (int) (Math.round(this.damage * (1 + 0.02 * (percentageOHealthDivided5))));
        e.lowerHP(this.damage, this.getType());

      } else {
        e.lowerHP(this.damage, this.getType());
      }
      return this.damage;
    }
  }
  