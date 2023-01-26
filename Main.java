package Calc;

import Calc.Calculatrice;
import Calc.Shifumi;
import Calc.BanditManchot;
import Calc.Roulette;
import Calc.Blackjack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Quel exercice souhaiter vous faire ? \n" +
                "1 - Calculatrice\n" +
                "2 - Shifumi\n" +
                "3 - Bandit Manchot\n" +
                "4 - Roulette\n" +
                "5 - Blackjack\n"+
                "6 - Quitter\n");
        if (input.hasNextInt()){
            switch (input.nextInt()) {
                case 1:
                    Calculatrice.main(null);
                    break;
                case 2:
                    Shifumi.main(null);
                    break;
                case 3:
                    BanditManchot.main(null);
                    break;
                case 4:
                    Roulette.main(null);
                    break;
                case 5:
                    System.out.print("Fonctionnalité indisponible pour le moment.\n"+
                            "Veuillez choisir une autre fonctionnalité\n");
                    Main.main(null);
                    break;
                case 6:
                    System.out.print("Vous quittez les Jeux JAVA\n"+
                            "A bientôt\n");
                    return;
                default:
                    System.out.print("Je ne connais pas l'exercice");
                    main(null);
            }
        }else if (input.hasNextLine()){
            System.out.print("Je ne vous ai pas compris.\n" + "Veuillez choisir un exercice valide\n");
            main(null);
        }
    }
}