package Calc;

import Calc.Main;

import java.awt.desktop.SystemEventListener;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Roulette {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    static int sold = 1000;
    static int mise;
    static int color;
    static int pair;
    static int impair;
    static int manque;
    static int passe;
    static int unique;
    static int nb_unique;
    static int mised;
    static String newcolor;
    public static void main(String[] args) {
        Mise();
    }

    public static void rule(){
        Scanner input = new Scanner(System.in);
        System.out.print("Bienvenue à La Roulette\n" +
                "- Il y a 36 de (1 à 36) nombres et deux couleurs (à vous de les choisir).\n" +
                "- Il y a 6 mises possible :\n" +
                "  o Couleur\n" +
                "  o Pair\n" +
                "  o Impair\n" +
                "  o Manque (nombres de 1 à 18)\n" +
                "  o Passe (nombres de 19 à 36)\n" +
                "  o Chiffre ou Nombre unique\n" +
                "Si le joueur mise sur un chiffre ou un nombre unique et gagne :\n" +
                "-Il remporte sa mise *36.\n" +
                "Si le joueur mise sur une autre possibilité et qu’il gagne :\n" +
                "-Il remporte sa mise * 2.\n" +
                "Si le joueur perd :\n" +
                "-Il pers sa mise.\n" +
                "- Le joueur mise avant de lancer la bille.\n");
    }

    public static void Mise() {
        rule();
        System.out.print("Voulez-vous commencer à miser ?\n" +
                ANSI_GREEN + " 1 - Oui "+ANSI_RESET+"/"+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
        Scanner input = new Scanner(System.in);
        int begin = input.nextInt();
        System.out.print("Votre solde est de " + sold + "\n");
        if (begin == 1) {
            System.out.print("Sur quoi voulez vous miser: \n" +
                    ANSI_CYAN +
                    "  1 - Couleur\n" +
                    "  2 - Pair\n" +
                    "  3 - Impair\n" +
                    "  4 - Manque (nombres de 1 à 18)\n" +
                    "  5 - Passe (nombres de 19 à 36)\n" +
                    "  6 - Chiffre ou Nombre unique\n"+
                    ANSI_RESET);
            mise = input.nextInt();
            if (mise == 1) {
                System.out.print("Sur quel couleur voulez-vous miser: \n" +
                        "Gain : votre mise * 2\n" +
                        "1 -" + ANSI_RED + "rouge " + ANSI_RESET + "/ 2 - "+ ANSI_BLACK + "noir"+ ANSI_RESET +"\n");
                color = input.nextInt();
                if (color == 1) {
                    newcolor = "rouge";
                    System.out.print("Vous miser sur le rouge.\n" +
                            ANSI_GREEN +" 1 - Confirmer"+ ANSI_RESET + " / " + ANSI_RED + "2 - Annuler\n"+ANSI_RESET);
                    int conf = input.nextInt();
                    if (conf == 1) {
                        System.out.print("Combien voulez-vous miser\n");
                        mised = input.nextInt();
                        if (mised <= sold) {
                            sold = sold - mised;
                            System.out.print("Vous miser " + mised + "\n");
                            game();
                        } else {
                            System.out.print("Mise impossible car votre solde est trop faible\n");
                            System.out.print("votre sold actuelle est de " + sold + "\nCombien souhaitez-vous en ajouter ?\n");
                            int newSold = input.nextInt();
                            sold = sold + newSold;
                            System.out.print("Votre nouveau solde est de " + sold + "\n ");
                            Mise();
                        }
                    }else {
                        System.out.print("Erreur");

                        Mise();
                    }

                } else if (color == 2) {
                    newcolor = "noir";
                    System.out.print("Vous miser sur le noir.\n" +
                            ANSI_GREEN +" 1 - Confirmer"+ ANSI_RESET + " / " + ANSI_RED + "2 - Annuler\n"+ANSI_RESET);
                    int conf = input.nextInt();
                    if (conf == 1) {
                        System.out.print("Combien voulez-vous miser");
                        mised = input.nextInt();
                        if (mised <= sold) {
                            sold = sold - mised;
                            System.out.print("Vous miser " + mised);
                            game();
                        } else {
                            System.out.print("Mise impossible car votre solde est trop faible");
                            System.out.print("votre sold actuelle est de " + sold + "\nCombien souhaitez-vous en ajouter ?\n");
                            int newSold = input.nextInt();
                            sold = sold + newSold;
                            System.out.print("Votre nouveau solde est de " + sold + "\n ");
                            Mise();
                        }
                    }
                }else {
                    System.out.print("Erreur");
                    Mise();
                }

            }else if (mise == 2) {
            System.out.print("Voulez-vous miser sur un nombre pair: \n" +
                    "Gain : votre mise * 2\n" +
                    ANSI_GREEN + " 1 - Oui "+ANSI_RESET+" / "+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
            pair = input.nextInt();
            if (pair == 1) {
                System.out.print("Vous miser sur pair.\n" +
                        ANSI_GREEN +" 1 - Confirmer"+ ANSI_RESET + " / " + ANSI_RED + "2 - Annuler\n"+ANSI_RESET);
                int conf = input.nextInt();
                if (conf == 1) {
                    System.out.print("Combien voulez-vous miser\n");
                    mised = input.nextInt();
                    if (mised <= sold) {
                        sold = sold - mised;
                        System.out.print("Vous miser " + mised + "\n");
                        game();
                    } else {
                        System.out.print("Mise impossible car votre solde est trop faible\n");
                        System.out.print("votre sold actuelle est de " + sold + "\nCombien souhaitez-vous en ajouter ?\n");
                        int newSold = input.nextInt();
                        sold = sold + newSold;
                        System.out.print("Votre nouveau solde est de " + sold + "\n ");
                        Mise();
                    }
                } else {
                    Mise();
                }
            } else if (pair == 2) {
                Mise();
            }
        } else if (mise == 3) {
            System.out.print("Voulez-vous miser sur un nombre impair: \n" +
                    "Gain : votre mise * 2\n" +
                    ANSI_GREEN + " 1 - Oui "+ANSI_RESET+" / "+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
            impair = input.nextInt();
            if (impair == 1) {
                System.out.print("Vous miser sur impair.\n" +
                        ANSI_GREEN +" 1 - Confirmer"+ ANSI_RESET + " / " + ANSI_RED + "2 - Annuler\n"+ANSI_RESET);
                int conf = input.nextInt();
                if (conf == 1) {
                    System.out.print("Combien voulez-vous miser\n");
                    mised = input.nextInt();
                    if (mised <= sold) {
                        sold = sold - mised;
                        System.out.print("Vous miser " + mised + "\n");
                        game();
                    } else {
                        System.out.print("Mise impossible car votre solde est trop faible \n");
                        System.out.print("votre sold actuelle est de " + sold + "\nCombien souhaitez-vous en ajouter ?\n");
                        int newSold = input.nextInt();
                        sold = sold + newSold;
                        System.out.print("Votre nouveau solde est de " + sold + "\n ");
                        Mise();
                    }
                } else {
                    Mise();
                }
            } else if (impair == 2) {
                Mise();
            }
        } else if (mise == 4) {
            System.out.print("Voulez-vous miser sur un nombre manquer: \n" +
                    "Gain : votre mise * 2\n" +
                    ANSI_GREEN + " 1 - Oui "+ANSI_RESET+" / "+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
            manque = input.nextInt();
            if (manque == 1) {
                System.out.print("Vous miser sur manque.\n" +
                        ANSI_GREEN +" 1 - Confirmer"+ ANSI_RESET + " / " + ANSI_RED + "2 - Annuler\n"+ANSI_RESET);
                int conf = input.nextInt();
                if (conf == 1) {
                    System.out.print("Combien voulez-vous miser\n");
                    mised = input.nextInt();
                    if (mised <= sold) {
                        sold = sold - mised;
                        System.out.print("Vous miser " + mised + "\n");
                        game();
                    } else {
                        System.out.print("Mise impossible car votre solde est trop faible\n");
                        System.out.print("votre sold actuelle est de " + sold + "\nCombien souhaitez-vous en ajouter ?\n");
                        int newSold = input.nextInt();
                        sold = sold + newSold;
                        System.out.print("Votre nouveau solde est de " + sold + "\n ");
                        Mise();
                    }
                } else {
                    Mise();
                }
            } else if (manque == 2) {
                Mise();
            }
        } else if (mise == 5) {
            System.out.print("Voulez-vous miser sur un nombre passe: \n" +
                    "Gain : votre mise * 2\n" +
                    ANSI_GREEN + " 1 - Oui "+ANSI_RESET+" / "+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
            passe = input.nextInt();
            if (passe == 1) {
                System.out.print("Vous miser sur passe.\n" +
                        ANSI_GREEN +" 1 - Confirmer"+ ANSI_RESET + " / " + ANSI_RED + "2 - Annuler\n"+ANSI_RESET);
                int conf = input.nextInt();
                if (conf == 1) {
                    System.out.print("Combien voulez-vous miser\n");
                    mised = input.nextInt();
                    if (mised <= sold) {
                        sold = sold - mised;
                        System.out.print("Vous miser " + mised + "\n");
                        game();
                    } else {
                        System.out.print("Mise impossible car votre solde est trop faible\n");
                        System.out.print("votre sold actuelle est de " + sold + "\nCombien souhaitez-vous en ajouter ?\n");
                        int newSold = input.nextInt();
                        sold = sold + newSold;
                        System.out.print("Votre nouveau solde est de " + sold + "\n ");
                        Mise();
                    }
                } else {
                    Mise();
                }
            } else if (passe == 2) {
                Mise();
            }
        } else if (mise == 6) {
            System.out.print("Voulez-vous miser sur un nombre ou chiffre unique: \n" +
                    "Gain : votre mise * 36\n" +
                    ANSI_GREEN + " 1 - Oui "+ANSI_RESET+" / "+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
            unique = input.nextInt();
            if (unique == 1) {
                System.out.print("Vous miser sur unique.\n" +
                        ANSI_GREEN +" 1 - Confirmer"+ ANSI_RESET + " / " + ANSI_RED + "2 - Annuler\n"+ANSI_RESET);
                int conf = input.nextInt();
                System.out.print("Sur quel numéro voulez vous miser: \n");
                nb_unique = input.nextInt();
                if (conf == 1) {
                    System.out.print("Combien voulez-vous miser\n");
                    mised = input.nextInt();
                    if (mised <= sold) {
                        sold = sold - mised;
                        System.out.print("Vous miser " + mised + "\n");
                        game();
                    } else {
                        System.out.print("Mise impossible car votre solde est trop faible\n");
                        System.out.print("votre sold actuelle est de " + sold + "\nCombien souhaitez-vous en ajouter ?\n");
                        int newSold = input.nextInt();
                        sold = sold + newSold;
                        System.out.print("Votre nouveau solde est de " + sold + "\n ");
                        Mise();
                    }
                } else {
                    Mise();
                }
            } else if (unique == 2) {
                Mise();
            }
            } else {
            System.out.print("Erreur: Mise innexistante\n");
            Mise();
            }
        } else if (begin == 2) {
            System.out.print("Vouse quitter La Roulette \n"+
                    "A Bien2tôt");
            return;
        }else{
            System.out.print("\n Erreur: Confirmation erroné \n");
            Mise();
        }
    }

    public static void game(){
        Scanner input = new Scanner(System.in);
        String[][] roul =  {{"1","rouge"},{"2","noir"},{"3","rouge"},{"4","noir"},{"5","rouge"},
                {"6","noir"},{"7","rouge"},{"8","noir"},{"9","rouge"},{"10","noir"},
                {"11","noir"},{"12","rouge"},{"13","noir"},{"14","rouge"},
                {"15","noir"},{"16","rouge"},{"17","noir"},{"18","rouge"},
                {"19","rouge"},{"20","noir"},{"21","rouge"},{"22","noir"},
                {"23","rouge"},{"24","noir"},{"25","rouge"},{"26","noir"},
                {"27","rouge"},{"28","noir"},{"29","noir"},{"30","rouge"},
                {"31","noir"},{"32","rouge"},{"33","noir"},{"34","rouge"},
                {"35","noir"},{"36","rouge"}};
        int low = 0;
        int high = 35;
        Random ran = new Random();
        int rand = ran.nextInt(high-low) + low;
        if (mise == 6) {
            int win_nbr = Integer.parseInt(roul[rand][0]);
            System.out.print(win_nbr + "\n");
            if (nb_unique == win_nbr){
                System.out.print(ANSI_GREEN + "Vous avez gagne \n" + ANSI_RESET);
                int sold_before = sold;
                sold = sold_before + (mised * 36);
                System.out.print("Votre solde explose est passe de " + sold_before + " à "+ sold + "\n");
                System.out.print("Voulez-vous rejouer? \n"  + ANSI_GREEN + " 1 - Oui "+ANSI_RESET+"/"+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
                int replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter La Roulette,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }
            }else {
                System.out.print(ANSI_RED + "Vous avez perdu\n"+ ANSI_RESET+
                        "Votre solde est à "+ sold + "\n" );
                System.out.print("Voulez-vous rejouer? \n"  + ANSI_GREEN + " 1 - Oui "+ANSI_RESET+"/"+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
                int replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter La Roulette,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }


            }
        }if (mise == 1) {
            String win_color = roul[rand][1];

            if (newcolor.equals(win_color)){
                if (win_color.equals("rouge")){
                    System.out.print(ANSI_RED+win_color + "\n");
                }
                System.out.print(ANSI_GREEN + "Vous avez gagne \n"+ ANSI_RESET);
                int sold_before = sold;
                sold = sold_before + (mised * 2);
                System.out.print("Votre solde est passé de " + sold_before + " à "+ sold + "\n");
                System.out.print("Voulez-vous rejouer? \n" + ANSI_GREEN + " 1 - Oui "+ANSI_RESET+"/"+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
                int replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter La Roulette,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }
            }else {
                if (win_color.equals("noir")){
                    System.out.print(ANSI_BLACK+win_color + "\n");
                }
                System.out.print(ANSI_RED + "Vous avez perdu\n"+ ANSI_RESET+
                        "Votre solde est à "+ sold + "\n");
                System.out.print("Voulez-vous rejouer? \n"  + ANSI_GREEN + " 1 - Oui "+ANSI_RESET+"/"+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
                int replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter La Roulette,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }
            }
        }if (mise == 2) {
            int nbr_rand = Integer.parseInt(roul[rand][0]);
            System.out.print(nbr_rand + "\n");
            if (nbr_rand % 2 == 0){
                System.out.print(ANSI_GREEN + "Vous avez gagne \n"+ ANSI_RESET);
                int sold_before = sold;
                sold = sold_before + (mised * 2);
                System.out.print("Votre solde est passé de " + sold_before + " à "+ sold + "\n");
                System.out.print("Voulez-vous rejouer? \n"  + ANSI_GREEN + " 1 - Oui "+ANSI_RESET+"/"+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
                int replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter La Roulette,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }
            }else {
                System.out.print(ANSI_RED + "Vous avez perdu\n"+ ANSI_RESET+
                        "Votre solde est à "+ sold + "\n");
                System.out.print("Voulez-vous rejouer? \n"  + ANSI_GREEN + " 1 - Oui "+ANSI_RESET+"/"+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
                int replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter La Roulette,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }
            }
        }if (mise == 3) {
            int nbr_rand = Integer.parseInt(roul[rand][0]);
            System.out.print(nbr_rand + "\n");
            if (nbr_rand % 2 != 0){
                System.out.print(ANSI_GREEN + "Vous avez gagne \n"+ ANSI_RESET);
                int sold_before = sold;
                sold = sold_before + (mised * 2);
                System.out.print("Votre solde est passé de " + sold_before + " à "+ sold + "\n");
                System.out.print("Voulez-vous rejouer? \n"  + ANSI_GREEN + " 1 - Oui "+ANSI_RESET+"/"+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
                int replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter La Roulette,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }
            }else {
                System.out.print(ANSI_RED + "Vous avez perdu\n"+ ANSI_RESET+
                        "Votre solde est à "+ sold + "\n");
                System.out.print("Voulez-vous rejouer? \n"  + ANSI_GREEN + " 1 - Oui "+ANSI_RESET+"/"+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
                int replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter La Roulette,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }
            }
        }if (mise == 4) {
            int nbr_rand = Integer.parseInt(roul[rand][0]);
            System.out.print(nbr_rand + "\n");
            if (0 <= nbr_rand && nbr_rand <= 18){
                System.out.print(ANSI_GREEN + "Vous avez gagne \n"+ ANSI_RESET);
                int sold_before = sold;
                sold = sold_before + (mised * 2);
                System.out.print("Votre solde est passé de " + sold_before + " à "+ sold + "\n");
                System.out.print("Voulez-vous rejouer? \n"  + ANSI_GREEN + " 1 - Oui "+ANSI_RESET+"/"+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
                int replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter La Roulette,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }
            }else {
                System.out.print(ANSI_RED+"Vous avez perdu\n"+ ANSI_RESET+
                        "Votre solde est à "+ sold + "\n");
                System.out.print("Voulez-vous rejouer? \n" + ANSI_GREEN + " 1 - Oui "+ANSI_RESET+"/"+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
                int replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter La Roulette,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }
            }
        }if (mise == 5) {
            int nbr_rand = Integer.parseInt(roul[rand][0]);
            System.out.print(nbr_rand + "\n");
            if (19 <= nbr_rand && nbr_rand <= 36){
                System.out.print(ANSI_GREEN + "Vous avez gagne \n"+ ANSI_RESET);
                int sold_before = sold;
                sold = sold_before + (mised * 2);
                System.out.print("Votre solde est passé de " + sold_before + " à "+ sold + "\n");
                System.out.print("Voulez-vous rejouer? \n" + ANSI_GREEN + " 1 - Oui "+ANSI_RESET+"/"+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
                int replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter La Roulette,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }

            }else {
                System.out.print(ANSI_RED + "Vous avez perdu\n"+ ANSI_RESET+
                        "Votre solde est à "+ sold + "\n");
                System.out.print("Voulez-vous rejouer? \n" + ANSI_GREEN + " 1 - Oui "+ANSI_RESET+"/"+ANSI_RED+" 2 - Non\n"+ANSI_RESET);
                int replay = input.nextInt();
                if (replay == 1){
                    Mise();
                } else if (replay == 2) {
                    System.out.print(
                            "Vous quitter La Roulette,\n"+
                                    "A bientôt\n");
                    Main.main(null);
                }
            }
        }

    }
}
