//no updates

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

}
