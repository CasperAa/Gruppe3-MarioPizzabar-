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
    static ArrayList<ArrayList<Pizza>> alleOrdrer = new ArrayList<>();
    static ArrayList<ArrayList<Pizza>> færdiggjorteOrdrer = new ArrayList<>();
    static ArrayList<Integer> indkomst = new ArrayList<>();
    static int userPizzaInt;
    static Pizza tempPizza;
    static int ordrePris;

    public static void opretOrdre() {
        ArrayList<Pizza> igangværendeOrdre = new ArrayList<>();
        System.out.println("\nSkriv \"menu\" for at se menuen\nSkriv \"print\" for at se ordren\nSkriv \"slet\" for at redigere ordren\nSkriv \"done\" for at afslutte valg af Pizza\n"
                + "Indtast nummer (1 - " + pizzaMenu.size() + ")");
        Scanner userInput = new Scanner(System.in);
        while (true) {
            String userPizza = userInput.nextLine();
            if (userPizza.equalsIgnoreCase("done")) {
                DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                String Oprettelsestid = LocalDateTime.now().format(formatTime);
                System.out.println("Om hvor lang tid skal den hentes (indtastes i min.)?");
                userPizza = userInput.nextLine();
                if (isNumeric(userPizza) && Integer.parseInt(userPizza) > 0){
                    int userPizzaInt = Integer.parseInt(userPizza);
                    String Afhentningstid = LocalDateTime.now().plusMinutes(userPizzaInt).format(formatTime);
                    tempPizza = new Pizza(0, "Tid", "Tid", 0, "Tid", Oprettelsestid, Afhentningstid);
                    System.out.println(tempPizza.toString());
                } else {
                    System.out.println("Input ikke forstået");
                }
                if (!igangværendeOrdre.isEmpty()) {
                    System.out.println("Tryk 1: for levering - Ekstra gebyr på " + Kunde.getLeveringsgebyr() + " kr \nTryk 2: for afhentning");
                    ordrePris = totalPrice(igangværendeOrdre);
                    Kunde.kundeOplysninger();
                    igangværendeOrdre.add(tempPizza);
                    alleOrdrer.add(igangværendeOrdre);
                    System.out.println("Total: " + ordrePris + " kr");
                    System.out.println("Dato for oprettelse af ordre");
                    formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    System.out.println(LocalDateTime.now().format(formatTime));
                    System.out.println("Ordren er blevet oprettet!");
                } else {
                    System.out.println("Ordren blev ikke oprettet.");
                }
                break;
                //Nedenstående kører, hvis et pizzanummer indtastes
            } else if (isNumeric(userPizza) && pizzaMenu.size() >= Integer.parseInt(userPizza) && 0 < Integer.parseInt(userPizza)) {
                userPizzaInt = Integer.parseInt(userPizza);
                tempPizza = pizzaMenu.get(userPizzaInt - 1);

                EkstraIngredienser.familiePizza(userPizzaInt); //Her ændres type (standard/familie), og der tilføjes ingredienser samt kommentar.
                //TempPizza tilføjes til ordren
                igangværendeOrdre.add(tempPizza);

                //Printer forskellige beskeder afhængig af typen af pizzaen
                if (!pizzaMenu.get(userPizzaInt - 1).getKategori().contains("Sandwich")) {
                    System.out.println("Pizza nr. " + userPizzaInt + " er blevet tilføjet til ordren.");
                } else {
                    System.out.println("Sandwich nr. " + userPizzaInt + " er blevet tilføjet til ordren.");
                }
                System.out.println(ProgramMenu.printItemAddedToOrderMessage());
            } else if (userPizza.equalsIgnoreCase("print") && !igangværendeOrdre.isEmpty()) {
                System.out.println("Bestilling:");
                for (Pizza temp : igangværendeOrdre) {
                    System.out.println(temp);
                }
                System.out.println(ProgramMenu.printItemAddedToOrderMessage());
            } else if (userPizza.equalsIgnoreCase("print") && igangværendeOrdre.isEmpty()) {
                System.out.println("Ordren er tom.");
                System.out.println(ProgramMenu.printItemAddedToOrderMessage());
            } else if (userPizza.equalsIgnoreCase("menu")) {

                //Print pizza menu
                PizzaMenu.printPizzaMenu();
                System.out.println(ProgramMenu.printItemAddedToOrderMessage());
            } else if (userPizza.equalsIgnoreCase("slet")) {

                //Slet pizza fra ordre
                if (!igangværendeOrdre.isEmpty()) {
                    System.out.println("Bestilling:");
                    int i = 1;
                    for (Pizza temp : igangværendeOrdre) {
                        System.out.println("ID " + i + " - " + temp);
                        i++;
                    }
                    //Fjerner en pizza fra ordre
                    System.out.println("Indtast ID'et på den pizza, du ønsker at slette. Indtast \"slut\" for at afslutte.");
                    userPizza = userInput.nextLine();
                    if (isNumeric(userPizza) && igangværendeOrdre.size() >= Integer.parseInt(userPizza) && 0 < Integer.parseInt(userPizza)) {
                        igangværendeOrdre.remove(Integer.parseInt(userPizza) - 1);
                        System.out.println("Pizzaen med ID " + userPizza + " er blevet slettet fra ordren.");
                        if (!igangværendeOrdre.isEmpty()) {
                            System.out.println("Opdateret ordre:");
                            for (Pizza temp : igangværendeOrdre) {
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
                System.out.println(ProgramMenu.printItemAddedToOrderMessage());
            } else {
                System.out.println("Findes ikke i menuen, prøv igen.");
            }
        }
    }
    /*
       public static List showTime(int input) {
        List<String> sortBytime = new ArrayList<>();
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        Collections.sort(sortBytime);
        sortBytime.add("Ordreoprettelse: " + Bestilling.alleOrdrer.get(input).get(Bestilling.alleOrdrer.get(input).size()-1).getTopping() + " " + "Afhentningstid: " + Bestilling.alleOrdrer.get(input).get(Bestilling.alleOrdrer.get(input).size()-1).getKommentar());
        System.out.println(sortBytime);

        return sortBytime;
    }
*/
    public static void printTime(int input) {
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println("Ordreoprettelse: " + Bestilling.alleOrdrer.get(input).get(Bestilling.alleOrdrer.get(input).size()-1).getTopping() + " " + "Afhentningstid: " + Bestilling.alleOrdrer.get(input).get(Bestilling.alleOrdrer.get(input).size()-1).getKommentar());
    }

    public static void sortByTime(int input) {

    }


    @Override
    public String toString(){
        return alleOrdrer.toString().toUpperCase();
    }

    public static ArrayList<ArrayList<Pizza>> getAlleOrdrer() {
        return alleOrdrer;
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

    /*
    public static ArrayList<Integer> getPizzaStatistik() {
        return pizzaStatistik;
    }

     */


}
