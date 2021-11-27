/**
 * Useless class until I move YoRPG into another class and whatnot
 */

import java.io.*;

public class ClassPrestiges {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader in = new BufferedReader(isr);
    
    static String classPick;

    static String[] basicClasses = {"Archer", "Swordsman", "Tank", "Wizard"};

    public ClassPrestiges() {

    }

    public static void pickAClass(YoRPG yo) {
        //If I ever move anything I can utilize this or smthing

        // System.out.println("Please choose thy starting class!" +
        //                "\n\t1. Tank\n\t2. Archer\n\t3. Wizard"
        //                + "\n\t4. Swordsman"); 
        // for (;;) {
        //     try {
        //         classPick = in.readLine();
        //         if (classPick.equals("1")) {
        //             yo.pat = new Tank(pat.name);
        //             break;
        //         } else if (classPick.equals("2")) {
        //             e = new Archer(name);
        //             break;
        //         } else if (classPick.equals("3")) {
        //             e = new Wizard(name);
        //             break;
        //         } else if (classPick.equals("4")) {
        //             e = new Swordsman(name);
        //             break;
        //         } else if (classPick.equals("info")) {
        //             System.out.println(
        //                 Tank.about() + Archer.about() + Wizard.about() + Swordsman.about()    
        //             );
        //         } else {
        //             System.out.println("Thy pick is not valid! Again!");
        //         }   
        //     } catch (Exception m) {
        //         System.out.println("Thy pick is not valid! Again!");
        //     }
        // }
    }
}