//added subclass monster worg, worgs are fast, but have little health and do low damage
public class Worg extends Monster {
    public Worg() {
        super();
        this.speed = 100;
        this.health = 50;

    }
    public Worg(String name) {
        super(name);
        this.speed = 100;
        this.health = 50;
    }
    public Worg(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
        super(health, damage, strength, attackRating, defense, name, level);
        this.speed = 100;
        this.health = 50;
    }
    public int attack(Character e) {
        calcNewDamage(this);
        if (attackState.equals("specialize")) {
          //System.out.println("Swinging Hammer...");
          int amplifier = (int) (Math.random() * 10);
          if (amplifier > 5) {
            damage += amplifier * 2;
            e.lowerHP(this.damage);
          } else {
            System.out.println("Youg swung too hard, and bashed thy skull. Ye lost 5 health!");
            lowerHP(5);
            e.lowerHP(this.damage);
          }
        } else {
          e.lowerHP(this.damage);
         
        }
        return this.damage;
      }
}
