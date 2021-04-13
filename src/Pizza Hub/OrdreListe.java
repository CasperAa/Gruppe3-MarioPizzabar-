import java.util.ArrayList;

public class OrdreListe {

    //Denne printer ikke det rigtige pizzanummer
public static void ordreListePrint(){
    int i = 1;
    for (ArrayList temp : Bestilling.ordrer){
        System.out.print(i + ". ordre: ");
        for (Object temp2 : temp){
            System.out.print("Nummer " + Pizza.getNummer() + ", ");
        }
        i++;
    }

}

}
