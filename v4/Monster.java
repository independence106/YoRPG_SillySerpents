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
public Monster(int health, int damage, int strength, double attackRating, int defense, String name, int level) {
    super(health, damage, strength, attackRating, defense, name, level);
}

}
