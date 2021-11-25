//added subclass wizard
public class Wizard extends Protagonist{

  public Wizard() {
    super();
    this.defense = 0;
    this.health = 50;
  }
  public Wizard(String name) {
    super(name);
    this.defense = 0;
    this.health = 50;

  }
  public void calcNewDamage() {
    this.damage = (int) (this.strength * this.attackRating);
  }
  public static String about() {
    return "Abrahahsdfa. Very forgetful about his spellbook" +
           "\nMay occasionally turn something into a cat. Kinda cuckoo";
  }
  public int attack(Character e) {
    calcNewDamage(this, e);
    if (attackState.equals("specialize")) {
        this.damage += 20;
        e.lowerHP(this.damage, this.getType());
        System.out.println("Thy has summoned new vortex from dimension!");
    } else {
      e.lowerHP(this.damage, this.getType());
    }
    
    
    return this.damage;
  }
}
