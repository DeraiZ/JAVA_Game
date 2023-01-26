package Calc;

import java.util.*;

public class Blackjack {

    public static int sold = 1000;
    public static int mise;
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static String[] yourhand;
    public static String[] yourhandpoint;
    public static String[] croupierhandpoint;
    public static String[] croupier;
    public static List<String> cardList;
    public static void main(String[] args) {
        Hello();
        Rule();
        Mise();
    }

    public static void Hello(){
        Scanner input = new Scanner(System.in);
        System.out.print("Qui etes vous ?\n");
        String name = input.nextLine();
        System.out.print("Bonjour "+ name +"\n"+
                "Binevenue au Blackjack\n");
    }

    public static void Rule(){
        System.out.print(ANSI_CYAN + "- Au départ vous devrez miser un partie de votre argent !\n" +
                "- Le croupier donneras deux cartes au joueur, et ensuite se distribueras 2 cartes\n" +
                "- Chaque cartes valent le prix de la valeur cette dernière\n" +
                "- Les têtes valent 10\n" +
                "- L'As vaut 11 ou 1 :\n" +
                "- Le joueur choisi\n" +
                "- Le croupier n’a qu’un seul As qui vaut 11.\n" +
                "- Si le joueur atteint 21 sans le dépasser il fait BlackJack, dans ce cas si le croupier dépasse ou n'atteint pas 21, il multiplie sa mise par 3\n" +
                "- Dans les autres cas le joueur doit dépasser dépasser le score du croupier sans dépasser 21, Si il y arrive il multiplie sa mise par 2\n" +
                "- Le croupier continuera de tirer des cartes tant qu'il n'aura pas atteint 17\n" +
                "- Le jeu de carte est mélangé avant chaque début de partie.\n" +
                "- Le joueur à plusieurs possibilités :\n" +
                "- Tirer un carte\n" +
                "- Rester\n" +
                "- Abandonner (il récupère la moitié de sa mise et une nouvelle partie peut se lancer)"+ ANSI_RESET);
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

    public static void Game(){
        String[][] card = {{"1","11",ANSI_RED+"as♥"+ANSI_RESET},{"2",ANSI_RED+"2♥"+ANSI_RESET},{"3",ANSI_RED+"3♥"+ANSI_RESET},{"4",ANSI_RED+"4♥"+ANSI_RESET},{"5",ANSI_RED+"5♥"+ANSI_RESET},{"6",ANSI_RED+"6♥"+ANSI_RESET},{"7",ANSI_RED+"7♥"+ANSI_RESET},{"8",ANSI_RED+"8♥"+ANSI_RESET}, {"9",ANSI_RED+"9♥"+ANSI_RESET},{"10",ANSI_RED+"10♥"+ANSI_RESET},{"10",ANSI_RED+"Valet♥"+ANSI_RESET},{"10",ANSI_RED+"Dame♥"+ANSI_RESET},{"10",ANSI_RED+"Roi♥"+ANSI_RESET},
                {"1","11",ANSI_RED+"as♦"+ANSI_RESET},{"2",ANSI_RED+"2♦"+ANSI_RESET},{"3",ANSI_RED+"3♦"+ANSI_RESET},{"4",ANSI_RED+"4♦"+ANSI_RESET},{"5",ANSI_RED+"5♦"+ANSI_RESET},{"6",ANSI_RED+"6♦"+ANSI_RESET},{"7",ANSI_RED+"7♦"+ANSI_RESET},{"8",ANSI_RED+ANSI_RED+"8♦"+ANSI_RESET}, {"9",ANSI_RED+"9♦"+ANSI_RESET},{"10",ANSI_RED+"10♦"+ANSI_RESET},{"10",ANSI_RED+"Valet♦"+ANSI_RESET},{"10",ANSI_RED+"Dame♦"+ANSI_RESET},{"10",ANSI_RED+"Roi♦"+ANSI_RESET},
                {"1","11",ANSI_CYAN+"as♣"+ANSI_RESET},{"2",ANSI_CYAN+"2♣"+ANSI_RESET},{"3",ANSI_CYAN+"3♣"+ANSI_RESET},{"4",ANSI_CYAN+"4♣"+ANSI_RESET},{"5",ANSI_CYAN+"5♣"+ANSI_RESET},{"6",ANSI_CYAN+"6♣"+ANSI_RESET},{"7",ANSI_CYAN+"7♣"+ANSI_RESET},{"8",ANSI_CYAN+"8♣"+ANSI_RESET}, {"9",ANSI_CYAN+"9♣"+ANSI_RESET},{"10",ANSI_CYAN+"10♣"+ANSI_RESET},{"10",ANSI_CYAN+"Valet♣"+ANSI_RESET},{"10",ANSI_CYAN+"Dame♣"+ANSI_RESET},{"10",ANSI_CYAN+"Roi♣"+ANSI_RESET},
                {"1","11",ANSI_CYAN+"as♠"+ANSI_RESET},{"2",ANSI_CYAN+"2♠"+ANSI_RESET},{"3",ANSI_CYAN+"3♠"+ANSI_RESET},{"4",ANSI_CYAN+"4♠"+ANSI_RESET},{"5",ANSI_CYAN+"5♠"+ANSI_RESET},{"6",ANSI_CYAN+"6♠"+ANSI_RESET},{"7",ANSI_CYAN+"7♠"+ANSI_RESET},{"8",ANSI_CYAN+"8♠"+ANSI_RESET}, {"9",ANSI_CYAN+"9♠"+ANSI_RESET},{"10",ANSI_CYAN+"10♠"+ANSI_RESET},{"10",ANSI_CYAN+"Valet♠"+ANSI_RESET},{"10",ANSI_CYAN+"Dame♠"+ANSI_RESET},{"10",ANSI_CYAN+"Roi♠"+ANSI_RESET}};

        Collections.shuffle(Arrays.asList(card));



        yourhand = new String[]{card[0][1], card[2][1]};
        yourhandpoint = new String[]{card[0][0], card[2][0]};
        String firstCard = yourhand[0];
        String secondCard = yourhand[1];
        int yourpoint = Integer.parseInt(yourhandpoint[0]) + Integer.parseInt(yourhandpoint[1]);
        System.out.println("votre main est: " + firstCard + " " + secondCard + "\n"+
                "Votre score est de: " + yourpoint);
        croupier = new String[]{card[1][1], card[3][1]};
        String croupierFirstCard = croupier[0];
        String croupierSecondCard = croupier[1];
        croupierhandpoint = new String[]{card[1][0], card[3][0]};
        int croupierpoint = Integer.parseInt(croupierhandpoint[0]) + Integer.parseInt(croupierhandpoint[1]);
        System.out.println("La main du croupier est: " +  croupierFirstCard+ " " + croupierSecondCard + "\n" +
                "Le score du croupier est de: " + croupierpoint);

    }


}
