//added subclass tank. TONK
public class Tank extends Protagonist{



  public Tank() {
    this.health = 200;
    this.level = 0;
    this.maxHealth = 200;
    this.attackState = "normalize";
    this.defense = 20;
    this.attackRating = 0.05;
    this.strength = 10;
  }
  public Tank(String name) {
    this();
    this.name = name;
  }
  public int attack(Character e) {
    calcNewDamage(this);
    if (attackState.equals("specialize")) {
        this.health += 20;
        e.lowerHP(this.damage);
        System.out.println("Youg hath used shield of holy powers!");
    } else {
      e.lowerHP(this.damage);
    }
    
    
    return this.damage;
  }

}
