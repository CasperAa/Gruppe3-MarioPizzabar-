import java.util.ArrayList;
import java.util.Scanner;

public class Bestilling {

    private int samletPris;
    private double bestillingsTidspunkt;
    private boolean levering;
    private boolean status;
    private int antalPizza;
    static ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();
    static ArrayList<ArrayList> ordrer = new ArrayList<ArrayList>();
    static ArrayList<Integer> indkomst = new ArrayList<Integer>();
    static ArrayList<Integer> pizzaStatistik = new ArrayList<Integer>();
    static int userPizzaInt;


    public static void opretOrdre() {

        System.out.println("\nIndtast pizzanummer \nSkrive \"menu\" for at se menuen\nSkriv print for at se ordren\nSkriv \"done\" for at afslutte valg a Pizza: 1-" + pizzaMenu.size());
        boolean endOrder = true;

        Scanner userInput = new Scanner(System.in);
        ArrayList<Pizza> pizzaOrder = new ArrayList<Pizza>();
        while (endOrder == true) {
            String userPizza = userInput.nextLine();
            if (userPizza.toLowerCase().equals("done")) {
                if (!pizzaOrder.isEmpty()) {
                    ordrer.add(pizzaOrder);
                    indkomst.add(totalPrice(pizzaOrder));
                }
                endOrder = false;
                System.out.println("Total: " + totalPrice(pizzaOrder) + " kr.");
                System.out.println("Valg af pizza afsluttet");
                break;
            } else if (isNumeric(userPizza) && pizzaMenu.size() >= Integer.parseInt(userPizza) && 0 < Integer.parseInt(userPizza)) {
                userPizzaInt = Integer.parseInt(userPizza);
                pizzaStatistik.add(userPizzaInt);
                pizzaOrder.add(pizzaMenu.get(userPizzaInt-1));
                System.out.println("Pizza " + userPizzaInt + " er blevet tilføjet");
            } else if (userPizza.toLowerCase().equals("print")) {
                System.out.println("Bestilling:");
                for (Pizza temp : pizzaOrder) {
                    System.out.println(temp);
                }
            } else if (userPizza.toLowerCase().equals("menu")) {
                PizzaMenu.printPizzaMenu();
            } else {
                System.out.println("Pizzaen findes ikke, prøv igen");
            }
        } Kunde.kundeOplysninger();
    }

    public static ArrayList<ArrayList> getOrdrer() {
        return ordrer;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static int totalPrice(ArrayList<Pizza> array) {
        int totalpris = 0;
        for (Pizza temp : array) {
            totalpris += temp.getPris();
        }
        return totalpris;
    }

    public static ArrayList<Integer> getIndkomst() {
        return indkomst;
    }

    public static ArrayList<Integer> getPizzaStatistik() {
        return pizzaStatistik;
    }
}

/*
if (pizzaOrder.isEmpty() == false){
                        ordrer.add(pizzaOrder);
                    }
 */
