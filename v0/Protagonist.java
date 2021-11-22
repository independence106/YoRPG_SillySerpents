public class Protagonist extends Character{



  public Protagonist() {
    super();
  }
  public Protagonist(String name) {
    super(name);
  }

  public int attack(Monster name) {
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
