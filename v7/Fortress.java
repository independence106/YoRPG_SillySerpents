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
      this.attackTypes = new String[] {"Shield Throw", "Shield O' Life", "Shield Rain"};
    }
    public Fortress(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Fortress(int maxHealth, int strength, double attackRating, int defense, String name, int level, int speed, int coins) {
      this.health = maxHealth + 300;
      this.maxHealth = maxHealth + 300;
      this.strength = strength - 25;
      this.attackRating = attackRating - 0.2;
      this.speed = speed - 15;
      this.defense = defense + 30;
      this.level = level;
      this.coins = coins;
      this.name = name;
      this.attackTypes = new String[] {"Shield Throw", "Shield O' Life", "Shield Rain"};
    }
    public static String about() {
      return "An experiment gone wrong. Fortress is a solid, immovable being. High defense almost no damage however.";
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      if (attackState.equals("Shield Rain")) {
        //System.out.println("Swinging Hammer...");
        //ALWAYS ROUNDS TO NEAREST!!!
        this.test = "\nThee hath called upon thy fellow shields to strike. Thee attacks ";
        this.damage = 20;
        e.lowerHP(this.damage, this.getType());
      } else if (attackState.equals("Shield O' Life")) {
        if ((this.maxHealth - this.health ) > 20) {
          this.health += 20;
          this.test = "\nYoug hath used shield o' life! Heal thyself for 20HP! Thee attacks ";
        } else {
          this.test = "\nYoug hath used shield o' life! Heal thyself to max health for " + (this.maxHealth - this.health) + "HP! Thee attacks ";
          this.health = this.maxHealth;
        }
        this.damage = 0;
    } else {
        this.test = "\nThee throws shield and hits " + e.getType() + ". Thee attacks ";
        e.lowerHP(this.damage, this.getType());
      }
      return this.damage;
    }
  }
  