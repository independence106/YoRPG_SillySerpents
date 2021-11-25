//just a swordsman, bad class in my opinion!
public class Swordsman extends Protagonist{

  public Swordsman() {
    super();
  }
  public Swordsman(String name) {
    super(name);
  }
  public Swordsman(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
    super(health, damage, strength, attackRating, defense, name, level);
  }
  public static String about() {
    return "Me bash head. Quite literally, this class is a well built class" + 
           "\nIt is very well rounded, and essential to every dungeon party!";
  }
  
}
