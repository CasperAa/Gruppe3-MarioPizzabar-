import java.util.ArrayList;

public class EkstraIngredienser {

    private String navn;
    private int pris;
    private int antal;

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
}
