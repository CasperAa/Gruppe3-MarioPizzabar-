import java.util.ArrayList;


public class PizzaMenu {
    private static ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();
    private static ArrayList<EkstraIngredienser> ingredienserListe = EkstraIngredienser.getIngredienseListe();


    //Here the menu is printed
    public static void printPizzaMenu() {
        for (Pizza temp : pizzaMenu) {
                System.out.println(temp);
            }
        }

    //Here the extra ingredients are printed
    public static void printEkstraIngredienser() {
        for (EkstraIngredienser ingrediens : ingredienserListe) {
            System.out.println(ingrediens);
        }
    }
}

