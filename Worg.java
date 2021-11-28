//added subclass monster worg, worgs are fast, but have little health and do low damage
public class Worg extends Monster {
    public Worg() {
        super();
        this.speed = 200;
        this.health = 50;
        this.strength = 15;

    }
    public Worg(String name) {
        super(name);
        this.speed = 200;
        this.health = 50;
        this.strength = 15;
    }
    public Worg(int health, int strength, double attackRating, int defense, String name, int level) {
        super(health, strength, attackRating, defense, name, level);
        this.speed = 200;
        this.health = 50;
        this.strength = 15;
    }
    public String getType() {
      return "Worg";
    }
    public void lowerHP(int amount, String attackingClass) {
      if((Math.random() * speed) < 50) {
        this.attackMiss = "";
        this.health -= amount;
        
      } else {
        this.attackMiss = "\nWorg too fast, thy attack has been missed!";
      }
    }
    public static String about() {
      return "Speed. I am speed. These monsters are fast. Too fast in fact. They mainly" +
             "\nwill just harass you. No harm done, right?";
    }
    public int attack(Character e) {
        calcNewDamage(this, e);
        if (attackState.equals("specialize")) {
          //System.out.println("Swinging Hammer...");
          int amplifier = (int) (Math.random() * 10);
          if (amplifier > 5) {
            damage += amplifier * 2;
            e.lowerHP(this.damage, this.getType());
          } 
        } else {
          this.test = "\nWorg uses tis speed to attack thee. He attacks you";
          e.lowerHP(this.damage, this.getType());
         
        }
        return this.damage;
      }
    
}
