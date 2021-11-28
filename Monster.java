//no updates

public class Monster extends Character {  
  public Monster() {
    super();
    this.defense = 5;
  }
  public Monster(String name) {
      super(name);
      this.defense = 5;
  }
  public String getType() {
    return "";
  }
  public Monster(int health, int strength, double attackRating, int defense, String name, int level) {
      super(health, strength, attackRating, defense, name, level);
  } 
  public void lowerHP(int amount) {
    if((Math.random() * speed) < 50) {
      this.health -= amount;
      this.attackMiss = "";
    } else {
      this.attackMiss = "\nThy speed has prevented thee from taking damage! Unlucky for you!!";
    }
  }
  public void lowerHP(int amount, String attackingClass) {
    if((Math.random() * speed) < 50) {
      this.health -= amount;
      this.attackMiss = "";
    } else {
      this.attackMiss = "\n" + this.type + " speed has prevented thee from taking damage! Unlucky for you!!";
    }
  }
  public int attack(Character e) {
    calcNewDamage(this, e);
    if (attackState.equals("specialize")) {
      //System.out.println("Swinging Hammer...");
      int amplifier = (int) (Math.random() * 10);
      if (amplifier > 5) {
        damage += amplifier * 2;
        e.lowerHP(this.damage, this.getType());
        System.out.println("WOWEE! Thy gods have blessed thee I see! Extra DAMAGE!");
      } else {
        System.out.println("Youg swung too hard, and bashed thy skull. Ye lost 5 health!");
        lowerHP(5);
        e.lowerHP(this.damage, this.getType());
      }
    } else {
      this.test = "\nMonster grabs you, shakes you around and throws you against a rock";
      e.lowerHP(this.damage, this.getType());
    }
    return this.damage;
  }

}
