import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {

    private final int nummer;
    private final String navn;
    private final String type;
    private final int pris;
    private String kategori;
    private String topping;
    private String kommentar;


    static private ArrayList <Pizza> pizzaMenu;

    //Constructor
    public Pizza(int nummer, String navn, String type, int pris, String kategori, String topping, String kommentar) {
        this.nummer = nummer;
        this.navn = navn;
        this.type = type;
        this.pris = pris;
        this.kategori = kategori;
        this.topping = topping;
        this.kommentar = kommentar;
    }

    //Denne metode læser filen (pizza menu) og indsætter data i en ArrayListe
    public static void menuOpretter() throws FileNotFoundException {
        File pizzaFile = new File("Files/Mario's PizzaMenu.csv");
        Scanner pizzaReader = new Scanner(pizzaFile);

        pizzaMenu = new ArrayList<>();
        //Skipper metadata linjen
        pizzaReader.nextLine();

        //while loop for alle linjer
        while (pizzaReader.hasNext()) {
            //En attribut som indeholder den nuværende linje
            String currentPizza = pizzaReader.nextLine();

            String [] lineAsArray = currentPizza.split(";");

            int nummer = Integer.parseInt(lineAsArray[0].trim());
            String navn = lineAsArray[1].trim();
            String type = lineAsArray[2].trim();
            final int pris = Integer.parseInt(lineAsArray[3].trim());
            String kategori = lineAsArray[4].trim();
            String topping = lineAsArray[5].trim();
            String kommentar = lineAsArray[6].trim();

            Pizza newPizza = new Pizza(nummer, navn, type, pris, kategori, topping, kommentar);
            //Tilføjer pizzaen til menuen
            pizzaMenu.add(newPizza);
        }

    }

    //The toString-method is overridden. We choose what is printed when the pizza-objects are printed.
    @Override
    public String toString(){
        if (type.toLowerCase().contains("standard") && kommentar.equalsIgnoreCase(" ")){
            return "\n"+nummer + "   " + navn +" - " + topping + "...... " + pris + " kr.-";
        } else if (!type.toLowerCase().contains("standard") && kommentar.equalsIgnoreCase(" ")) {
            return "\n"+nummer + "   " + navn +" - " + topping + "...... " + pris + " kr.-" + "\n   Type: " + type.toUpperCase();
        } else if (!type.toLowerCase().contains("standard") && !kommentar.equalsIgnoreCase(" ") && !type.toLowerCase().contains("tid")) {
            return "\n"+nummer + "   " + navn +" - " + topping + "...... " + pris + " kr.-" + "\n   Type: " + type.toUpperCase() +"\n    "+ kommentar;

            //Menu Display
        } else if (type.toLowerCase().contains("standard") && !kommentar.equalsIgnoreCase(" ")) {
            return nummer + "   " + navn +" - " + topping + "...... " + pris + " / " + (pris + getfamilieGebyr()) + " kr.-";
        } else if (type.toLowerCase().contains("tid")) {
            return "\nAfhentningstid - " + kommentar;
        } else {
            return nummer + "   " + navn + " - " + topping + "...... " + pris + " kr.-";
        }
    }


    public static ArrayList <Pizza> getPizzaMenu(){ return pizzaMenu; }

    public int getPris() { return pris; }

    public int getNummer() { return nummer; }

    public String getTopping(){ return topping;}

    public String getKategori(){ return kategori;}

    public String getKommentar() { return kommentar; }

    public String getNavn() { return navn; }

    public String getType() { return type; }

    public int getfamilieGebyr () {
     return EkstraIngredienser.getFamilieGebyr();
    }
}





