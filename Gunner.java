/**
 * Gunner: brrrrrr (This class is kinda doo doo, needs a revamp)
 *
 * - 10 defense
 * - 100 HP
 * - Speed -20
 * - 1 attack rating
 * - 60 strength
 * Special:
 * - Burst: 90% to shoot three bullets do normal damage 10% to jam for 3 turns
 */
public class Gunner extends Archer {
  
    private int turnCounter = 3;
  
    public Gunner() {
      super();
      this.strength = 60;
      this.health = 100;
      this.attackRating = 1.0;
      if (this.getSpeed() > 20) {
        this.speed -= 20;
      }
      this.attackTypes = new String[] {"Shoot", "Chug Jug", "Burst"};
      this.defense = 10;
    }
    public Gunner(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Gunner(int maxHealth, int strength, double attackRating, int defense, String name, int level, int speed, int coins) {
      this.health = maxHealth + 25;
      this.maxHealth = maxHealth + 25;
      this.strength = strength + 60;
      this.attackRating = attackRating;
      this.speed = speed - 20;
      this.defense = defense + 5;
      this.coins = coins;
      this.level = level;
      this.name = name;
      this.attackTypes = new String[] {"Shoot", "Chug Jug", "Burst"};
    }
    public static String about() {
      return "Once he hath his music-o-magic in, nothing can stop him. Guns down anything while jamming to medeival rock";
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      if (turnCounter == 3) {
        if (attackState.equals("Chug Jug")) {
            this.speed += 1;
            e.lowerHP(this.damage, this.getType());
            this.test = "\nTraining with master elmo has paid off. Thy is now faster! " + this.getName() + " shoots ";
        } else if(attackState.equals("Burst")) {
          double RNGesus = Math.random();
          if (RNGesus < 0.1) {
            this.test = "\nYiko! Thy weapon hath jammed! Thee attacks ";
            this.damage = 0;
            turnCounter = 0;
          } else {
            this.test = "\nJenking Jillies! Thy gun hath overclocked! Spray! Spray thy projectiles on thy enemies! Thee attacks ";
            this.damage *= 3;
            e.lowerHP(this.damage, this.getType());
          }
        } else {
          this.test = "\nThee fills " + e.getType() + " with lead. You attack ";
          e.lowerHP(this.damage, this.getType());
        }
        
        
        return this.damage;
      } else {
        this.test = "Still jammed! " + (3 - turnCounter) + " turns to go! Thus you attack ";
        turnCounter++;
        return 0;
      }
    }
  }
  