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



    public static void ingrediensListeOpretter(){

        ingredienserListe = new ArrayList<EkstraIngredienser>();

    }



    public static void familiePizza (int ønsketPizza){
        String Traditional = "Traditionale";
        String Biache = "Biache";
        String Vegetale = "Vegetale";

        if (pizzaMenu.get(ønsketPizza-1).getKategori().equals(Traditional) || pizzaMenu.get(ønsketPizza-1).getKategori().equals(Biache) || pizzaMenu.get(ønsketPizza-1).getKategori().equals(Vegetale)){
            int familieGebyr = 50;
            Scanner userInput = new Scanner(System.in);
            System.out.println("Vælg Str:" );
            System.out.println("Tryk 1 for standard: " + pizzaMenu.get(ønsketPizza-1).getPris() + " kr.");
            System.out.println("Tryk 2 for familie: " + (pizzaMenu.get(ønsketPizza-1).getPris()+familieGebyr) + " kr.");
            int userStørrelse = userInput.nextInt();
            if (userStørrelse == 2 ){
                int familiePris = pizzaMenu.get(ønsketPizza-1).getPris()+familieGebyr;
            }
        }
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
/*
    @Override
    public String toString(){
        return navn + ":   " + pris + " kr.";
    }

 */
}
