import java.util.ArrayList;


public class PizzaMenu {
    private static final ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();
    private static final ArrayList<EkstraIngredienser> ingredienserListe = EkstraIngredienser.getIngredienseListe();


    //Here the menu is printed
    public static void printPizzaMenu() {
        for (Pizza temp : pizzaMenu) {
                System.out.println(temp);
            }
        }

    //Here the extra ingredients are printed
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

