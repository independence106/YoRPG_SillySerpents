//added subclass tank. TONK
public class Tank extends Protagonist{
  public Tank() {
    this.health = 200;
    this.level = 0;
    this.maxHealth = 200;
    this.attackState = "normalize";
    this.defense = 20;
    this.attackRating = 0.5;
    this.strength = 50;
  }
  public Tank(String name) {
    this();
    this.name = name;
    this.strength = 50;
  }
  public static String about() {
    return "TONK. ME TONK. Will take a beating from any monster. Passed tank school" +
           "\nwith full honors. Can heal himself too! Very useful.";
  }
  public int attack(Character e) {
    calcNewDamage(this);
    if (attackState.equals("specialize")) {
        this.health += 20;
        
        System.out.println("Youg hath used shield of holy powers! Heal thyself for 20HP!");
        return 0;
      } else {
      e.lowerHP(this.damage);
      return this.damage;
    }
    
    
    
  }

}
