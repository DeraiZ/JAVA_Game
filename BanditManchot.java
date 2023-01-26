package Calc;

import Calc.Main;

import java.util.Random;
import java.util.Scanner;
import java.awt.*;

public class BanditManchot {
    static int sold = 1000;
    static int mise = 0;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        SoldOrMise();
    }

    public static void Hello(){
        Scanner input = new Scanner(System.in);
        System.out.print("Bienvenue au Bandit Manchot\n" +
                "Voici les regle du jeux : \n" +
                "  - Le Bandit Manchot possède 3 rouleaux\n" +
                "  - Chaque rouleau dispose de 4 possibilités par rouleau.Le Pique, Le Cœur, Le Trèfles, Le Carreau)\n" +
                "  - Il vous faut miser avant de lancer la machine.\n" +
                "  - Si aucun symbole n'est identiques, vous perdez votre mise\n" +
                "  - Si 2 symboles sont identiques, vous récuperez la moitier de votre mise\n" +
                "  - Si 3 symboles sont identiques, vous recuperer votre mise ainsi que sont double\n");
    }

    public static void SoldOrMise(){
        Hello();
        Scanner input = new Scanner(System.in);
        System.out.print("Souhaitez-vous solder ou miser: \n" +
                " 1 - Solder / 2 - Miser\n");
        int Choice = input.nextInt();
        if (Choice == 1){
            Sold();
        }if (Choice == 2){
            Mise();
        }
    }

        public static void Mise(){
            Scanner input = new Scanner(System.in);
            System.out.print("Selectionner vorte mise : \n"+
                    "1 - 50 jetons\n" +
                    "2 - 100 jetons\n" +
                        "3 - 150 jetons\n" +
                    "4 - Quitter\n");
            int selected = input.nextInt();
            if(selected == 1){
                mise = 50;
                System.out.print(mise + " jetons\n");
                sold = sold - mise;
                System.out.print("Votre solde est de " + sold + "\n");
                Game();
            } else if (selected == 2) {
                mise = 100;
                System.out.print(mise + " jetons\n");
                sold = sold - mise;
                System.out.print("Votre solde est de " + sold + "\n");
                Game();
            } else if (selected == 3) {
                mise = 150;
                System.out.print(mise + " jetons\n");
                sold = sold - mise;
                System.out.print("Votre solde est de " + sold + "\n");
                Game();
            } else if (selected == 4) {
                System.out.print(
                        "Vous quitter le Bandit Manchot,\n"+
                                "A bientôt\n");
            }else {
                System.out.print(
                        "Erreur, le choix selectionner est indisponible");
            }
        }




    public static void Sold(){

        Scanner input = new Scanner(System.in);
        System.out.print("votre sold actuelle est de " + sold + "\nCombien souhaitez-vous en ajouter ?\n");
        int newSold = input.nextInt();
        sold = sold + newSold;
        System.out.print("Votre nouveau solde est de " + sold + "\n ");
        Mise();
    }


    public static void Game(){
        Scanner input = new Scanner(System.in);
        String heart = "♥";
        String clover = "♣";
        String spade = "♠";
        String diamond = "♦";
        String[] Symbole = {heart, clover, spade, diamond};
        Random ran = new Random();
        String rand1 = Symbole[ran.nextInt(Symbole.length)];
        if (rand1.equals(heart) || rand1.equals(diamond)){
            System.out.print(ANSI_RED + rand1);
        }else {
            System.out.print(ANSI_BLUE + rand1);
        }

        String rand2 = Symbole[ran.nextInt(Symbole.length)];
        if (rand2.equals(heart) || rand2.equals(diamond)){
            System.out.print(ANSI_RED + rand2);
        }else {
            System.out.print(ANSI_BLUE + rand2);
        }

        String rand3 = Symbole[ran.nextInt(Symbole.length)];
        if (rand3.equals(heart) || rand3.equals(diamond)){
            System.out.print(ANSI_RED + rand3 + ANSI_RESET + "\n");
        }else {
            System.out.print(ANSI_BLUE + rand3 + ANSI_RESET + "\n");
        }

        if (!rand1.equals(rand2) && !rand1.equals(rand3) && !rand2.equals(rand3)){
            sold = sold;
            System.out.print("OH nooooon......\n"+
                    "Vous avez perdu\n" +
                    "Votre solde est desormais de " + sold + "\n");
            System.out.print("Voulez-vous rejouer? \n"+" 1 - Oui / 2 - Non \n");
            int replay = input.nextInt();
            if (replay == 1){
                Mise();
            } else if (replay == 2) {
                System.out.print(
                        "Vous quitter le Bandit Manchot,\n"+
                                "A bientôt\n");
                Main.main(null);
            }else {
                System.out.print("Je n'ai pas compris\n"+
                        "Voulez-vous rejouer? \n" +
                        " 1 - Oui / 2 - Non\n");
                replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter le Bandit Manchot,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }
            }
        } else if (rand1.equals(rand2) && !rand1.equals(rand3) || rand1.equals(rand3) && !rand1.equals(rand2) || rand2.equals(rand3) && !rand1.equals(rand3)) {
            sold = sold + (mise/2);
            System.out.print("Ah presque\n"+
                    "Votre solde est desormais de " + sold + "\n");
            System.out.print("Voulez-vous rejouer? \n"+" 1 - Oui / 2 - Non\n");
            int replay = input.nextInt();
            if (replay == 1){
                Mise();
            } else if (replay == 2) {
                System.out.print(
                        "Vous quitter le Bandit Manchot\n"+
                                "A bientôt\n");
                Main.main(null);
            }else {
                System.out.print("Je n'ai pas compris\n"+
                        "Voulez-vous rejouer? \n" +
                        " 1 - Oui / 2 - Non\n");
                replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter le Bandit Manchot,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }
            }

        } else {
            sold = sold + (mise + (mise*2));
            System.out.print("C'est GAGNE!\n"+
                    "Votre solde monte à " + sold + "jeton \n");
            System.out.print("Voulez-vous rejouer? \n" + " 1 - Oui / 2 - Non\n");
            int replay = input.nextInt();
            if (replay == 1){
                Mise();
            } else if (replay == 2) {
                System.out.print(
                        "Vous quitter le Bandit Manchot,\n"+
                                "A bientôt\n");
                Main.main(null);
            } else{
                System.out.print("Je n'ai pas compris\n"+
                        "Voulez-vous rejouer? \n" +
                        " 1 - Oui / 2 - Non\n");
                replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter le Bandit Manchot,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }
            }
        }
    }
}
