import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Bestilling {
    static ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();
    static ArrayList<ArrayList<Pizza>> alleOrdrer = new ArrayList<>();
    static ArrayList<ArrayList<Pizza>> færdiggjorteOrdrer = new ArrayList<>();
    static ArrayList<Integer> indkomst = new ArrayList<>();
    static int userPizzaInt;
    static Pizza tempPizza;
    static int ordrePris;
    static Pizza kundePizza;
    static Pizza tidspizza;

    public static void opretOrdre() {
        ArrayList<Pizza> igangværendeOrdre = new ArrayList<>();
        System.out.println("\nSkriv \"menu\" for at se menuen" +
                "\nSkriv \"print\" for at se ordren" +
                "\nSkriv \"slet\" for at redigere ordren" +
                "\nSkriv \"done\" for at afslutte valg af Pizza" +
                "\nIndtast nummer (1 - " + pizzaMenu.size() + ")");
        Scanner userInput = new Scanner(System.in);
        while (true) {
            String userPizza = userInput.nextLine();

                //Nedenstående kører, hvis brugeren ønsker at afslutte bestillingen (input er "done")
            if (userPizza.equalsIgnoreCase("done")) {
                DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                String Oprettelsestid = LocalDateTime.now().format(formatTime);
                if (!igangværendeOrdre.isEmpty()) {
                    System.out.println("Tryk 1: for levering - Ekstra gebyr på " + Kunde.getLeveringsgebyr() + " kr. " +
                            "\nTryk 2: for afhentning");
                    ordrePris = totalPrice(igangværendeOrdre);
                    tidspizza = new Pizza(0, "", "Tid", 0, "Tid", "",
                            "\" \"");
                    kundePizza = new Pizza(0, "", "Kunde", 0, "", "",
                            "\" \"");
                    Kunde.kundeOplysninger();
                    System.out.println("Ordreoversigt: ");
                    for (Pizza s : igangværendeOrdre) {
                        System.out.println(s.toString().replaceAll("\\[|\\]", ""));
                    }
                    igangværendeOrdre.add(kundePizza);
                    alleOrdrer.add(igangværendeOrdre);
                    System.out.println("Total: " + ordrePris + " kr.");
                    formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    }
                if (Kunde.getLeveringsType().equals("Afhentning i butik")){
                    System.out.println("Om hvor lang tid skal ordren hentes (indtastes i min.)?");
                } else {
                    System.out.println("Hvor langt skal der gå før pizzaen skal leveres (indtastes i min.)?");
                }
                userPizza = userInput.nextLine();
                if (isNumeric(userPizza) && Integer.parseInt(userPizza) > 0){
                    int userPizzaInt = Integer.parseInt(userPizza);
                    String Afhentningstid = LocalDateTime.now().plusMinutes(userPizzaInt).format(formatTime);
                    tidspizza = new Pizza(tidspizza.getNummer(), Kunde.getLeveringsType(), tidspizza.getType(),
                            tidspizza.getPris(), tidspizza.getKategori(), Oprettelsestid, Afhentningstid);
                    igangværendeOrdre.add(tidspizza);
                    System.out.println(tidspizza.toString());
                    System.out.println("Dato for oprettelse af ordre: " + Oprettelsestid);
                } else {
                    System.out.println("Input ikke forstået");
                }
                break;

                //Nedenstående kører, hvis et pizzanummer indtastes
            } else if (isNumeric(userPizza) && pizzaMenu.size() >= Integer.parseInt(userPizza) && 0 <
                    Integer.parseInt(userPizza)) {
                userPizzaInt = Integer.parseInt(userPizza);
                tempPizza = pizzaMenu.get(userPizzaInt - 1);

                //Her ændres type (standard/familie), og der tilføjes evt. ingredienser samt en kommentar.
                EkstraIngredienser.familiePizza(userPizzaInt);
                //TempPizza tilføjes til ordren.
                igangværendeOrdre.add(tempPizza);

                //Printer forskellige beskeder afhængigt af typen af pizzaen
                if (!pizzaMenu.get(userPizzaInt - 1).getKategori().contains("Sandwich")) {
                    System.out.println("Pizza nr. " + userPizzaInt + " er blevet tilføjet til ordren.");
                } else {
                    System.out.println("Sandwich nr. " + userPizzaInt + " er blevet tilføjet til ordren.");
                }
                System.out.println(printItemAddedToOrderMessage());

                //En af de to nedenstående kører, hvis brugeren ønsker at se ordren (input er "print")
            } else if (userPizza.equalsIgnoreCase("print") && !igangværendeOrdre.isEmpty()) {
                System.out.println("Bestilling:");
                for (Pizza temp : igangværendeOrdre) {
                    System.out.println(temp);
                }
                System.out.println(printItemAddedToOrderMessage());
            } else if (userPizza.equalsIgnoreCase("print") && igangværendeOrdre.isEmpty()) {
                System.out.println("Ordren er tom.");
                System.out.println(printItemAddedToOrderMessage());


                //Nedenstående kører, hvis brugeren ønsker at se pizzamenuen (input er "menu")
            } else if (userPizza.equalsIgnoreCase("menu")) {

                //Print pizza menu
                Pizza.printPizzaMenu();
                System.out.println(printItemAddedToOrderMessage());



                //Nedenstående kører, hvis brugeren ønsker at redigere bestillingen (input er "slet")
            } else if (userPizza.equalsIgnoreCase("slet")) {

                //Ordren printes, og hver pizza tildeles et ID
                if (!igangværendeOrdre.isEmpty()) {
                    System.out.println("Bestilling:");
                    int i = 1;
                    for (Pizza temp : igangværendeOrdre) {
                        System.out.println("ID " + i + " - " + temp);
                        i++;
                    }

                    //Fjerner en pizza fra ordren
                    System.out.println("Indtast ID'et på den pizza, du ønsker at slette. Indtast \"slut\" " +
                            "for at afslutte.");
                    userPizza = userInput.nextLine();
                    //Hvis der indtastes et nummer, der er lig et af de viste ID, slettes pizzaen med det givne ID
                    if (isNumeric(userPizza) && igangværendeOrdre.size() >= Integer.parseInt(userPizza) &&
                            0 < Integer.parseInt(userPizza)) {
                        igangværendeOrdre.remove(Integer.parseInt(userPizza) - 1);
                        System.out.println("Pizzaen med ID " + userPizza + " er blevet slettet fra ordren.");
                        //Efter pizzaen er blevet slettet, printe den opdaterede ordre, hvis den ikke er tom.
                        if (!igangværendeOrdre.isEmpty()) {
                            System.out.println("Opdateret ordre:");
                            for (Pizza temp : igangværendeOrdre) {
                                System.out.println(temp);
                            }
                        } else {
                            System.out.println("Ordren er tom.");
                        }
                        //Hvis der indtastes "slut", afsluttes der, uden at noget bliver slettet
                    } else if (userPizza.equals("slut")) {
                        System.out.println("Ingen pizzaer er blevet slettet.");
                    } else {
                        System.out.println("Input ikke forstået.");
                    }
                } else {
                    System.out.println("Ordren er tom.");
                }
                System.out.println(printItemAddedToOrderMessage());



                //Hvis der indtastes andet end det ønskede input, printes en fejlmeddelelse, og brugeren får mulighed
                // for at prøve igen.
            } else {
                System.out.println("Findes ikke i menuen, prøv igen.");
            }
        }
    }

    //Denne metode bruges til at slette en ordre, efter den er blevet oprettet.
    // I praksis kan dette gøres både, når ordren er gennemført, og hvis ordren viser sig at være forkert.
    public static void sletOrdre(){
        Scanner input = new Scanner(System.in);
        if (!alleOrdrer.isEmpty()){
            System.out.println("Indtast nummeret på den ordre, du vil fjerne.");
            String userInput = input.nextLine();

            //Dette prompt printes, da systemet skal vide, om ordren skal gemmes til videre brug af statisitk-klassen.
            // Alle gennemførte ordrer skal gemmes, mens forkerte ordrer skal slettes helt.
            // Ordren gemmes, hvis der indtastes alt andet end "ja", da dette outcome anses som værende standard.
            System.out.println("Skal ordren slettes helt fra systemet? Indtast \"ja\" eller et vilkårligt input.");
            String userInput2 = input.nextLine();
            if (isNumeric(userInput) && alleOrdrer.size() >= Integer.parseInt(userInput) &&
                    0 < Integer.parseInt(userInput) && !userInput2.toLowerCase().contains("ja")) {
                færdiggjorteOrdrer.add(alleOrdrer.get(Integer.parseInt(userInput)-1));

                alleOrdrer.remove(Integer.parseInt(userInput)-1);
                System.out.println("Ordre nummer " + userInput + " er blevet slettet og gemt i systemet.");
            }
            else if (isNumeric(userInput) && alleOrdrer.size() >= Integer.parseInt(userInput) &&
                    0 < Integer.parseInt(userInput) && userInput2.toLowerCase().contains("ja")){
                alleOrdrer.remove(Integer.parseInt(userInput)-1);
                System.out.println("Ordre nummer " + userInput + " er blevet slettet helt fra systemet.");
            }
            else if (isNumeric(userInput) && alleOrdrer.size() < Integer.parseInt(userInput) ||
                    0 > Integer.parseInt(userInput)){
                System.out.println("Ordren findes ikke");
            }
            else {
                System.out.println("Input ikke forstået");
            }
        } else {
            System.out.println("Der er ikke nogen ordrer.");
        }
    }

    //Tilberedningsrækkefølgen printes
    public static void printTilberedningsRækkefølge(ArrayList<ArrayList<Pizza>> alleOrdre) {
        int i = 1;
        int j = 0;
        for (ArrayList<Pizza> ordre : alleOrdre) {
            int ordrePris = 0;
            int t = 0;
            System.out.println("\nOrdre nr. " + i);
            printTime(j);
            i++;
            for (Pizza tingIOrdre : ordre) {
                if (tingIOrdre.getType().contains("Kunde")) {
                    System.out.println("       " + tingIOrdre);
                } else if (!tingIOrdre.getType().contains("Tid")) {
                    System.out.println("    Nummer: " + tingIOrdre);
                } else {
                    System.out.println("       " + tingIOrdre);
                }
                ordrePris += alleOrdrer.get(j).get(t).getPris();
                t+=1;
            }
            j++;
            System.out.println("\nSamlet pris: " + ordrePris + " kr.");
        }
    }
    //Tid for bestilling samt afhentningstidspunkt printes
    public static void printTime(int input) {
        //Datetimeformatter bruges til at vise den fortrukne dato og tid format
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println("Ordreoprettelse: " + alleOrdrer.get(input).get(alleOrdrer.get(input).size()-1).getTopping()
                + " - " + "Afhentningstid: " + alleOrdrer.get(input).get(alleOrdrer.get(input).size()-1).getKommentar());
    }

    //Metoden herunder sorterer en ArrayListe af pizzaer efter stigende afhentningstidpunkt.
    public static void sorterListe(ArrayList<ArrayList<Pizza>> ordreliste) throws ParseException {
        Collections.sort(alleOrdrer, new Comparator<ArrayList<Pizza>>() {
            @Override
            public int compare(ArrayList<Pizza> o1, ArrayList<Pizza> o2) {
                Date date1= null;
                try {
                    date1 = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(o1.get(o1.size()-1).getKommentar());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Date date2= null;
                try {
                    date2 = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(o2.get(o2.size()-1).getKommentar());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (date1.after(date2)) {
                    return 1;
                }

                if (date1.before(date2)) {
                    return -1;
                }

                return date1.compareTo(date2);
            }
        });
    }

    //Denne metode overrider toString-metoden, så informationen ordrene printes på en bestemt måde
    @Override
    public String toString(){
        return alleOrdrer.toString().toUpperCase();
    }

    //En getter, der returnerer alleOrdrer
    public static ArrayList<ArrayList<Pizza>> getAlleOrdrer() {
        return alleOrdrer;
    }

    //Denne metode bruges til at undersøge, om et string-input er et tal.
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    //Denne metode beregner den totale pris for en ordre ved at summere alle priserne for de enkelte pizzaer i ordren.
    public static int totalPrice(ArrayList<Pizza> array) {
        int totalpris = 0;
        for (Pizza temp : array) {
            totalpris += temp.getPris();
        }
        return totalpris;
    }

    //Standardsvar, der fortæller brugeren, at hen er i ordremenuen
    public static String printItemAddedToOrderMessage (){
        return ("\nIndtast nummer (1 - " + Pizza.getPizzaMenu().size() + ") for at tilføje eller skriv \"done\".");
    }

    public static ArrayList<ArrayList<Pizza>> getFærdiggjorteOrdrer() {
        return færdiggjorteOrdrer;
    }
}
