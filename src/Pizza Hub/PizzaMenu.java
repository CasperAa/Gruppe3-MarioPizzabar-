import java.util.ArrayList;


public class PizzaMenu {
    private String navn;
    private static ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();

    //Here the menu is printet
    public static void printPizzaMenu() {
        for (Pizza temp : pizzaMenu) {
                System.out.println(temp);
        }

    }
}

