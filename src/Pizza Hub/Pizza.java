import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {

    int nummer;
    String navn;
    String type;
    int pris;
    String kategori;
    String topping;
    String kommentar;


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

    //This method reads the CSV file which has the menu, makes the program able to store the data
    public static void menuOpretter() throws FileNotFoundException {
        File pizzaFile = new File("Files/Mario's PizzaMenu.csv");
        Scanner pizzaReader = new Scanner(pizzaFile);

        pizzaMenu = new ArrayList<>();
        //Skipping metadata row
        pizzaReader.nextLine();

        //Using a while loop guarantee all rows in the file is read
        while (pizzaReader.hasNext()) {
            //A attribute to store current row
            String currentPizza = pizzaReader.nextLine();

            //Using the split method to divide a rows data, and storing it in a list
            String [] lineAsArray = currentPizza.split(";");

            //Storing the lists data in different Strings & integers using their index location
            int nummer = Integer.parseInt(lineAsArray[0].trim());
            String navn = lineAsArray[1].trim();
            String type = lineAsArray[2].trim();
            int pris = Integer.parseInt(lineAsArray[3].trim());
            String kategori = lineAsArray[4].trim();
            String topping = lineAsArray[5].trim();
            String kommentar = lineAsArray[6].trim();

            //Creating a instance of a item with the String data from above
            Pizza newPizza = new Pizza(nummer, navn, type, pris, kategori, topping, kommentar);
            //Adding the item to the menu
            pizzaMenu.add(newPizza);
        }

    }

    //The toString-method is overridden. We choose what is printed when the pizza-objects are printed.
    @Override
    public String toString(){
        if (type.toLowerCase().contains("standard") && kommentar.toLowerCase().equals("")){
            return nummer + " " + navn +" Toppings: " + topping + "...... " + pris + " kr.";
        } else if (!type.toLowerCase().contains("standard") && kommentar.toLowerCase().equals("")) {
            return nummer + " " + navn +" Toppings: " + topping + " Type: " + type + "...... " + pris + " kr.";
        } else if (!type.toLowerCase().contains("standard") && !kommentar.toLowerCase().equals("")) {
            return nummer + " " + navn +" Toppings: " + topping + " Type: " + type + kommentar + "...... " + pris + " kr.";
        } else {
            return nummer + " " + navn +" Toppings: " + topping + kommentar + "...... " + pris + " kr.";
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
}





