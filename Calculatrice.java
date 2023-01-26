package Calc;
import Calc.Main;

import java.util.Scanner;

public class Calculatrice {

    public static void main(String[] args) {
        Calc();
    }


    public static void Calc(){
        Scanner input = new Scanner(System.in);
        System.out.print("Quel calcule souhaiter vous faire ? \n" +
                "1 - Addition\n" +
                "2 - Soustraction\n" +
                "3 - Multiplication\n" +
                "4 - Division\n" +
                "5 - Factorielle\n");

        int calc = input.nextInt();

        if (calc == 1){
            System.out.print("definir un premier nombre: ");
            int number1 = input.nextInt();
            System.out.print("definir un second nombre: ");
            int number2 = input.nextInt();
            sum(number1,number2);

        } else if (calc == 2) {
            System.out.print("definir un premier nombre: ");
            int number3 = input.nextInt();
            System.out.print("definir un second nombre: ");
            int number4 = input.nextInt();
            substract(number3, number4);
        } else if (calc == 3) {
            System.out.print("definir un premier nombre: ");
            int number5 = input.nextInt();
            System.out.print("definir un second nombre: ");
            int number6 = input.nextInt();
            multiply(number5, number6);

        } else if (calc == 4) {
            System.out.print("definir un premier nombre: ");
            int number7 = input.nextInt();
            System.out.print("definir un second nombre: ");
            int number8 = input.nextInt();
            divide(number7, number8);

        } else if (calc == 5) {
            System.out.print("definir un premier nombre: ");
            int number9 = input.nextInt();
            factorial(number9);
        } else{
            System.out.print("Exercice inexistant \n");
            newCalc();
        }
    }




    public static void sum(int number1, int number2){

        int result = number1 + number2;
        System.out.print("Le résultat de la somme de " + number1 + " et de " + number2 + " est " + result +"\n");
        newCalc();
    }

    public static void multiply(int number1, int number2){
        int result = number1 * number2;
        System.out.print("Le résultat de la multiplication de " + number1 + " et de " + number2 + " est " + result +"\n");
        newCalc();
    }

    public static void divide(int number1, int number2){
        int result = number1 / number2;
        System.out.print("Le résultat de la division de " + number1 + " et de " + number2 + " est " + result +"\n");
        newCalc();
    }

    public static void substract(int number1, int number2){
        int result = number1 - number2;
        System.out.print("Le résultat de la soustraction de " + number1 + " et de " + number2 + " est " + result +"\n");
        newCalc();
    }

    public static void factorial(int number1){
        int i=1, fact = 1;
        int number = number1;
        while(i <= number){
            fact =  fact * i ;
            i+=1;
        }
        int result = fact;

        System.out.print("Le résultat de la factoriel de " + number1  + " et " + result +"\n");
        newCalc();
    }

    public static void newCalc(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voulez-vous faire un autre calcule ? \n");
        String again = input.nextLine();
        if (again.equals("oui")){
            Calc();
        }
        else {
            Main.main(null);
        }
    }
}


