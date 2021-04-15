import java.util.ArrayList;
import java.util.Scanner;


public class EkstraIngredienser {

    private String navn;
    private int pris;

    private static ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();

    //Constructor
    public EkstraIngredienser(String navn, int pris) {
        this.navn = navn;
        this.pris = pris;
    }

    ArrayList<EkstraIngredienser> ingredienserListe = new ArrayList<EkstraIngredienser>();


    public void ingrediensListeOpretter(){
        EkstraIngredienser inEt = new EkstraIngredienser("skinke",10);
        EkstraIngredienser inTo = new EkstraIngredienser("oksefars",10);
        EkstraIngredienser inTre = new EkstraIngredienser("pepperoni",10);
        EkstraIngredienser inFire = new EkstraIngredienser("kødsauce",10);
        EkstraIngredienser inFem = new EkstraIngredienser("bacon",10);
        EkstraIngredienser inSeks = new EkstraIngredienser("oliven",5);
        EkstraIngredienser inSyv = new EkstraIngredienser("ananas", 5);

        ingredienserListe.add(inEt);
        ingredienserListe.add(inTo);
        ingredienserListe.add(inTre);
        ingredienserListe.add(inFire);
        ingredienserListe.add(inFem);
        ingredienserListe.add(inSeks);
        ingredienserListe.add(inSyv);
    }

    public static void familiePizza (int ønsketPizza){
        String Traditional = "Traditional";
        String Biache = "Biache";
        String Vegetale = "Vegetale";

        if (pizzaMenu.get(ønsketPizza-1).getTopping().equals(Traditional) || pizzaMenu.get(ønsketPizza-1).getTopping().equals(Biache) || pizzaMenu.get(ønsketPizza-1).getTopping().equals(Vegetale)){
            int familieGebyr = 50;
            Scanner userInput = new Scanner(System.in);
            System.out.println("Vælg Str:." );
            System.out.println("Tryk 1 for standard: " + pizzaMenu.get(ønsketPizza-1).getPris());
            System.out.println("Tryk 2 for familie: " + (pizzaMenu.get(ønsketPizza-1).getPris()+familieGebyr));
            int userStørrelse = userInput.nextInt();
            if (userStørrelse == 2 ){
                int nyPris = pizzaMenu.get(ønsketPizza-1).getPris()+familieGebyr;
                pizzaMenu.get(ønsketPizza-1).pris = nyPris;
            }
        }
    }
}
