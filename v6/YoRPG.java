/**********************************************
 * class YoRPG -- Driver file for Ye Olde Role Playing Game.
 * Simulates monster encounters of a wandering adventurer.
 * Required classes: Protagonist, Monster
 *
 * USAGE:
 * Compile. Note messages generated.
 * Devise a plan of attack with your trio.
 * Code incrementally, testing each bit of new functionality as you go.
 * The only modification you should make to this driver file is moving comment bar down in main method, and filling in DISCO/QCC
 * (If you feel other changes are merited, note what and why, so that we may discuss on the 'morrow.)
 *
 * DISCO:
 *
 * QCC:
 *
 **********************************************/

 /**
  * - THE SHOP!!!! NEW ARTIFACTS POGGERS, GAME IS UNBALANCED THOUGH!
  *
  * - cleaned up some code
  */


import java.io.*;
import java.util.*;


public class YoRPG {

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

  //change this constant to set number of encounters in a game
  public final static int MAX_ENCOUNTERS = 5;

  //each round, a Protagonist and a Monster will be instantiated...
  Protagonist pat;
  Monster smaug;
  String classPick = "";

  private int moveCount;
  private boolean gameOver;
  private int difficulty;

  private InputStreamReader isr;
  private BufferedReader in;
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
  public YoRPG() {
    moveCount = 0;
    gameOver = false;
    isr = new InputStreamReader( System.in );
    in = new BufferedReader( isr );
    newGame();
    
  }
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

  /*=============================================
    void newGame() -- gathers info to begin a new game
    pre:
    post: according to user input, modifies instance var for difficulty
    and instantiates a Protagonist
    =============================================*/
  public void newGame() {
    String s;
    String name = "";
    
    Boolean picked = false;
    s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

    s += "\nChoose your difficulty: \n";
    s += "\t1: Easy\n";
    s += "\t2: Not so easy\n";
    s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
    s += "Selection: ";
    System.out.print( s );

    while(true) {
      try {
        difficulty = Integer.parseInt( in.readLine() );
        if (difficulty > 3) {
          throw new IOException("Thee hath picked no difficulty! Try Again");
        }
        break;
      }
      catch ( Exception e) { 
        System.out.println("Thee hath picked no difficulty! Try Again");
      }
    }
    s = "Intrepid protagonist, what doth thy call thyself? (State your name): ";
    System.out.print( s );
    while(true) {
      try {
        name = in.readLine();
        break;
      }
      catch ( IOException e ) {
        System.out.println("Thee has a name, hath not?");
      }
    }
      
    this.pickAClass(name);
    System.out.println("Hi");
    this.prestige();
    

    

  }//end newGame()


  /*=============================================
    boolean playTurn -- simulates a round of combat
    pre:  Protagonist pat has been initialized
    post: Returns true if player wins (monster dies).
    Returns false if monster wins (player dies).
    =============================================*/
  public boolean playTurn() {
    boolean picked = false;
    int i = 1;
    int f = 1;
    int d1, d2;
    
    if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
    else {
	    
      if (Math.random() > 0.66) {
	      smaug = new Ogre("smaug");
      } else if (Math.random() < 0.33) {
        smaug = new Worg("smaug");
      } else {
        smaug = new Bandit("smaug");
      }
      System.out.println( "\nLo, yonder " + smaug.getType() + " approacheth!" );

      
	    while( smaug.isAlive() && pat.isAlive() ) {

        // Give user the option of using a special attack:
        // If you land a hit, you incur greater damage,
        // ...but if you get hit, you take more damage.
        while(true) {
          try {
            Dialogue.listOptions(pat);
            
            i = Integer.parseInt( in.readLine() );
            if (i < (pat.attackTypes.length + 1) && i > 0) {
              break;
            } else {
              System.out.println("Thee hath picked no valid option!");
            }
          }
          catch ( Exception e ) {
            System.out.println("Thee hath picked no number!");
          }
        }

        
        pat.setAttackType(pat.attackTypes[i - 1]);
        
        
        Dialogue.dealDamage(pat, smaug);
        
        
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
        Dialogue.bothDie();
        return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
        Dialogue.beastDies();
        pat.attackRating += 0.1;
        while (true) {
          try {
            f = Integer.parseInt(in.readLine());
            break;
          } catch (IOException z) {
            System.out.println("Thee hath picked no number!");
          }
        }

        if (f == 1) {
          pat.increaseLevel(10, 0);
        } else {
          pat.increaseLevel(0, 10);
        }
        if (pat.getLevel() == 3 ) {
          System.out.println("Thy hath earned new ability!");
        }
        System.out.println("\nWell done hero! You has slain a monster! Health hath been reset!");
        pat.resetHealth();
        pat.giveCoins((int) (Math.random() * 10));
        System.out.println("\nHey there weary traveler! " +
                           "Would thee like access to the SHOP?" +
                           "\n\t1. YES\n\t2. NO");
        picked = false;
        while(!picked) {
          try {
            f = Integer.parseInt(in.readLine());
            if (f == 1) {
              picked = true;
            } else if (f == 2) {
              picked = true;
            } else {
              System.out.println("Thee hath not picked a valid option!");
            }

          } catch(Exception e) {
            System.out.println("Thee hath not picked a valid option!");
          }
        }
        //THIS IS STACKABLE!!!!! INTENDED!!!
        if (f == 1) {
          Shop.purchase(pat);              
        } else {
          System.out.println("\nCoins: " + pat.getCoins());    
          System.out.println("\nNew stats: " + pat.toString()); 
        }
        return true;
       
        
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
        System.out.println( "Ye olde self hath expired. You got dead." );
        return false;
	    }
    }//end else

    return true;
  }//end playTurn()
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void pickAClass(String name) {
    //If I ever move anything I can utilize this or smthing

     System.out.println("Please choose thy starting class!" +
                    "\n\t1. Tank\n\t2. Archer\n\t3. Wizard"
                    + "\n\t4. Swordsman"); 
     for (;;) {
         try {
             classPick = in.readLine();
              if (classPick.equals("1")) {
                 pat = new Tank(name);
                 break;
             } else if (classPick.equals("2")) {
                 pat = new Archer(name);
                 break;
             } else if (classPick.equals("3")) {
                 pat = new Wizard(name);
                 break;
             } else if (classPick.equals("4")) {
                 pat = new Swordsman(name);
                 break;
             } else if (classPick.equals("info")) {
                 System.out.println(
                     Tank.about() + Archer.about() + Wizard.about() + Swordsman.about()    
                 );
            } else {
                System.out.println("Thy pick is not valid! Again!");
            }   
        } catch (Exception m) {
            System.out.println("Thy pick is not valid! Again!");
        }
     }
  }
  public void prestige() {
    String pick = "";
    String[] picks = {"",""};
    System.out.println("\nYour current class : " + pat.getType());
    picks[0] = pat.getType();
    System.out.println("\n\nDear Adventurer, you have reached the point where you can prestige! Choose wisely!");
    int pos = 0;
    for (int i = 0; i < Character.classTypes.length; i++) {
      if (Character.classTypes[i].equals(pat.getType())) {
        pos = i;
      }
    }
    System.out.println("\nHere are your available classes!" +
                       "\n\t1. " + Character.classTypes[pos + 1] + 
                       "\n\t2. " + Character.classTypes[pos + 2]);
    for (;;) {
      try {
        pick = in.readLine();
        break;
      } catch (Exception o) {
        System.out.println("Invalid Choice. Try Again!");
      }
    }
    if (picks[0].equals("Tank")) {
      if (pick.equals("1")) {
        pat = new Tonk();
      } else {
        pat = new Fortress();
      }
    } else if (picks[0].equals("Archer")) {
      if (pick.equals("1")) {
        pat = new Sniper();
      } else {
        pat = new Gunner();
      }
    } else if (picks[0].equals("Wizard")) {
      if (pick.equals("1")) {
        pat = new Arcane();
      } else {
        pat = new Necromancer();
      }
    } else {
      if (pick.equals("1")) {
        pat = new Paladin();
      } else {
        pat = new Barbarian();
      }
    }
  }
  

  public static void main( String[] args ) {
    //As usual, move the begin-comment bar down as you progressively
    //test each new bit of functionality...

    
    //loading...
    YoRPG game = new YoRPG();

    int encounters = 0;

    while( encounters < MAX_ENCOUNTERS ) {
    if ( !game.playTurn() )
    break;
    encounters++;
    System.out.println();
    }

    System.out.println( "Thy game doth be over." );

  }//end main

}//end class YoRPG
