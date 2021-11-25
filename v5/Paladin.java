/**
 * Paladin
 *
 * Special: Holy Strike: 30% chance to ignore armor!
 * - 20 defense
 * - 150 HP
 * - Speed +5
 * - 1.5 attack Rating
 * - 50 strength
 */
public class Paladin extends Swordsman {
  
    public Paladin() {
      super();
      this.strength = 50;
      this.health = 150;
      this.attackRating = 1.5;
      this.speed += 5;
      this.defense = 20;
    }
    public Paladin(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Paladin(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
      super(health, damage, strength, attackRating, defense, name, level);
    }
    public static String about() {
      return "Veteran warrior in the old holy campaigns against demons. Excellent warrior!";
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      
    if (attackState.equals("specialize")) {
        this.speed += 1;
        e.lowerHP(this.damage, this.getType());
        System.out.println("\nTraining with master elmo has paid off. Thy is now faster!");
        } else if(attackState.equals("3")) {
          double RNGesus = Math.random();
        if (RNGesus < 0.34) {
            System.out.println("Insert cool thing here");
            e.lowerHP(e.getHealth(), this.getType());
        } else {
            System.out.println("Yikes! Your bullet only grazed " + e.getType());
            e.lowerHP(this.damage / 3, this.getType());
        }
        
        
        turnCounter = 0;
        return this.damage;
      } else {
        System.out.println("Reloading shot...");
        turnCounter = 1;
        return 0;
      }
    }
  }
  