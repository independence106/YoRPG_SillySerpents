//basically a worg, w/ an ability to "dodge an attack"
//added about method
public class Archer extends Protagonist{


  public Archer() {
    super();
  }
  public Archer(String name) {
    super(name);
  }
  public Archer(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
    super(health, damage, strength, attackRating, defense, name, level);
  }
  public void lowerHP(int amount, String type) {
    if((Math.random() * speed) < 50) {
      this.health -= amount;
    } else {
      System.out.println("\nThy speed has prevented thee from taking damage! Lucky!");
    }
  }
  public static String about() {
    return "Pew Pew. Very nice class. Lotsa speed and dodging, good damage. Shoots things.";
  }
  
  public int attack(Character e) {
    calcNewDamage(this, e);
    if (attackState.equals("specialize")) {
        //yes stackable speed is intended
        this.speed += 1;
        e.lowerHP(this.damage, this.getType());
        System.out.println("\nTraining with master elmo has paid off. Thy is now faster!");
    } else {
      e.lowerHP(this.damage, this.getType());
    }
    
    
    return this.damage;
  }
}
