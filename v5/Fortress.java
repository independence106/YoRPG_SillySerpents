/**
 * Fortress
 *
 * Special: Shield Rain: Does 20 true damage
 * - 50 defense
 * - 500 HP
 * - Speed -15
 * - 0.3 attack Rating
 * - 5 strength
 */
public class Fortress extends Tank {
    
    public Fortress() {
      super();
      this.strength = 5;
      this.health = 500;
      this.maxHealth = 500;
      this.attackRating = 0.3;
      this.speed -= 15;
      this.defense = 50;
    }
    public Fortress(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Fortress(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
      super(health, damage, strength, attackRating, defense, name, level);
    }
    public static String about() {
      return "An experiment gone wrong. Fortress is a solid, immovable being. High defense almost no damage however.";
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      if (attackState.equals("specialize")) {
        //System.out.println("Swinging Hammer...");
        //ALWAYS ROUNDS TO NEAREST!!!
        System.out.println("Thee hath called upon thy fellow shields to strike");
        this.damage = 20;
      } else {
        System.out.println("They hath swung shiled");
        e.lowerHP(this.damage, this.getType());
      }
      return this.damage;
    }
  }
  