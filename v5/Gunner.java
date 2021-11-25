/**
 * Gunner: brrrrrr (This class is kinda doo doo, needs a revamp)
 *
 * - 10 defense
 * - 100 HP
 * - Speed -20
 * - 1 attack rating
 * - 40 strength
 * Special:
 * - RRRRRRRRRRRRRRRRRRM: 90% to shoot three bullets do normal damage 10% to jam for 3 turns
 */
public class Gunner extends Archer {
  
    private int turnCounter = 3;
  
    public Gunner() {
      super();
      this.strength = 40;
      this.health = 100;
      this.attackRating = 1.0;
      if (this.getSpeed() > 20) {
        this.speed -= 20;
      }
      this.defense = 10;
    }
    public Gunner(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Gunner(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
      super(health, damage, strength, attackRating, defense, name, level);
    }
    public static String about() {
      return "Once he hath his music-o-magic in, nothing can stop him. Guns down anything while jamming to medeival rock";
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      if (turnCounter == 3) {
        if (attackState.equals("specialize")) {
            this.speed += 1;
            e.lowerHP(this.damage, this.getType());
            System.out.println("\nTraining with master elmo has paid off. Thy is now faster!");
        } else if(attackState.equals("3")) {
          double RNGesus = Math.random();
          if (RNGesus < 0.99) {
            System.out.println("Yiko! Thy weapon hath jammed!");
            e.lowerHP(e.getHealth(), this.getType());
          } else {
            System.out.println("Jenking Jillies! Thy gun hath overclocked! Spray! Spray thy projectiles on thy enemies!");
            e.lowerHP(this.damage * 3, this.getType());
          }
        } else {
          e.lowerHP(this.damage, this.getType());
        }
        
        turnCounter = 0;
        return this.damage;
      } else {
        System.out.println("Still jammed! " + (3 - turnCounter) + " turns to go!");
        turnCounter++;
        return 0;
      }
    }
  }
  