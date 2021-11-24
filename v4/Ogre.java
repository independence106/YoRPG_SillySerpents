//new subclass ogre, basically a swordsman but monster
public class Ogre extends Monster {
    public Ogre() {
        super();
    }
    public Ogre(String name) {
        super(name);
    }
    public Ogre(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
        super(health, damage, strength, attackRating, defense, name, level);
    }
    public String getType() {
      return "Ogre";
    }
    public static String about() {
      return "Grunt. Not the talkative type. You don't want to mess with these bad boys." +
             "\nThey pack quite a punch. Seriously, don't mess with them.";
    }
    public int attack(Character e) {
        calcNewDamage(this);
        if (attackState.equals("specialize")) {
          //System.out.println("Swinging Hammer...");
          int amplifier = (int) (Math.random() * 10);
          if (amplifier > 5) {
            damage += amplifier * 2;
            e.lowerHP(this.damage);
          } else {
            System.out.println("Youg swung too hard, and bashed thy skull. Ye lost 5 health!");
            lowerHP(5);
            e.lowerHP(this.damage);
          }
        } else {
          e.lowerHP(this.damage);
          System.out.println(this.name + " performs head bash!");
        }
        return this.damage;
      }
}
