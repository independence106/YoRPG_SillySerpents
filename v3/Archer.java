//basically a worg, w/ an ability to "dodge an attack"
public class Archer extends Protagonist{


  public Archer() {
    super();
  }
  public Archer(String name) {
    super(name);
  }
  public void lowerHP(int amount) {
    if((Math.random() * speed) < 50) {
      this.health -= amount;
    } else {
      System.out.println("Thy speed has prevented thee from taking damage! Lucky!");
    }
  }
  
  public int attack(Character e) {
    calcNewDamage(this);
    if (attackState.equals("specialize")) {
        //yes stackable speed is intended
        this.speed += 1;
        e.lowerHP(this.damage);
        System.out.println("Training with master elmo has paid off. Thy is now faster!");
    } else {
      e.lowerHP(this.damage);
    }
    
    
    return this.damage;
  }
}
