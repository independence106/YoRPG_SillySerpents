/** !!!!!!!! PROBABLY NEVER GOING TO BE USED
 * Undead: 
 * - base 50 hp
 * - 20 strength
 * - 0.5 attack rating
 * - 0 def
 * - 0 speed
 */
public class UndeadOProtag extends Protagonist {
    //cannot heal!
    public UndeadOProtag() {
      super();
      this.defense = 0;
      this.health = 50;
      this.strength = 20;
      this.attackRating = 0.5;
      this.speed = 0;

    }
    public UndeadOProtag(String name) {
      this();
      this.name = name;
  
    }
    public UndeadOProtag(int health,int strength, double attackRating, int defense, String name, int level) {
      super(health, strength, attackRating, defense, name, level);
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
  

