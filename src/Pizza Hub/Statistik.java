import org.w3c.dom.ls.LSOutput;

public class Statistik {

    int afsluttedeOrdre;
    static int omsætning;

    public static void omsætning() {
        for (int temp: Bestilling.getIndkomst()) {
            omsætning += temp;
        }
        System.out.println(omsætning);
    }


}

//omsætning
//PizzaPopoularitet