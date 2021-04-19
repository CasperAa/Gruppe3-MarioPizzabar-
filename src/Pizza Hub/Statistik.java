import java.util.ArrayList;
import java.util.Collections;

public class Statistik {

    int afsluttedeOrdre;
    //static ArrayList<Integer> pizzaStatistik = Bestilling.getPizzaStatistik();
    int pizzaNummer;
    int købsfrekvens;


    public static int omsætning() {
        int omsætning = 0;
        for (int i = 0; i < Bestilling.tidligereOrdrer.size(); ++i) {
            Bestilling.tidligereOrdrer.get(i);
            for (int j = 0; j < Bestilling.tidligereOrdrer.get(i).size(); ++j) {
                omsætning += Bestilling.tidligereOrdrer.get(i).get(j).getPris();
            }
        }
        return omsætning;
    }

/*
    public static int omsætning() {
        int omsætning = 0;
        for (int temp: Bestilling.getIndkomst()) {
            omsætning += temp;
        }
        return omsætning;
    }

 */
/*
    //Den virker ikke :(
    public static int omsætning() {
        int omsætning = 0;
        for (ArrayList<ArrayList> temp: Bestilling.tidligereOrdrer) {
            for (Pizza temp2: Bestilling.pizzaOrder) {
                omsætning += Pizza.getPris();
            }
        }
        return omsætning;
    }

 */

    /*
    public static int mestPopulærePizza() {
        int temp= 0;
        int tempCount = 0;
        int count = 1;
        int popular = 0;
        for (int i = 0; i < (pizzaStatistik.size()); i++)
        {
            temp = pizzaStatistik.get(i);
            tempCount = 0;
            for (int j = i+1; j < pizzaStatistik.size(); j++)
            {
                if (temp == pizzaStatistik.get(j))
                    tempCount++;
            }
            if (tempCount > count)
            {
                popular = temp;
                count = tempCount;
            }
        }
        return popular;
    }

     */

/*
    public static void pizzaFrekvensPrinter() {
        for (int i = 1; i < (Pizza.getPizzaMenu().size()); i++)
        {
            int occurence = Collections.frequency(pizzaStatistik, i);
            if (occurence > 1){
                System.out.println("Pizza nr. " + i + " er blevet købt " + occurence + " gange.");
            }
            else if (occurence == 1){
                System.out.println("Pizza nr. " + i + " er blevet købt " + occurence + " gang.");
            }

        }
    }

 */

  /*
    public static ArrayList<Statistik> pizzaFrekvensListe() {
        for (int i = 1; i < (Pizza.getPizzaMenu().size()); i++)
        {
            int occurence = Collections.frequency(pizzaStatistik, i);
            Statistik temp = new Statistik(i, occurence);
            pizzaTæller.add(temp);
        }

        return pizzaTæller;
    }

   */

    static private ArrayList <Statistik> pizzaTæller = new ArrayList<Statistik>();;
/*
    //Constructor
    public Statistik(int pizzaNummer, int købsfrekvens) {
        this.pizzaNummer = pizzaNummer;
        this.købsfrekvens = købsfrekvens;
    }

    public static void printTidligereOrdrer(){
        System.out.println(Bestilling.tidligereOrdrer.toString());
    }

 */

}

/*
    public static void mestPopulærePizza() {
        ArrayList tempOrdre;
        int tempCount;
        Pizza tempPizza;
        int tempNumber;
        for (int i = 0; i < (Bestilling.ordrer.size() - 1); i++)
        {
            tempOrdre = Bestilling.ordrer.get(i);
            tempCount = 0;

            for (Object temp : tempOrdre)
            {
                Pizza.getNummer();
                tempCount = 0;
                for (int j = i+1; j < characterList.size(); j++)
                {
                    if (characterList.get(j).getSpecies().equals(temp))
                        tempCount++;
                }
                if (tempCount > count)
                {
                    popular = temp;
                    count = tempCount;
                }
            }
            return popular;
        }


            for (int j = i+1; j < characterList.size(); j++)
            {
                if (characterList.get(j).getSpecies().equals(temp))
                    tempCount++;
            }
            if (tempCount > count)
            {
                popular = temp;
                count = tempCount;
            }
        }
        return popular;
    }

    /*
        }
        System.out.println("Den samlede omsætning er: " + omsætning);
    }

 */



//omsætning
//PizzaPopoularitet