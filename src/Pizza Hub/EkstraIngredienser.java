import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class EkstraIngredienser {

    final private int nummer;
    final private String navn;
    final private int Alm_pris;
    final private int Fam_pris;
    static boolean familie = false;
    final private static int familieGebyr = 50;

    private static final ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();
    private static ArrayList<EkstraIngredienser> ingredienserListe;

    //Constructor
    public EkstraIngredienser(int nummer, String navn, int Alm_pris, int Fam_pris) {
        this.nummer = nummer;
        this.navn = navn;
        this.Alm_pris = Alm_pris;
        this.Fam_pris = Fam_pris;
    }
    //Metode, der læser og overfører data fra en CSV fil til en ArrayList
    public static void ingrediensListeOpretter() throws FileNotFoundException {
        File EkstraIngredienserFile = new File("Files/Ekstra Ingredienser.csv");
        Scanner EkstraIngredienserReader = new Scanner(EkstraIngredienserFile);
        ingredienserListe = new ArrayList<>();

        //Skipper metadatalinjen
        EkstraIngredienserReader.nextLine();

        //While-loop, så alle linjer bliver læst
        while (EkstraIngredienserReader.hasNext()) {

            String currentIngrediense = EkstraIngredienserReader.nextLine();
            //Split-method for at opdele linjen

            String[] lineAsArray = currentIngrediense.split(",");

            int nummer = Integer.parseInt(lineAsArray[0].trim());
            String navn = lineAsArray[1].trim();
            int Aml_pris = Integer.parseInt(lineAsArray[2].trim());
            int Fam_pris = Integer.parseInt(lineAsArray[3].trim());

            //Opretter et ny instance af ingrediensen
            EkstraIngredienser newIngrediense = new EkstraIngredienser(nummer, navn, Aml_pris, Fam_pris);
            //Tilføjer den til ArrayListen
            ingredienserListe.add(newIngrediense);
        }
    }

    //Metode, der spørger, hvilken type pizza det skal være (standard eller familie)
    public static void familiePizza(int valgtPizza) {
        final String Traditionale = "Traditionale";
        final String Biache = "Biache";
        final String Vegetale = "Vegetale";

        //If-statement, da dette kun skal ske, hvis typen af pizza kan være familie-størrelse
        if (pizzaMenu.get(valgtPizza - 1).getKategori().equals(Traditionale) || pizzaMenu.get(valgtPizza - 1).
                getKategori().equals(Biache) || pizzaMenu.get(valgtPizza - 1).getKategori().equals(Vegetale)) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Vælg Str:");
            System.out.println("Tryk 1 for standard: " + pizzaMenu.get(valgtPizza - 1).getPris() + " kr.");
            System.out.println("Tryk 2 for familie: " + (pizzaMenu.get(valgtPizza - 1).getPris() + familieGebyr) +
                    " kr.");
            String userReply = userInput.nextLine();
            if (Bestilling.isNumeric(userReply)) {
                switch (Integer.parseInt(userReply)) {

                    case 1: //Standardpizza
                        familie = false;
                        Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.
                                getNavn(), "Standard", (pizzaMenu.get(valgtPizza - 1).getPris()),
                                Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(),
                                Bestilling.tempPizza.getKommentar());
                        supplerIngredienser();
                        supplerKommentar();
                        break;
                    case 2: //FamiliePizza
                        familie = true;
                        Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.
                                getNavn(), "Familie", (pizzaMenu.get(valgtPizza - 1).getPris() + familieGebyr),
                                Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(),
                                Bestilling.tempPizza.getKommentar());
                        supplerIngredienser();
                        supplerKommentar();
                        break;
                    default:
                        System.out.println("Jeg forstår dig ikke, prøv igen!");
                        familiePizza(Bestilling.userPizzaInt);
                        break;
                }
                //Hvis programmet ikke forstår brugerens input
            } else if (!Bestilling.isNumeric(userReply)){
                familie = false;
                Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(),
                        "Standard", (pizzaMenu.get(valgtPizza - 1).getPris()), Bestilling.tempPizza.getKategori(),
                        Bestilling.tempPizza.getTopping(), Bestilling.tempPizza.getKommentar());
                supplerIngredienser();
                supplerKommentar();
            }
        //Hvis pizzaen/sandwichen ikke er af typen "åben pizza", køres dette
        } else if (pizzaMenu.get(valgtPizza - 1).getKategori().equals("Indbagt") || pizzaMenu.get(valgtPizza - 1).
                getKategori().equals("Sandwich")){
            supplerIngredienser();
            supplerKommentar();
        }
    }

    //Metode, der tilføjer ekstra ingredienser
    public static void supplerIngredienser() {
        Scanner userInput = new Scanner(System.in);
        int inPris = Bestilling.tempPizza.getPris();
        System.out.println("Ekstra ingredienser? - Ja / Nej");
        String userReply = userInput.nextLine();
        boolean inAdded = false;
        if (userReply.toLowerCase().contains("ja")) {
            ArrayList<EkstraIngredienser> tilføjedeIn = new ArrayList<>();
            //Printer ekstraingredienser med henholdsvis standard- og familiepriser
            if(familie){
                printFamilieEkstraIngredienser();
            } else {
                printStandardEkstraIngredienser();
            }
            //While-loop, der kører, indtil brugeren ikke længere ønsker at tilføje flere ekstraingredienser til pizzaen
            while (true) {
                System.out.println("Indtast nummeret på den ønskede ingrediens eller indtast \"stop\" eller \"slet\".");
                userReply = userInput.nextLine();
                if (Bestilling.isNumeric(userReply) && ingredienserListe.size() >= Integer.parseInt(userReply) &&
                        0 < Integer.parseInt(userReply)) {
                    inAdded = true;
                    int userReplyInt = Integer.parseInt(userReply);
                    tilføjedeIn.add(ingredienserListe.get(userReplyInt - 1));
                    System.out.println(ingredienserListe.get(Integer.parseInt(userReply)-1).navn + " blev tilføjet.");
                } else if (userReply.toLowerCase().contains("stop") && inAdded) {
                    break;
                } else if (userReply.toLowerCase().contains("stop") && !inAdded) {
                    System.out.println("Ingen ekstra ingredienser er blevet tilføjet.");
                    break;

                    //Denne del gør det muligt at slette nogle af de tilføjede ingredienser igen
                } else if (userReply.toLowerCase().contains("slet")) {
                    if (!tilføjedeIn.isEmpty()) {
                        System.out.println("Tilføjede ingredienser: ");
                        int i = 1;
                        for (EkstraIngredienser ingrediens : tilføjedeIn){
                            System.out.print("Nr. " + i + ": " + ingrediens.getNavn());
                            if (familie) {
                                System.out.println(", " + ingrediens.Fam_pris + " kr.");
                            } else{
                                System.out.println(", pris: " + ingrediens.Alm_pris + " kr.");
                            }
                            i++;
                        }
                        System.out.println("Hvad vil du slette?");
                        userReply = userInput.nextLine();
                        int userReplyint = Integer.parseInt(userReply);
                        if (Bestilling.isNumeric(userReply) && tilføjedeIn.size() >= userReplyint && 0 < userReplyint) {
                            String navn = tilføjedeIn.get(userReplyint-1).getNavn();
                            tilføjedeIn.remove(userReplyint-1);
                            System.out.println(navn + " blev slettet");
                        }
                    } else {
                        System.out.println("Der er ikke blevet tilføjet nogen ingredienser.");
                    }
                } else {
                    System.out.println("Input ikke forstået");
                }
            }
            String ingredienserString = "";
            if (!tilføjedeIn.isEmpty()){
                for (EkstraIngredienser ingrediens : tilføjedeIn){
                    ingredienserString += ingrediens.getNavn() + " + ";
                }
                ingredienserString = ingredienserString.substring(0, ingredienserString.length() - 3);
                for (EkstraIngredienser ingrediens : tilføjedeIn) {
                    if (familie) {
                        inPris += ingrediens.getFam_pris();
                    } else {
                        inPris += ingrediens.getAlm_pris();
                    }
                }
            }
            if(!tilføjedeIn.isEmpty()){
                Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(),
                        Bestilling.tempPizza.getType(), inPris, Bestilling.tempPizza.getKategori(), Bestilling.
                        tempPizza.getTopping(), "Ekstra ingredienser: " + ingredienserString + ".");
            } else {
                Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(),
                        Bestilling.tempPizza.getType(), inPris, Bestilling.tempPizza.getKategori(), Bestilling.
                        tempPizza.getTopping(), "\" \"");
            }

        } else {
            Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(),
                    Bestilling.tempPizza.getType(), inPris, Bestilling.tempPizza.getKategori(), Bestilling.
                    tempPizza.getTopping(), "\" \"");
        }
    }

    //Tilføj kommentar til pizzaen
    public static void supplerKommentar() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Indsæt kommentar? 1\nFjern ingredienser? 2\nFortsæt uden? 3");
        String userReply = userInput.nextLine();

        switch (userReply) {
            case "1":
                System.out.println("Skriv kommentar:");
                userReply = userInput.nextLine();
                Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(),
                        Bestilling.tempPizza.getType(), Bestilling.tempPizza.getPris(), Bestilling.tempPizza.
                        getKategori(), Bestilling.tempPizza.getTopping(), Bestilling.tempPizza.
                        getKommentar() + " Kommentar: " + userReply + ".");
                break;

            case "2":
                System.out.println("Indtast ingredienserne på én linje:");
                userReply = userInput.nextLine();
                Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(),
                        Bestilling.tempPizza.getType(), Bestilling.tempPizza.getPris(),
                        Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(),
                        Bestilling.tempPizza.getKommentar() + " Undlad toppings: " + userReply + ".");
                break;
        }
        System.out.println(Bestilling.tempPizza);
    }

    //Ekstraingredienser printes
    public static void printStandardEkstraIngredienser() {
        for (EkstraIngredienser ingrediens : ingredienserListe) {
            System.out.println( ingrediens.getNummer() +": " + ingrediens.getNavn() + "..... " +
                    ingrediens.getAlm_pris() +" kr");
        }
    }
    public static void printFamilieEkstraIngredienser() {
        for (EkstraIngredienser ingrediens : ingredienserListe) {
            System.out.println(ingrediens.getNummer() +": " + ingrediens.getNavn() + "..... " +
                    ingrediens.getFam_pris() +" kr");
        }
    }

    @Override
    public String toString () {
        return nummer + ": " + navn + " - Normal pris: " + Alm_pris + " kr - Familiepris: " + Fam_pris;
    }

    //Herunder er 4 getters
    public int getNummer() { return nummer; }

    public String getNavn() { return navn; }

    public int getAlm_pris() { return Alm_pris; }

    public int getFam_pris() { return Fam_pris; }
}
