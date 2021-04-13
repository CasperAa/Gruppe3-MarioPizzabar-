import java.util.ArrayList;

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

    /* Denne metode er under opbygning.************************
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
        }
        System.out.println("Den samlede omsætning er: " + omsætning);
    }

     */


}

//omsætning
//PizzaPopoularitet