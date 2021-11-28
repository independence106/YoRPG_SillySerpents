/**
 * Tonk
 *
 * Special: Taunt: Next two attacks, monster can 50% chance of missing (cooldown 4 turns) <-- not implemented
 * - 30 defense
 * - 300 HP
 * - Speed -5
 * - 0.4 attack Rating
 * - 25 strength
 */
public class Tonk extends Tank {
    
    private boolean taunt = false;
    private int counter = 0;

    public Tonk() {
      super();
      this.strength = 25;
      this.health = 300;
      this.maxHealth = 300;
      this.attackRating = 0.4;
      this.speed -= 5;
      this.defense = 30;
      this.attackTypes = new String[] {"Shield Slap", "Shield O' Life", "Taunt"};
    }
    public Tonk(String name) {
      this();
      this.name = name;
    }
    //HEY fix this:
    public Tonk(int maxHealth, int strength, double attackRating, int defense, String name, int level, int speed, int coins) {
      this.health = maxHealth + 100;
      this.maxHealth = maxHealth + 100;
      this.strength = strength - 5;
      this.attackRating = attackRating - 0.1;
      this.speed = speed - 5;
      this.defense = defense + 10;
      this.coins = coins;
      this.level = level;
      this.name = name;
      this.attackTypes = new String[] {"Shield Slap", "Shield O' Life", "Taunt"};
    }
    public static String about() {
      return "Tank's Big brother, earned a new set of armor forged by the holy dwarves";
    }
    public boolean getTauntStatus() {
        return taunt;
    }
    public void lowerHP(int amount, String attackingClass) {
      if (taunt == true) {
        this.attackMiss = "Ha! Thy taunt enrages puny monsters and thee takes no damage!";
      } else {
        if((Math.random() * speed) < 50) {
          this.health -= amount;
          this.attackMiss = "";
        } else {
          this.attackMiss = "\nThy speed has prevented thee from taking damage! Lucky!";
        }
      }
    }
    public int attack(Character e) {
      calcNewDamage(this, e);
      if (attackState.equals("Taunt")) {
        //System.out.println("Swinging Hammer...");
        //ALWAYS ROUNDS TO NEAREST!!!
        double RNGesus = Math.random();
        if (counter < 4 && counter > 0) {
          this.test = "\nCannot use ability tant for " + (4 - counter) + " turns. You attack ";
        } else if (RNGesus > 0.5) {
            if (counter >= 4) {
                taunt = false;
                counter = 0;
            }
            if (counter == 0) {
                this.test = "\nYou hath taunted thy enemy. You attack ";
                taunt = true;
            } 
        } else {
            this.test = "\nTaunt ability hath failed and you doth dealt no damage. Thee attacks ";
        }
        this.damage = 0;

      } else if (attackState.equals("Shield O' Life")) {
        if ((this.maxHealth - this.health ) > 20) {
          this.health += 20;
          this.test = "\nYoug hath used shield o' life! Heal thyself for 20HP! Thee attacks ";
        } else {
          this.health = this.maxHealth;
          this.test = "\nYoug hath used shield o' life! Heal thyself to max health for " + (this.maxHealth - this.health) + "HP! Thee attacks ";
        }
        this.damage = 0;
      } else {
        this.test = "\nThy hath swung shield and attacked ";
        e.lowerHP(this.damage, this.getType());
      }
      counter++;
      if (counter >= 4) {
        taunt = false;
      }
      return this.damage;
    }
  }
  