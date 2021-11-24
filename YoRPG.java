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
  * - FINAL ADDITIONS: Choose class, shop, level increase....
  */


import java.io.*;
import java.util.*;


public class YoRPG {

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

  //change this constant to set number of encounters in a game
  public final static int MAX_ENCOUNTERS = 5;

  //each round, a Protagonist and a Monster will be instantiated...
  private Protagonist pat;
  private Monster smaug;
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
    System.out.println("Please choose thy class!" +
                       "\n\t1. Tank\n\t2. Archer\n\t3. Wizard"
                       + "\n\t4. Swordsman");   
             
    while (!picked) {
      try {
        classPick = in.readLine();
        if (classPick.equals("1")) {
          pat = new Tank(name);
          picked = true;
        } else if (classPick.equals("2")) {
          pat = new Archer(name);
          picked = true;
        } else if (classPick.equals("3")) {
          pat = new Wizard(name);
          picked = true;
        } else if (classPick.equals("4")) {
          pat = new Swordsman(name);
          picked = true;
        } else if (classPick.equals("info")) {
          System.out.println(
            "\nTank: TONK! Tanky, well built, little damage" + 
            "\nArcher: TO FAST FOR YOU! Long range boi, fast, lotsa damage" +
            "\nWizard: ABRACADABAD! Powerful attacks, low health" +
            "\nSwordsman: ME SWING THING! Well built, medium damage, and health"
          );
        } else {
          System.out.println("Thy pick is not valid! Again!");
        }
      } catch (Exception e) {
        System.out.println("Thy pick is not valid! Again!");
      }
    } 
  
    

    

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
            System.out.println( "\nDo you feel lucky?" );
            System.out.println( "\t1: Nay.\n\t2: Aye!" );
            i = Integer.parseInt( in.readLine() );
            if (i < 3 && i > 0) {
              break;
            } else {
              System.out.println("Thee hath picked no valid option!");
            }
          }
          catch ( Exception e ) {
            System.out.println("Thee hath picked no number!");
          }
        }

        if ( i == 2 )
          pat.specialize();
        else
          pat.normalize();

        d1 = pat.attack( smaug );
        d2 = smaug.attack( pat );

        //added some stuff here (health bar indicators)
        System.out.println( "\n" + pat.getName() + " dealt " + d1 +
                            " points of damage.");
        if (smaug.isAlive())
          System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
                              " for " + d2 + " points of damage.\n\n\t" + pat.getName()
                              + " Health: " + pat.getHealth() + "\n\t" + "Monster Health: " +
                              smaug.getHealth());
        if (classPick.equals("2"))
          System.out.println("\n\tArcher Speed: " + pat.getSpeed());
        
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
        System.out.println( "'Twas an epic battle, to be sure... " +
                            "You cut ye olde monster down, but " +
                            "with its dying breath ye olde monster. " +
                            "laid a fatal blow upon thy skull." );
        return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
        System.out.println( "\nHuzzaaH! Ye olde monster hath been slain!" );

        // added things
        System.out.println( "\nYou hath gained 10 XP and climbed one level" +
                            "\nAdditionally thy battle rating hath increased by 0.1" +
                            "\n\t1: Gain 10 health.\n\t2: Gain 10 strength.");
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
          System.out.println("\nWelcome to Silly Serpent's shop!" +
                             "\nHere we sell all kinds of goodies" +
                             "\nTo help aid you on your journey!" +
                             "\nOur current inventory of magical items:" +
                             "\n\t1. Ring O Power: Boost Strength by 10 - 10 Coins" +
                             "\n\t2. Relic of TONKiness: Boost defense by 20 - 30 Coins" +
                             "\n\t3. Gem of confidence: Boost attack rating by 1 - 80 Coins" +
                             "\n\t4. Heart of an eagle: Boost maxhealth by 50 - 30 Coins" +
                             "\n\t5. Rabbit's foot: Boost speed by 10 - 5 Coins" +
                             "\n\t6. ????? - ????" +
                             "\n\t7. Exit" +
                             "\n\tBuy something or type 7 to exit!" +
                             "\n\tYour coins: " + pat.getCoins());    
          picked = false;
          while(!picked) {
          try {
            f = Integer.parseInt(in.readLine());
            if (f > 0 && f <= 7) {
              int coins = pat.getCoins();
              //so far stackable, will keep this as intentional!
              if (f == 1 && coins > 10) {
                pat.artifactChange(10, 0, 0, 0, 0, 0);
                pat.giveCoins(-10);
                System.out.println("\nThank you for buying!");
                pat.update();
                picked = true;
              } else if (f == 2 && coins > 30) {
                pat.artifactChange(0, 20, 0, 0, 0, 0);
                pat.giveCoins(-30);
                System.out.println("\nThank you for buying!");
                pat.update();
                picked = true;
              } else if (f == 3 && coins > 80) {
                pat.artifactChange(0, 0, 1, 0, 0, 0);
                pat.giveCoins(-80);
                System.out.println("\nThank you for buying!");
                pat.update();
                picked = true;
              } else if (f == 4 && coins > 30) {
                pat.artifactChange(0, 0, 0, 50, 0, 0);
                pat.giveCoins(-30);
                System.out.println("\nThank you for buying!");
                pat.update();
                picked = true;
              } else if (f == 5 && coins > 5) {
                pat.artifactChange(0, 0, 0, 0, 10, 0);
                pat.giveCoins(-5);
                System.out.println("\nThank you for buying!");
                pat.update();
                picked = true;
              } else if (f == 6 && coins > 100) {
                pat.artifactChange(0, 0, 0, 0, 0, 1);
                pat.giveCoins(-100);
                System.out.println("\nThank you for buying!");
                pat.update();
                picked = true;
              } else if (f == 7) {
                picked = true;
              } 
              else if (f == 7) {
                picked = true;
              }else {
                System.out.println("Thee hath not enough coins! OUCH!");
              }
            } else {
              System.out.println("Thee hath not picked a vlid option!");
            }

          } catch(Exception e) {
            System.out.println("Thee hath not picked a valid option!");
          }
        }
          System.out.println("\nEnjoy thy day!");      
          System.out.println("\nCoins: " + pat.getCoins());    
          System.out.println("\nNew stats: " + pat.toString());                 
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
