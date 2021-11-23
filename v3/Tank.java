public class Tank extends Protagonist{

  public Tank() {
    this.health = 200;
    this.level = 0;
    this.maxHealth = 200;
    this.attackState = "normalize";
    this.defense = 20;
    this.attackRating = 0.01;
    this.strength = 10;
  }
  public Tank(String name) {
    this();
    this.name = name;
  }
  public int attack(Character e) {
    calcNewDamage(this);
    if (attackState.equals("specialize")) {
      //System.out.println("Swinging Hammer...");
      int amplifier = (int) (Math.random() * 10);
      if (amplifier > 5) {
        this.health += 20;
        System.out.println("Youg hath used shield of holy powers!");

      } else {
        System.out.println("Youg swung too hard, and bashed thy skull. Ye lost 5 health!");
        lowerHP(5);

      }
    }
    e.lowerHP(this.damage);
    return this.damage;
  }

}
