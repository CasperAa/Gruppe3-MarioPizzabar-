import java.util.ArrayList;

public class Pizza {

    int nummer;
    String navn;
    int pris;
    String kategori;
    String dejtype;
    String topping;
    String størrelse;
    String kommentar;
    int ekstraGebyr;
    int antal;

    //Constructor
    public Pizza(int nummer, String navn, int pris, String kategori, String topping) {
        this.nummer = nummer;
        this.navn = navn;
        this.pris = pris;
        this.kategori = kategori;
        this.topping = topping;
    }

    public void pizzaOpretter() {

        //ToppingArray
        String[] toppingEt = {"tomatsauce", "ost", "skinke", "oregano"};


        pizzaMenu = new ArrayList<Pizza>();


        Pizza pizzaEt = new Pizza(1, "Vesuvio", 57, "kød", "tomatsauce, ost, skinke, oregano");
        Pizza pizzaTo = new Pizza(2, "Amerikaner", 53, "kød", "tomatsauce, ost, oksefars, oregano");
        Pizza pizzaTre = new Pizza(3, "Cacciatore", 57, "kød", "tomatsauce, ost, pepperoni, oregano");
        Pizza pizzaFire = new Pizza(4, "Carbona", 63, "kød", "tomatsauce, ost, kødsauce, spaghetti, cocktailpølser, oregano");
        Pizza pizzaFem = new Pizza(5, "Dennis", 65, "kød", "tomatsauce, ost, skinke, pepperoni, cocktailpølse, oregano");
        Pizza pizzaSeks = new Pizza(6, "Bertil", 57, "kød", "tomatsauce, ost, bacon, pepperoni");

        //Here the pizzas are added to the arrayList
        pizzaMenu.add(pizzaEt);
        pizzaMenu.add(pizzaTo);
        pizzaMenu.add(pizzaTre);
        pizzaMenu.add(pizzaFire);
        pizzaMenu.add(pizzaFem);
        pizzaMenu.add(pizzaSeks);

        //Here the menu is printet
        for (Pizza temp : pizzaMenu) {
            System.out.println(temp);
        }



    }


    //The toString-method is overridden. We choose what is printet when the pizza-pbjects are printet.
    @Override
    public String toString(){

        return nummer + " " + navn + ": Toppings: " + topping + ", " + pris + " kr.";
    }


    public static ArrayList <Pizza> getPizzaMenu(){
        return pizzaMenu;
    }

    public static Pizza getPizzaMenu2(int index){
        return pizzaMenu.get(index);
    }

}





