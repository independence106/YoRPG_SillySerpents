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
      this.attackTypes = new String[] {"Swing", "RNGesus Super Sword Swing", "Holy Strike"};
    }
    public Paladin(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Paladin(int maxHealth, int strength, double attackRating, int defense, String name, int level, int speed, int coins) {
      this.health = maxHealth + 50;
      this.maxHealth = maxHealth + 50;
      this.strength = strength + 20;
      this.attackRating = attackRating + 1;
      this.speed = speed + 5;
      this.defense = defense + 15;
      this.coins = coins;
      this.level = level;
      this.name = name;
      this.attackTypes = new String[] {"Swing", "RNGesus Super Sword Swing", "Holy Strike"};
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
      if (attackState.equals("Holy Strike")) {
        //System.out.println("Swinging Hammer...");
        double RNGesus = Math.random();
        if (RNGesus < 0.31) {
          this.test = "\nHOLLLLYYY STRIKE! POW! You attack ";
          calcNewDamage(this, e, true);
          e.lowerHP(this.damage, this.getType());
        } else {
          this.test = "\nThy hath forgotten spell has thee not? Perform 2/3 of damage you will. You attack ";
          this.damage = (int) (this.damage * 0.66);
          e.lowerHP((int)(this.damage * 0.66), this.getType());
        }
      } else if (attackState.equals("RNGesus Super Sword Swing")) {
        int amplifier = (int) (Math.random() * 10);
        if (amplifier > 5) {
          this.damage += amplifier * 2;
          e.lowerHP(this.damage, this.getType());
          this.test = "\nWOWEE! Thy gods have blessed thee I see! Extra DAMAGE! You attack ";
        } else {
          this.test = "\nYoug swung too hard, and bashed thy skull. Ye lost 5 health! You attack ";
          lowerHP(5);
          this.damage = 0;
        }
      } else {
        this.test = "\nYou swing thy sword and attack ";
        e.lowerHP(this.damage, this.getType());
      }
      return this.damage;
    }
  }
  