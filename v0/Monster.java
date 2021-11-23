public class Monster extends Character {

  private String type = "";
  
  public Monster() {
    super();
    this.type = "Ogre";
    this.strength = 5;
  }
  public Monster(String name) {
    super(name);
    this.type = "Ogre";
  }

  public int attack(Protagonist name) {
    if (attackState.equals("specialize")) {
      //System.out.println("Swinging Hammer...");
      int amplifier = (int) (Math.random() * 10);
      if (amplifier > 5) {
        damage += amplifier;

      } else {
        System.out.println("Youg swung too hard, and bashed thy skull");
        lowerHP(5);

      }
    } else {
      damage = 5;

    }
    name.lowerHP(damage);


    return damage;
  }

}
