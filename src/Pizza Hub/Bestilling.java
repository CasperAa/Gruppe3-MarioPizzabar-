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
    static ArrayList<Pizza> pizzaOrder = new ArrayList<Pizza>();
    static int userPizzaInt;
    static int orderPrice;
    static int pizzaPrice;
    static Pizza tempPizza;
    static int ordrePris;

    public static void opretOrdre() {


        System.out.println("\nIndtast pizzanummer 1-" + pizzaMenu.size() + "\nSkriv \"menu\" for at se menuen\nSkriv \"print\" for at se ordren\nSkriv \"slet\" for at redigere ordren\nSkriv \"done\" for at afslutte valg af Pizza");
        boolean endOrder = true;
        Scanner userInput = new Scanner(System.in);
        while (endOrder == true) {
            String userPizza = userInput.nextLine();
            if (userPizza.toLowerCase().equals("done")) {
                if (!pizzaOrder.isEmpty()) {
                    System.out.println("Tast \"1\" for levering \nTast \"2\" for afhentning");
                    ordrer.add(pizzaOrder);
                    ordrePris = totalPrice(pizzaOrder);
                    Kunde.kundeOplysninger();
                    indkomst.add(ordrePris);
                    System.out.println("Total: " + ordrePris + " kr.");
                    System.out.println("Valg af pizza afsluttet.");
                    endOrder = false;
                    break;
                } else if (pizzaOrder.isEmpty()){
                    System.out.println("Ingen ordre blev oprettet.");
                    endOrder = false;
                    break;
                }
                //Nedenstående kører, hvis et pizzanummer indtastes
            } else if (isNumeric(userPizza) && pizzaMenu.size() >= Integer.parseInt(userPizza) && 0 < Integer.parseInt(userPizza)) {
                userPizzaInt = Integer.parseInt(userPizza);
                pizzaStatistik.add(userPizzaInt);
                tempPizza = pizzaMenu.get(userPizzaInt-1); //En midlertidig pizza oprettes, så denne kan ændres
                //pizzaOrder.add(pizzaMenu.get(userPizzaInt-1)); //Denne kode skal ikke bruges i det nye system
                EkstraIngredienser.familiePizza(userPizzaInt);
                pizzaOrder.add(tempPizza);
                System.out.println("Pizza " + userPizzaInt + " er blevet tilføjet");
                System.out.println("\nIndtast nummer 1-" + pizzaMenu.size() + " for at tilføje.");
            } else if (userPizza.toLowerCase().equals("print") && !pizzaOrder.isEmpty()) {
                System.out.println("Bestilling:");
                for (Pizza temp : pizzaOrder) {
                    System.out.println(temp);
                }
                System.out.println("\nIndtast nummer 1-" + pizzaMenu.size() + " for at tilføje.");
            } else if (userPizza.toLowerCase().equals("print") && pizzaOrder.isEmpty()) {
                System.out.println("Ordren er tom.");
                System.out.println("\nIndtast pizzanummer 1-" + pizzaMenu.size() + " for at tilføje.");
            } else if (userPizza.toLowerCase().equals("menu")) {
                PizzaMenu.printPizzaMenu();
                System.out.println("\nIndtast pizzanummer 1-" + pizzaMenu.size() + " for at tilføje.");
            } else if (userPizza.toLowerCase().equals("slet")){
                if (!pizzaOrder.isEmpty()){
                    System.out.println("Bestilling:");
                    int i = 1;
                    for (Pizza temp : pizzaOrder) {
                        System.out.println("ID " + i + " - " + temp);
                        i++;
                    }
                    System.out.println("Indtast ID'et på den pizza, du ønsker at slette. Indtast \"slut\" for at afslutte.");
                    userPizza = userInput.nextLine();
                    if (isNumeric(userPizza) && pizzaOrder.size() >= Integer.parseInt(userPizza) && 0 < Integer.parseInt(userPizza)){
                        pizzaOrder.remove(Integer.parseInt(userPizza)-1);
                        System.out.println("Pizzaen med ID " + userPizza + " er blevet slettet");
                        if (!pizzaOrder.isEmpty()) {
                            System.out.println("Opdateret bestilling:");
                            for (Pizza temp : pizzaOrder) {
                                System.out.println(temp);
                            }
                        } else if (pizzaOrder.isEmpty()){
                            System.out.println("Ordren er tom.");
                        }

                    } else if (userPizza.equals("slut")) {
                        System.out.println("Ingen pizzaer er blevet slettet.");
                    } else {
                        System.out.println("Input ikke forstået.");
                    }
                    System.out.println("\nIndtast pizzanummer 1-" + pizzaMenu.size() + " for at tilføje.");
                } else if(pizzaOrder.isEmpty()){
                    System.out.println("Ordren er tom.");
                    System.out.println("\nIndtast pizzanummer 1-" + pizzaMenu.size() + " for at tilføje.");
                }
            } else {
                System.out.println("Pizzaen findes ikke, prøv igen.");
            }
        }
    }

/*
    public static void RedigerUfærdigOrdre() {
        System.out.println("Bestilling:");
        for (Pizza temp : pizzaOrder) {
            System.out.println(temp);
        }
        System.out.println("Indtast nummeret på den pizza, du ønsker at slette");
        Scanner userInput = new Scanner(System.in);
        String userPizza = userInput.nextLine();
        if (isNumeric(userPizza) && ordrer.size() >= Integer.parseInt(userPizza) && 0 < Integer.parseInt(userPizza)){
            ordrer.remove(userPizza);
            System.out.println("");
        } else {
            System.out.println("Input ikke forstået");
        }

 */



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
