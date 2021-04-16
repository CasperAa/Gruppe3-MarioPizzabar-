import java.util.ArrayList;
import java.util.Scanner;

public class OrdreListe {

    public static void ordreListePrint(ArrayList <ArrayList> ordreListe){
        if (!ordreListe.isEmpty()){
            PizzaMenu.printTilberedningsRækkefølge(ordreListe);
            } else {
            System.out.println("Der er ingen ordrer.");
        }
    }

    public static void sletOrdre(){
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        System.out.println("Indtast nummeret på den ordre, du vil slette.");

        if (!Bestilling.ordrer.isEmpty()){
            if (Bestilling.isNumeric(userInput) && Bestilling.ordrer.size() >= Integer.parseInt(userInput) && 0 < Integer.parseInt(userInput)) {
                Bestilling.ordrer.remove(Integer.parseInt(userInput)-1);
                System.out.println("Ordre nummer " + userInput + " er blevet slettet.");
            }
            else if (Bestilling.isNumeric(userInput) && Bestilling.ordrer.size() < Integer.parseInt(userInput) || 0 > Integer.parseInt(userInput)){
                System.out.println("Ordren findes ikke");
            }
            else {
                System.out.println("Input ikke forstået");
            }
        }
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
