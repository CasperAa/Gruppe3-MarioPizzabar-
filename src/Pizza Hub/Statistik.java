import java.util.ArrayList;
import java.util.Collections;

public class Statistik {

    int afsluttedeOrdre;
    static ArrayList<Integer> pizzaStatistik = Bestilling.getPizzaStatistik();

    public static int omsætning() {
        int omsætning = 0;
        for (int temp: Bestilling.getIndkomst()) {
            omsætning += temp;
        }
        return omsætning;
    }

    public static int mestPopulærePizza() {
        int temp= 0;
        int tempCount = 0;
        int count = 1;
        int popular = 0;
        for (int i = 0; i < (pizzaStatistik.size() - 1); i++)
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


    public static void pizzaFrekvens() {
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