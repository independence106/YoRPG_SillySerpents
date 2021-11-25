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

    public void calcNewDamage(Character c, Character attackee, boolean holy) {
      if (holy) {
        this.damage = (int) (this.strength * this.attackRating);
      } else {
        this.damage = (int) ((this.strength * this.attackRating) - attackee.getDefense());
      }
      if (this.damage <= 0) {
        this.damage = 5;
      }
    }
    public int attack(Character e) {
      calcNewDamage(this, e, false);
      if (attackState.equals("specialize")) {
        //System.out.println("Swinging Hammer...");
        double RNGesus = Math.random();
        if (RNGesus < 0.31) {
          System.out.println("HOLLLLYYY STRIKE!");
          calcNewDamage(this, e, true);
          e.lowerHP(this.damage, this.getType());
        } else {
          System.out.println("Thy hath forgotten spell has thee not? Perform 2/3 of damage you will");
          this.damage = (int) (this.damage * 0.66);
          e.lowerHP((int)(this.damage * 0.66), this.getType());
        }
      } else {
        e.lowerHP(this.damage, this.getType());
      }
      return this.damage;
    }
  }
  