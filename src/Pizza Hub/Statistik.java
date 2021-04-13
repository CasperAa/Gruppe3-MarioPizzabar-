import org.w3c.dom.ls.LSOutput;

public class Statistik {

    int afsluttedeOrdre;
    static int omsætning;

    //Metoden er midliertidig void, så vi let kan teste den
    public static void omsætning() {
        for (int temp: Bestilling.getIndkomst()) {
            omsætning += temp;
        }
        System.out.println("Den samlede omsætning er: " + omsætning);
    }


}

//omsætning
//PizzaPopoularitet