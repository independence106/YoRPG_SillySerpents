/**
 * Class to handle dialogue options ex: -- attacked -- 
 */
public class Dialogue {
    

    public Dialogue() {

    }
    public static void dealDamage(Protagonist protagonist, Monster monster) {
        int protagistDamage = protagonist.attack(monster);
        
        System.out.print( protagonist.test + monster.getType() + " for " + protagistDamage +
                            " points of damage.");
        int monsterDamage = monster.attack(protagonist);
        if (monster.isAlive())
          System.out.println( monster.test + 
                              " for " + monsterDamage + " points of damage.\n\n\t" + protagonist.getName()
                              + " Health: " + protagonist.getHealth() + "\n\t" + "Monster Health: " +
                              monster.getHealth());
    }
    public static void bothDie() {
        System.out.println( "'Twas an epic battle, to be sure... " +
                            "You cut ye olde monster down, but " +
                            "with its dying breath ye olde monster. " +
                            "laid a fatal blow upon thy skull." );
    }
    public static void beastDies() {
        System.out.println( "\nHuzzaaH! Ye olde monster hath been slain!" );
        System.out.println( "\nYou hath gained 10 XP and climbed one level" +
                            "\nAdditionally thy battle rating hath increased by 0.1" +
                            "\n\t1: Gain 10 health.\n\t2: Gain 10 strength.");
    }
    public static void listOptions(Character e) {
        
        e.getAttackType();
        System.out.println("Choose thy attack!");
    }
    public static void main(String[] args) {
        Archer elmo = new Archer("halleluga");
        Bandit bandit = new Bandit();
        System.out.println(bandit.health);
        dealDamage(elmo, bandit);
    }
}
