import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Bestilling {

    /*
    private int samletPris;
    private double bestillingsTidspunkt;
    private boolean levering;
    private boolean status;
    private int antalPizza;
    static int orderPrice;
    static int pizzaPrice;
     */
    static ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();
    static ArrayList<ArrayList> ordrer = new ArrayList<>();
    static ArrayList<Integer> indkomst = new ArrayList<Integer>();
    static ArrayList<Integer> pizzaStatistik = new ArrayList<Integer>();
    static ArrayList<Pizza> pizzaOrder = new ArrayList<Pizza>();
    static int userPizzaInt;
    static Pizza tempPizza;
    static int ordrePris;

    public static void opretOrdre() {


        System.out.println("\nSkriv \"menu\" for at se menuen\nSkriv \"print\" for at se ordren\nSkriv \"slet\" for at redigere ordren\nSkriv \"done\" for at afslutte valg af Pizza\n"
                            + "Indtast nummer (1 - " + pizzaMenu.size() + ")");
        Scanner userInput = new Scanner(System.in);
        while (true) {
            String userPizza = userInput.nextLine();
            if (userPizza.equalsIgnoreCase("done")) {
                leveringsMetode(userPizza);
                break;
                //Nedenstående kører, hvis et pizzanummer indtastes
            } else if (isNumeric(userPizza) && pizzaMenu.size() >= Integer.parseInt(userPizza) && 0 < Integer.parseInt(userPizza)) {
                tilføjPizzaTilOrdre(userPizza);
            } else if (userPizza.equalsIgnoreCase("print") && !pizzaOrder.isEmpty()) {
                System.out.println("Bestilling:");
                for (Pizza temp : pizzaOrder) {
                    System.out.println(temp);
                }
                System.out.println(ProgramMenu.printItemAddedToOrderMessage());
            } else if (userPizza.equalsIgnoreCase("print") && pizzaOrder.isEmpty()) {
                System.out.println("Ordren er tom.");
                System.out.println(ProgramMenu.printItemAddedToOrderMessage());
            } else if (userPizza.equalsIgnoreCase("menu")) {

                //Print pizza menu
                PizzaMenu.printPizzaMenu();
                System.out.println(ProgramMenu.printItemAddedToOrderMessage());
            } else if (userPizza.equalsIgnoreCase("slet")){

                //Slet pizza fra ordre
                sletPizzaINuværendeOrdre(userPizza,userInput);
                System.out.println(ProgramMenu.printItemAddedToOrderMessage());
            }  else {
                System.out.println("Findes ikke i menuen, prøv igen.");
            }
        }
    }

    public static void leveringsMetode(String userPizza){
        if (!pizzaOrder.isEmpty()) {
            System.out.println("Tryk 1: for levering - Ekstra gebyr på " +Kunde.getLeveringsgebyr() + " kr \nTryk 2: for afhentning");
            ordrer.add(pizzaOrder);
            ordrePris = totalPrice(pizzaOrder);
            Kunde.kundeOplysninger();
            indkomst.add(ordrePris);
            System.out.println("Total: " + ordrePris +" kr");
            System.out.println("Dato for oprettelse af ordre");
            DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            System.out.println(LocalDateTime.now().format(formatTime));

            System.out.println("Ordren er blevet oprettet!");
        } else {
            System.out.println("Ordren blev ikke oprettet.");
        }
    }
    public static void tilføjPizzaTilOrdre(String userPizza){
        userPizzaInt = Integer.parseInt(userPizza);
        pizzaStatistik.add(userPizzaInt);
        tempPizza = pizzaMenu.get(userPizzaInt-1);

        EkstraIngredienser.familiePizza(userPizzaInt);
        //TempPizza tilføjes til ordren
        pizzaOrder.add(tempPizza);

        //Printer forskellige beskeder afhængig af typen af pizzaen
        if (!pizzaMenu.get(userPizzaInt-1).getKategori().contains("Sandwich") ){
            System.out.println("Pizza nr. " + userPizzaInt + " er blevet tilføjet til ordren.");
        } else {
            System.out.println("Sandwich nr. " + userPizzaInt + " er blevet tilføjet til ordren.");
        }
        System.out.println(ProgramMenu.printItemAddedToOrderMessage());
    }
    public static void sletPizzaINuværendeOrdre(String userPizza, Scanner userInput){
        if (!pizzaOrder.isEmpty()){
            System.out.println("Bestilling:");
            int i = 1;
            for (Pizza temp : pizzaOrder) {
                System.out.println("ID " + i + " - " + temp);
                i++;
            }
            //Fjerner en pizza fra ordre
            System.out.println("Indtast ID'et på den pizza, du ønsker at slette. Indtast \"slut\" for at afslutte.");
            userPizza = userInput.nextLine();
            if (isNumeric(userPizza) && pizzaOrder.size() >= Integer.parseInt(userPizza) && 0 < Integer.parseInt(userPizza)){
                pizzaOrder.remove(Integer.parseInt(userPizza)-1);
                System.out.println("Pizzaen med ID " + userPizza + " er blevet slettet fra ordren.");
                if (!pizzaOrder.isEmpty()) {
                    System.out.println("Opdateret ordre:");
                    for (Pizza temp : pizzaOrder) {
                        System.out.println(temp);
                    }
                } else {
                    System.out.println("Ordren er tom.");
                }
            } else if (userPizza.equals("slut")) {
                System.out.println("Ingen pizzaer er blevet slettet.");
            } else {
                System.out.println("Input ikke forstået.");
            }
        } else {
            System.out.println("Ordren er tom.");
        }
    }

    @Override
    public String toString(){
        return ordrer.toString().toUpperCase();
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
