import java.util.ArrayList;
import java.util.Scanner;

public class OrdreListe {

    public static void ordreListePrint(ArrayList <ArrayList> ordreListe){
        int i = 1;
        if (!ordreListe.isEmpty()){
            for (ArrayList ordre : ordreListe){
                System.out.println("Ordre nummer " + i + ": " + ordre);
                i++;
            }
        } else if (ordreListe.isEmpty()){
            System.out.println("Der er ingen ordrer.");
        }

    }

    public static void sletOrdre(){
        System.out.println("Indtast nummeret på den ordre, du vil slette.");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        if (Bestilling.isNumeric(userInput) && Bestilling.ordrer.size() >= Integer.parseInt(userInput) && 0 < Integer.parseInt(userInput)) {
            Bestilling.ordrer.remove(Integer.parseInt(userInput)-1);
            System.out.println("Ordre nummer " + userInput + " er blevet slettet.");
        }
        else if (Bestilling.isNumeric(userInput) && Bestilling.ordrer.size() < Integer.parseInt(userInput) && 0 > Integer.parseInt(userInput)){
            System.out.println("Ordren findes ikke");
        }
        else {
            System.out.println("Input ikke forstået");
        }
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
