import java.util.ArrayList;

public class OrdreListe {

    public static void ordreListePrint(ArrayList <ArrayList> ordreListe){
        int i = 1;
        for (ArrayList ordre : ordreListe){
            System.out.println("Ordre nummer " + i + ": " + ordre);
            i++;
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
