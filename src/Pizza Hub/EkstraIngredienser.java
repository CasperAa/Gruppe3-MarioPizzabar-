import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class EkstraIngredienser {

    private int nummer;
    private String navn;
    private int Aml_pris;
    private int Fam_pris;

    private static ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();
    private static ArrayList<EkstraIngredienser> ingredienserListe;

    //Constructor
    public EkstraIngredienser(int nummer, String navn, int Aml_pris, int Fam_pris) {
        this.nummer = nummer;
        this.navn = navn;
        this.Aml_pris = Aml_pris;
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


    public static int familiePizza(int ønsketPizza) {
        String Traditional = "Traditionale";
        String Biache = "Biache";
        String Vegetale = "Vegetale";
        int ekstraGebyr = 0;


        if (pizzaMenu.get(ønsketPizza - 1).getKategori().equals(Traditional) || pizzaMenu.get(ønsketPizza - 1).getKategori().equals(Biache) || pizzaMenu.get(ønsketPizza - 1).getKategori().equals(Vegetale)) {
            int familieGebyr = 50;
            Scanner userInput = new Scanner(System.in);
            System.out.println("Vælg Str:");
            System.out.println("Tryk 1 for standard: " + pizzaMenu.get(ønsketPizza - 1).getPris() + " kr.");
            System.out.println("Tryk 2 for familie: " + (pizzaMenu.get(ønsketPizza - 1).getPris() + familieGebyr) + " kr.");
            boolean endProgram = true;
            while (endProgram) {
                String userReply = userInput.nextLine();
                System.out.println("Ekstra ingredienser? - Ja / Nej");
                switch (Integer.parseInt(userReply)){
                    case 1:
                        while (endProgram) {
                            userReply = userInput.nextLine();
                            PizzaMenu.printStandardEkstraIngredienser();
                            int ekstraIngredienseValg = Integer.parseInt(userInput.nextLine());
                            pizzaMenu.get(ønsketPizza - 1).kommentar = ingredienserListe.get(ekstraIngredienseValg - 1).navn;
                            ekstraGebyr += ingredienserListe.get(ekstraIngredienseValg - 1).Aml_pris;
                            System.out.println(pizzaMenu.get(ønsketPizza - 1).kommentar + " - Pris for estra ingredienser: " + ekstraGebyr + " kr");
                            System.out.println("Flere ingredienser? - Ja / Nej");
                            if (userReply.equals("Nej")) {
                                endProgram = false;
                            }
                        }
                        break;
                    case 2:
                        String userAnswer = userInput.nextLine();
                        if (userAnswer.equals("Ja")) {
                            PizzaMenu.printFamilieEkstraIngredienser();
                            int ekstraIngredienseValg = Integer.parseInt(userInput.nextLine());
                            pizzaMenu.get(ønsketPizza-1).kommentar = ingredienserListe.get(ekstraIngredienseValg-1).navn;
                            ekstraGebyr += ingredienserListe.get(ekstraIngredienseValg-1).Fam_pris + familieGebyr;
                            System.out.println(pizzaMenu.get(ønsketPizza-1).kommentar + ekstraGebyr +" - Pris for estra ingredienser: " + ekstraGebyr + " kr");
                            System.out.println("Flere ingredienser? - Ja / Nej");

                        } else {
                            endProgram = false;
                        }
                        break;
                    default:
                        endProgram = false;
                        break;
                }
            }
        }
        return ekstraGebyr;
    }

/*
    //Denne kode skal indsættes der, hvor ingredienser tilføjes
    int endeligPrisPizza;
    if (pizzaMenu.get(ønsketPizza-1).getKategori().equals(Traditional) || pizzaMenu.get(ønsketPizza-1).getKategori().equals(Biache) || pizzaMenu.get(ønsketPizza-1).getKategori().equals(Vegetale)){
        endeligPris = familiePris + ekstraIngredienser;
    }
    if (pizzaMenu.get(ønsketPizza-1).getKategori().equals(Indbagt) || pizzaMenu.get(ønsketPizza-1).getKategori().equals(Sandwich)){
        endeligPris = normalPris + ekstraIngredienser;
    }

 */


        //public static ()

        @Override
        public String toString (){ return nummer + ": " + navn + " - Normal pris: " + Aml_pris + " kr - Familie pris: " + Fam_pris; }

        public int getNummer() { return nummer; }
        public String getNavn() { return navn; }
        public int getFam_pris() { return Fam_pris; }
        public int getAml_pris() { return Aml_pris; }
        public static ArrayList<EkstraIngredienser> getIngredienseListe () {
            return ingredienserListe;
        }

}

