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
    public static void printTilberedningsRækkefølge(ArrayList<ArrayList<Pizza>> ordreListe){
        int i = 1;
        for( ArrayList<Pizza> ordre : ordreListe){
            System.out.println("Ordre nr. " + i );
            i++;
            for(Pizza tingIOrdre : ordre) { //Denne skal ændres, så tidspizzaen printes for sig på en logisk måde
                System.out.println("    Nummer: " + tingIOrdre.toString() +" "+ tingIOrdre.getClass().getTypeName());
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

