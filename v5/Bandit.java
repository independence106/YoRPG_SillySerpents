//will steal your coins if you aren't lucky!
public class Bandit extends Monster {
    public Bandit() {
        super();
        this.health = 75;
    }
    public Bandit(String name) {
        super(name);
        this.health = 75;
    }
    public Bandit(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
        super(health, damage, strength, attackRating, defense, name, level);
        this.health = 75;
    }
    public String getType() {
      return "Bandit";
    }
    public static String about() {
      return "I steal things. Bandits are notorius for their ability to steal." +
             "\nYou never want to meet these creatures in a game for you'll find you wallet to be empty...";
    }
    public int attack(Protagonist e) {
        calcNewDamage(this, e);
        if (attackState.equals("specialize")) {
          //System.out.println("Swinging Hammer...");
          int amplifier = (int) (Math.random() * 10);
          if (amplifier > 5) {
            damage += amplifier * 2;
            e.lowerHP(this.damage, this.getType());;
          } else {
            System.out.println("Youg swung too hard, and bashed thy skull. Ye lost 5 health!");
            lowerHP(5);
            e.lowerHP(this.damage, this.getType());
          }
        } else if (Math.random() < 0.01 && e.getCoins() > 1) {
          e.giveCoins(-1);
          System.out.println("Thy sneaky sir has stolen 1 of thee's coins!");
        } else {
          e.lowerHP(this.damage, this.getType());
          System.out.println(this.name + " performs head bash!");
        }
        return this.damage;
      }
}
