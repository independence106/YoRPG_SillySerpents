//added subclass wizard
public class Wizard extends Protagonist{

  public Wizard() {
    super();
  }
  public Wizard(String name) {
    super(name);
  }
  public void calcNewDamage() {
    this.damage = (int) (this.strength * this.attackRating);
  }
  public int attack(Character e) {
    calcNewDamage(this);
    if (attackState.equals("specialize")) {
        this.damage += 20;
        e.lowerHP(this.damage);
        System.out.println("Thy has summoned new vortex from dimension!");
    } else {
      e.lowerHP(this.damage);
    }
    
    
    return this.damage;
  }
}
