import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Pizza {

    int nummer;
    String navn;
    int pris;
    String kategori;
    String dejtype;
    String[] topping;
    String størrelse;
    String kommentar;
    int ekstraGebyr;
    int antal;

    //Constructor
    public Pizza(int nummer, String navn, int pris, String kategori, String[] topping) {
        this.nummer = nummer;
        this.navn = navn;
        this.pris = nummer;
        this.kategori = kategori;
        this.topping = topping;
    }

    Pizza pizzaEt = new Pizza(1,"Vesuvio", 57,"kød", new String[]{"tomatsauce", "ost", "skinke", "oregano"});
    Pizza pizzaTo = new Pizza(2,"Amerikaner", 53,"kød", new String[]{"tomatsauce", "ost", "oksefars", "oregano"});
    Pizza pizzaTre = new Pizza(3,"Cacciatore", 57,"kød", new String[]{"tomatsauce", "ost", "pepperoni", "oregano"});
    Pizza pizzaFire = new Pizza(4,"Carbona", 63,"kød", new String[]{"tomatsauce", "ost", "kødsauce", "spaghetti", "cocktailpølser", "oregano"});
    Pizza pizzaFem = new Pizza(5,"Dennis",65,"kød", new String[]{"tomatsauce", "ost", "skinke", "pepperoni", "cocktailpølse", "oregano"});
    Pizza pizzaSeks = new Pizza(6, "Bertil",57,"kød",new String []{"tomatsause", "ost", "bacon", "pepperoni"});

}

