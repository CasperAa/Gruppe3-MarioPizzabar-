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

        //Skipping metadata row
        EkstraIngredienserReader.nextLine();

        //Using a while loop guarantee all rows in the file is read
        while (EkstraIngredienserReader.hasNext()) {

            String currentIngrediense = EkstraIngredienserReader.nextLine();
            //Using the split method to divide a rows data, and storing it in a list

            String[] lineAsArray = currentIngrediense.split(",");
            //Storing the lists data in two different Strings using their index location

            int nummer = Integer.parseInt(lineAsArray[0].trim());
            String navn = lineAsArray[1].trim();
            int Aml_pris = Integer.parseInt(lineAsArray[2].trim());
            int Fam_pris = Integer.parseInt(lineAsArray[3].trim());

            //Creating a instance of an ingredient with the String data from above
            EkstraIngredienser newIngrediense = new EkstraIngredienser(nummer, navn, Aml_pris, Fam_pris);
            //Adding the ingredient to the ArrayList
            ingredienserListe.add(newIngrediense);
        }
    }

    public static void familiePizza(int valgtPizza) {
        String Traditional = "Traditionale";
        String Biache = "Biache";
        String Vegetale = "Vegetale";

        if (pizzaMenu.get(valgtPizza - 1).getKategori().equals(Traditional) || pizzaMenu.get(valgtPizza - 1).getKategori().equals(Biache) || pizzaMenu.get(valgtPizza - 1).getKategori().equals(Vegetale)) {
            int familieGebyr = 50;
            Scanner userInput = new Scanner(System.in);
            System.out.println("Vælg Str:");
            System.out.println("Tryk 1 for standard: " + pizzaMenu.get(valgtPizza - 1).getPris() + " kr.");
            System.out.println("Tryk 2 for familie: " + (pizzaMenu.get(valgtPizza - 1).getPris() + familieGebyr) + " kr.");
            String userReply = userInput.nextLine();
            switch (Integer.parseInt(userReply)) {
                case 1:
                    supplerIngredienser();
                    indsætKommentar();
                    break;
                case 2:
                    familie = true;
                    Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(), "Familie", (pizzaMenu.get(valgtPizza - 1).getPris() + familieGebyr), Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(), Bestilling.tempPizza.getKommentar());
                    supplerIngredienser();
                    indsætKommentar();
                    break;
                default:
                    break;
            }
        } else if (pizzaMenu.get(valgtPizza - 1).getKategori().equals("Indbagt") || pizzaMenu.get(valgtPizza - 1).getKategori().equals("Sandwich")){
            supplerIngredienser();
            indsætKommentar();
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
                PizzaMenu.printFamilieEkstraIngredienser();
            } else {
                PizzaMenu.printStandardEkstraIngredienser();
            }
            while (true) {
                System.out.println("Indtast nummeret på den ønskede ingrediens eller indtast \"stop\".");
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
                    System.out.println("Ingrediens nr. " + userReply + " blev tilføjet.");
                } else if (userReply.toLowerCase().contains("stop") && inAdded) {
                    in = in.substring(0, in.length()-3).replaceFirst("null", "");
                    break;
                } else if (userReply.toLowerCase().contains("stop") && !inAdded) {
                    System.out.println("Ingen ekstra ingredienser er blevet tilføjet.");
                    break;
                } else {
                    System.out.println("Input ikke forstået");
                }
            }
            Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(), Bestilling.tempPizza.getType(), inPris, Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(), "Ekstra topping: " + in);
        }
    }

    public static void indsætKommentar() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Indsæt kommentar? - Ja / Nej");
        String userReply = userInput.nextLine();
        if (userReply.toLowerCase().contains("ja")) {
            System.out.println("Fjerne ingredienser?  - Ja / Nej");
            userReply = userInput.nextLine();
            if (userReply.toLowerCase().contains("ja")) {
                System.out.println("Indtast ingredienserne på samme linje.");
                userReply = userInput.nextLine();
                Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(), Bestilling.tempPizza.getType(), Bestilling.tempPizza.getPris(), Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(), Bestilling.tempPizza.getKommentar() + " Undlad toppings: " + userReply);
            } else {
                System.out.println("Skriv kommentar:");
                userReply = userInput.nextLine();
                Bestilling.tempPizza = new Pizza(Bestilling.tempPizza.getNummer(), Bestilling.tempPizza.getNavn(), Bestilling.tempPizza.getType(), Bestilling.tempPizza.getPris(), Bestilling.tempPizza.getKategori(), Bestilling.tempPizza.getTopping(), Bestilling.tempPizza.getKommentar() + " Kommentar: " + userReply);
            }
        }
        System.out.println(Bestilling.tempPizza);
    }


    public static ArrayList<EkstraIngredienser> getIngredienseListe() {
        return ingredienserListe;
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


