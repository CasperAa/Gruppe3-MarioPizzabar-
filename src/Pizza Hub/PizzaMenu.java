import java.util.ArrayList;
import java.util.Collections;


public class PizzaMenu {
    private static final ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();
    private static final ArrayList<EkstraIngredienser> ingredienserListe = EkstraIngredienser.getIngredienseListe();
    static ArrayList<ArrayList<Pizza>> sorteredeOrdrer = new ArrayList<ArrayList<Pizza>>();

    //Pizza menuen er printet
    public static void printPizzaMenu() {
        for (Pizza temp : pizzaMenu) {
                System.out.println(temp);
            }
        }

    //Tilberednings rækkefølgen er printet
    public static void printTilberedningsRækkefølge(ArrayList<ArrayList<Pizza>> alleOrdrerIListe){
        int i = 1;
        int j = 0;
        for( ArrayList<Pizza> ordre : alleOrdrerIListe){
            System.out.println("Ordre nr. " + i );
            Bestilling.printTime(j);
            i++;
            j++;
            for(Pizza tingIOrdre : ordre) { //Denne skal ændres, så tidspizzaen printes for sig på en logisk måde
                System.out.println("    Nummer: " + tingIOrdre.toString() +" "+ tingIOrdre.getClass().getTypeName());
            }
        }
    }

    /*
    public static void sorterTilberedningsrækkefølge(ArrayList<ArrayList<Pizza>> alleOrdrerIListe){
        int i = 1;
        int j = 0;

        for( ArrayList<Pizza> ordre : alleOrdrerIListe){
            System.out.println("Ordre nr. " + i );
            Bestilling.SortbyTime(j);
            i++;
            j++;
            for(Pizza tingIOrdre : ordre) { //Denne skal ændres, så tidspizzaen printes for sig på en logisk måde
                System.out.println("    Nummer: " + tingIOrdre.toString() +" "+ tingIOrdre.getClass().getTypeName());
            }
        }
    }

     */


    //Ekster ingredienser er printet
    public static void printStandardEkstraIngredienser() {
        for (EkstraIngredienser ingrediens : ingredienserListe) {
            System.out.println( ingrediens.getNummer() +": " + ingrediens.getNavn() + "..... " + ingrediens.getAlm_pris() +" kr");
        }
    }
    public static void printFamilieEkstraIngredienser() {
        for (EkstraIngredienser ingrediens : ingredienserListe) {
            System.out.println(ingrediens.getNummer() +": " + ingrediens.getNavn() + "..... " + ingrediens.getFam_pris() +" kr");
        }
    }





}

