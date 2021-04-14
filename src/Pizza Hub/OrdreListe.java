import java.util.ArrayList;
import java.util.Scanner;

public class OrdreListe {

    public static void ordreListePrint(ArrayList <ArrayList> ordreListe){
        int i = 1;
        for (ArrayList ordre : ordreListe){
            System.out.println("Ordre nummer " + i + ": " + ordre);
            i++;
        }
    }

    public static void sletOrdre(){
        System.out.println("Indtast nummeret på den ordre, du vil slette:");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();
        Bestilling.ordrer.remove(userInput);
        System.out.println("Ordre nummer " + userInput + "er blevet slettet.");
    }


    //Denne printer ikke det rigtige pizzanummer
/*
public static void ordreListePrint(ArrayList <Pizza> ordreListe){
    for (Pizza pizza : ordreListe){
        System.out.println(pizza.getNummer());
    }
}

 */

}
