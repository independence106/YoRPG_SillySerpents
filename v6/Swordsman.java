//just a swordsman, bad class in my opinion!
public class Swordsman extends Protagonist{

  public Swordsman() {
    super();
    this.attackTypes = new String[] {"Swing", "RNGesus Super Sword Swing"};
  }
  public Swordsman(String name) {
    this();
    this.name = name;
    this.attackTypes = new String[] {"Swing", "RNGesus Super Sword Swing"};
  }
  public Swordsman(int health, int strength, double attackRating, int defense, String name, int level) {
    super(health, strength, attackRating, defense, name, level);
  }
  public static String about() {
    return "\nMe bash head. Quite literally, this class is a well built class" + 
           "\nIt is very well rounded, and essential to every dungeon party!";
  }
  public int attack(Character e) {
    calcNewDamage(this, e);
    if (attackState.equals("RNGesus Super Sword Swing")) {
      //System.out.println("Swinging Hammer...");
      int amplifier = (int) (Math.random() * 10);
      
      if (amplifier > 3) {
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
