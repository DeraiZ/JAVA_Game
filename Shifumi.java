package Calc;

import Calc.Main;

import java.util.Random;
import java.util.Scanner;

public class Shifumi {
    /*Define static variable reusable in all methods: */
    /*Variable initialize for the computer choice*/
    public static String iaChoice;
    /*Variable initialisation for your choice*/
    public static String choice;
    /*Variable initialisation for win*/
    public static int win = 0;
    /*Variable initialisation for lose*/
    public static int lose = 0;
    /*Variable initialisation for draw*/
    public static int draw = 0;

    /*Main method*/
    public static void main(String[] args) {
        /*Call choice method*/
        Choice();
    }

    /*Define the choice method*/
    public static void Choice(){
        /*Initialize minimum and maximum variable for Random*/
        int min = 0;
        int max = 2;

        /*Define shifumi choice array for computer*/
        String[] shifumi = {"pierre", "feuille", "ciseaux"};
        Scanner input = new Scanner(System.in);
        /*Call Java Random method*/
        Random ran = new Random();
        /*Initialize round variable*/
        int round = 0;
        /*Play while round inferior to 3*/
        while(round < 3){
            /*initialize Random number between min and max*/
            int i = ran.nextInt(max - min) + min;
            /*Get computer choice in array by random index i*/
            iaChoice = shifumi[i];
            /*Print your choice available*/
            System.out.print("Que choisissez vous de jouer ?\n" +
                    " - Pierre \n"+
                    " - Feuille\n" +
                    " - Ciseaux\n");
            /*Get your choice*/
            choice = input.nextLine();
            /*Play according to your choice*/
            switch (choice){
                /*If you choose "pierre"*/
                case "pierre":
                    /*Call game method*/
                    game();
                    break;
                /*If you choose "feuille"*/
                case "feuille":
                    /*Call game method*/
                    game();
                    break;
                /*If you choose "ciseaux"*/
                case "ciseaux":
                    /*Call game method*/
                    game();
                    break;
                /*Default case if choice not in proposal*/
                default:
                    System.out.print("Erreur: Veuillez choiseir une des propostions");
                    Choice();
            }
            /*add 1 to round*/
            round += 1;
        }
        /*After 3 round, print number of win, lose and draw*/
        System.out.print("Win: " + win +"\nlose: "+ lose + "\nDraw: " + draw + "\n" );
        /*Call Replay method*/
        Replay();
    }

    /*Define game method*/
    public static void game(){
        /*you and the computer choose the same proposal*/
        if (choice.equals(iaChoice)){
            /*add 1 to variable draw*/
            draw += 1;
            System.out.print("Il y a égualité\n");
        }
        /*You choose "pierre" and the computer choose "ciseaux*/
        else if (choice.equals("pierre") && iaChoice.equals("ciseaux")) {
            /*add 1 to win variable*/
            win += 1;
            System.out.print("Vous avez choisi " + choice + " et l'ordinateur à choisi " + iaChoice+ "\n" +
                    "Vous avez Gagné\n");
        }
        /*You choose "ciseaux" and the computer choose "feuille*/
        else if (choice.equals("ciseaux") && iaChoice.equals("feuille")) {
            /*add 1 to win variable*/
            win += 1;
            System.out.print("Vous avez choisi " + choice + " et l'ordinateur à choisi " + iaChoice+ "\n" +
                    "Vous avez Gagné\n");
        }
        /*You choose "feuille" and the computer choose "pierre*/
        else if (choice.equals("feuille") && iaChoice.equals("pierre")) {
            /*add 1 to win variable*/
            win += 1;
            System.out.print("Vous avez choisi " + choice + " et l'ordinateur à choisi " + iaChoice+ "\n" +
                    "Vous avez Gagné\n");
        }
        /*You choose a proposal and the computer choose the one to win against yours*/
        else {
            /*add 1 to lose variable*/
            lose += 1;
            System.out.print("Vous avez choisi " + choice + " et l'ordinateur à choisi " + iaChoice+ "\n" +
                    "Vous avez Perdu\n");
        }
    }

    /*Define Replay method*/
    public static void Replay(){
        /*Initialize variable to 0*/
        win = 0;
        lose = 0;
        draw = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Voulez vous rejouer ?\n"+
                " 1 - Oui / 2 - Non\n");
        /*Loop to verify if the choice is an int or a string*/
        if (input.hasNextInt()){
            /*Loop to know if you want to replay or exit*/
            switch (input.nextInt()) {
                /*If you want to replay then call the Choice method*/
                case 1 -> Choice();
                /*If you don't want to replay then quit the game*/
                case 2 -> {
                    System.out.print("Vous quitter le Shifumi");
                    Main.main(null);
                }
                /*If the number you choose isn't in the proposal then ask again*/
                default -> {
                    System.out.print("Je ne vous ai pas compris.\n");
                    Replay();
                }
            }
        }
        /*If the character put in the input is a string then ask again to choose*/
        else if (input.hasNextLine()){
            System.out.print("Je ne vous ai pas compris.\n" + "Veuillez choisir entre 1 et 2\n");
            Replay();
        }
    }
}
