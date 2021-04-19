import java.util.ArrayList;

public class PizzaMenu {
    private static final ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();
    private static final ArrayList<EkstraIngredienser> ingredienserListe = EkstraIngredienser.getIngredienseListe();

    //Pizza menuen er printet
    public static void printPizzaMenu() {
        for (Pizza temp : pizzaMenu) {
                System.out.println(temp);
            }
        }

    //Tilberednings rækkefølgen er printet
    public static void printTilberedningsRækkefølge(ArrayList<ArrayList<Pizza>> alleOrdre){
        int i = 1;
        for(ArrayList<Pizza> ordre : alleOrdre){
            System.out.println("\nOrdre nr. " + i );
            Bestilling.SortbyTime();

            i++;
            for(Pizza tingIOrdre : ordre) { //Denne skal ændres, så tidspizzaen printes for sig på en logisk måde
                System.out.println("    Nummer: " + tingIOrdre);
            }
        }
    }

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

