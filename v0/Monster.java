public class Monster extends Character {



  public Monster() {
    super();

  }
  public Monster(String name) {
    super(name);

  }

  public int attack(Protagonist name) {
    if (attackState.equals("specialize")) {
      //System.out.println("Swinging Hammer...");
      int amplifier = (int) (Math.random() * 10);
      if (amplifier > 5) {
        damage += amplifier;

      } else {
        System.out.println("Youg swung too hard, and bashed thy skull");
        takeDamage(5);

      }
    } else {
      damage = 5;

    }
    name.takeDamage(damage);


    return damage;
  }

}
