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
      this.attackTypes = new String[] {"Swing", "RNGesus Super Sword Swing", "Bloodlurst"};
    }
    public Barbarian(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Barbarian(int maxHealth, int strength, double attackRating, int defense, String name, int level, int speed, int coins) {
      this.health = maxHealth + 25;
      this.maxHealth = maxHealth + 25;
      this.strength = strength + 40;
      this.attackRating = attackRating + 0.9;
      this.speed = speed + 10;
      this.defense = defense + 5;
      this.coins = coins;
      this.level = level;
      this.name = name;
      this.attackTypes = new String[] {"Swing", "RNGesus Super Sword Swing", "Bloodlurst"};
    }
    public static String about() {
      return "\nCast out from the Holy armies. Learned from the dark forces to gain power. Very poweful attacks, not so much defense";
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      if (attackState.equals("Bloodlurst")) {
        //System.out.println("Swinging Hammer...");
        //ALWAYS ROUNDS TO NEAREST!!!
        double percentageOHealthDivided5 = (1 - ((this.health * 1.0) / (this.maxHealth * 1.0))) / 0.05;
        calcNewDamage(this, e);
        this.damage = (int) (Math.round(this.damage * (1 + 0.02 * (percentageOHealthDivided5))));
        this.test = "\nGARAGH. You deal " + (Math.round(0.02 * percentageOHealthDivided5 * 100) / 100.0) * 100.0 + " percent more damage! You attack ";
        e.lowerHP(this.damage, this.getType());

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
        this.test = "You swing thy axe and attack ";
        e.lowerHP(this.damage, this.getType());
      }
      return this.damage;
    }
  }
  