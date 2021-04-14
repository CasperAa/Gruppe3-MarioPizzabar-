import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {

    int nummer;
    String navn;
    int pris;
    String kategori;
    String topping;

    static private ArrayList <Pizza> pizzaMenu;

    //Constructor
    public Pizza(int nummer, String navn, int pris, String kategori, String topping) {
        this.nummer = nummer;
        this.navn = navn;
        this.pris = pris;
        this.kategori = kategori;
        this.topping = topping;
    }

    public static void pizzaOpretter() throws FileNotFoundException {
        File pizzaFile = new File("Files/Mario's PizzaMenu.csv");
        Scanner pizzaReader = new Scanner(pizzaFile);

        pizzaMenu = new ArrayList<>();
        //Skipping metadata row
        pizzaReader.nextLine();

        //Using a while loop guarantee all rows in the file is read
        while (pizzaReader.hasNext()) {

            String currentPizza = pizzaReader.nextLine();
            //Using the split method to divide a rows data, and storing it in a list

            String [] lineAsArray = currentPizza.split(";");
            //Storing the lists data in two different Strings using their index location

            int nummer = Integer.parseInt(lineAsArray[0].trim());
            String navn = lineAsArray[1].trim();
            int pris = Integer.parseInt(lineAsArray[2].trim());
            String kategori = lineAsArray[3].trim();
            String topping = lineAsArray[4].trim();

            //Creating a instance of a student with the String data from above
            Pizza newPizza = new Pizza(nummer, navn, pris, kategori, topping);
            //Adding the student to the ArrayList
            pizzaMenu.add(newPizza);
        }

    }

    //The toString-method is overridden. We choose what is printet when the pizza-objects are printet.
    @Override
    public String toString(){

        return nummer + ":   " + navn + ":   Toppings: " + topping + " - " + pris + " kr";
    }



    public static ArrayList <Pizza> getPizzaMenu(){
        return pizzaMenu;
    }
    public Pizza getPizzaMenu2(int index){
        return pizzaMenu.get(index);
    }

    public int getPris() {
        return pris;
    }

    public int getNummer() {
        return nummer;
    }
}





