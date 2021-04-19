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

    public static void ingrediensListeOpretter() throws FileNotFoundException {
        File EkstraIngredienserFile = new File("Files/Ekstra Ingredienser.csv");
        Scanner EkstraIngredienserReader = new Scanner(EkstraIngredienserFile);
        ingredienserListe = new ArrayList<>();

        //Skipper metadata linje
        EkstraIngredienserReader.nextLine();

        //while loop så alle linjer bliver læst
        while (EkstraIngredienserReader.hasNext()) {

            String currentIngrediense = EkstraIngredienserReader.nextLine();
            //split method for at opdele linjen

            String[] lineAsArray = currentIngrediense.split(",");

            int nummer = Integer.parseInt(lineAsArray[0].trim());
            String navn = lineAsArray[1].trim();
            int Aml_pris = Integer.parseInt(lineAsArray[2].trim());
            int Fam_pris = Integer.parseInt(lineAsArray[3].trim());

            //Opretter en ny instace af ingrediensen
            EkstraIngredienser newIngrediense = new EkstraIngredienser(nummer, navn, Aml_pris, Fam_pris);
            //Tilføjer den til ArrayListen
            ingredienserListe.add(newIngrediense);
        }
    }

    public static void familiePizza(int valgtPizza) {
        String Traditional = "Traditionale";
        String Biache = "Biache";
        String Vegetale = "Vegetale";

        //If statement da dette kun skal ske hvis det er en pizza
        if (pizzaMenu.get(valgtPizza - 1).getKategori().equals(Traditional) || pizzaMenu.get(valgtPizza - 1).getKategori().equals(Biache) || pizzaMenu.get(valgtPizza - 1).getKategori().equals(Vegetale)) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Vælg Str:");
            System.out.println("Tryk 1 for standard: " + pizzaMenu.get(valgtPizza - 1).getPris() + " kr.");
            System.out.println("Tryk 2 for familie: " + (pizzaMenu.get(valgtPizza - 1).getPris() + familieGebyr) + " kr.");
            String userReply = userInput.nextLine();
            if (Bestilling.isNumeric(userReply)) { //Dette if-statement virker ikke efter Caspers oprydning, men det skulle det gerne komme til igen
                switch (Integer.parseInt(userReply)) {
                    case 2:
                        familie = true;
                        Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(), "Familie", (pizzaMenu.get(valgtPizza - 1).getPris() + familieGebyr), Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(), Bestilling.tempPizza.getKommentar());
                        supplerIngredienser();
                        supplerKommentar();
                        break;
                    case 1:
                    default:
                        familie = false;
                        Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(), "Standard", (pizzaMenu.get(valgtPizza - 1).getPris()), Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(), Bestilling.tempPizza.getKommentar());
                        supplerIngredienser();
                        supplerKommentar();
                        break;
                }
            } else {
                familie = false;
                Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(), "Standard", (pizzaMenu.get(valgtPizza - 1).getPris()), Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(), Bestilling.tempPizza.getKommentar());
                supplerIngredienser();
                supplerKommentar();
            }
        } else if (pizzaMenu.get(valgtPizza - 1).getKategori().equals("Indbagt") || pizzaMenu.get(valgtPizza - 1).getKategori().equals("Sandwich")){
            supplerIngredienser();
            supplerKommentar();
        }
    }

    public static void supplerIngredienser() {
        Scanner userInput = new Scanner(System.in);
        int inPris = Bestilling.tempPizza.getPris();
        System.out.println("Ekstra ingredienser? - Ja / Nej");
        String userReply = userInput.nextLine();
        String in = null;
        boolean inAdded = false;
        if (userReply.toLowerCase().contains("ja")) {
            if(familie){
                printFamilieEkstraIngredienser();
            } else {
                printStandardEkstraIngredienser();
            }
            while (true) {
                System.out.println("Indtast nummeret på den ønskede ingrediens eller indtast \"stop\" eller \"slet\".");
                userReply = userInput.nextLine();
                if (Bestilling.isNumeric(userReply) && ingredienserListe.size() >= Integer.parseInt(userReply) && 0 < Integer.parseInt(userReply)) {
                    inAdded = true;
                    int userReplyInt = Integer.parseInt(userReply);
                    in += ingredienserListe.get(userReplyInt - 1).navn + " + ";
                    if (!familie) {
                        inPris += ingredienserListe.get(userReplyInt - 1).Alm_pris;
                    } else {
                        inPris += ingredienserListe.get(userReplyInt - 1).Fam_pris;
                    }
                    System.out.println(ingredienserListe.get(Integer.parseInt(userReply)-1).navn + " blev tilføjet.");
                } else if (userReply.toLowerCase().contains("stop") && inAdded) {
                    in = in.substring(0, in.length()-3).replaceFirst("null", "");
                    break;
                } else if (userReply.toLowerCase().contains("stop") && !inAdded) {
                    System.out.println("Ingen ekstra ingredienser er blevet tilføjet.");
                    break;
                } else if (userReply.toLowerCase().contains("slet")) {
                    if (!in.equals("null") && !in.equals("null + ")) {
                        System.out.println("Tilføjede ingredienser: " + in.substring(0, in.length()-3).replaceFirst("null", "") + "\nHvad vil du slette?");
                        System.out.println("In i starten " + in);
                        userReply = userInput.nextLine();
                        String slettes = userReply.toLowerCase().substring(0, 1).toUpperCase() + userReply.substring(1);
                        System.out.println("Dette ord skal slettes -" + slettes + "-");
                        in = in.substring(4, in.length() - 1); //Fjerner null
                        if (in.contains(slettes)) {
                            in = in.replaceFirst(slettes, "");
                            //Jeg kan ikke få slettet plus, hvilket er et problem.
                            /*
                            if (in.contains(" \\+  \\+ ")){
                                in = in.replaceFirst(" \\+  \\+ ", " + ");
                            } else if (!in.contains(" \\+  \\+ ")){
                                in = in.replaceFirst(" \\+ ", "");
                            }

                             */
                            in = "null" + in; //null tilføjes igen, så den kan fjernes senere
                            System.out.println("Indtast prisen på den slettede ingrediens:");
                            String userReply2 = userInput.nextLine();
                            inPris -= Integer.parseInt(userReply2);
                            System.out.println(slettes + " blev slettet.");
                        } else if (!in.contains(slettes)) {
                            System.out.println("Input ikke forstået.");
                        }
                    } else {
                        System.out.println("Der er ikke blevet tilføjet nogen ingredienser.");
                    }
                } else {
                    System.out.println("Input ikke forstået");
                }
            }
            Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(), Bestilling.tempPizza.getType(), inPris, Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(), "Ekstra ingredienser: " + in + ".");
        } else {
            Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(), Bestilling.tempPizza.getType(), inPris, Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(), "");
        }
    }

    public static void supplerKommentar() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Indsæt kommentar? 1\nFjern ingredienser? 2\nFortsæt uden? 3");
        String userReply = userInput.nextLine();
        switch (userReply) {
            case "1":
                System.out.println("Skriv kommentar:");
                userReply = userInput.nextLine();
                Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(), Bestilling.tempPizza.getType(), Bestilling.tempPizza.getPris(), Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(), Bestilling.tempPizza.getKommentar() + " Kommentar: " + userReply + ".");
                break;

            case "2":
                System.out.println("Indtast ingredienserne på én linje:");
                userReply = userInput.nextLine();
                Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(), Bestilling.tempPizza.getType(), Bestilling.tempPizza.getPris(), Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(), Bestilling.tempPizza.getKommentar() + " Undlad toppings: " + userReply + ".");
                break;
        }
        System.out.println(Bestilling.tempPizza);
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

    @Override
    public String toString () {
        return nummer + ": " + navn + " - Normal pris: " + Alm_pris + " kr - Familiepris: " + Fam_pris;
    }

    public int getNummer() { return nummer; }

    public String getNavn() { return navn; }

    public int getAlm_pris() { return Alm_pris; }

    public int getFam_pris() { return Fam_pris; }
}


