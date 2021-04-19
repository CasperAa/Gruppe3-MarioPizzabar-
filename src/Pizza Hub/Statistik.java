import java.util.ArrayList;

public class Statistik {

    int afsluttedeOrdre;
    //static ArrayList<Integer> pizzaStatistik = Bestilling.getPizzaStatistik();
    int pizzaNummer;
    int købsfrekvens;


    public static int omsætning() {
        int omsætning = 0;
        for (int i = 0; i < Bestilling.færdiggjorteOrdrer.size(); ++i) {
            Bestilling.færdiggjorteOrdrer.get(i);
            for (int j = 0; j < Bestilling.færdiggjorteOrdrer.get(i).size(); ++j) {
                omsætning += Bestilling.færdiggjorteOrdrer.get(i).get(j).getPris();
            }
        }
        return omsætning;
    }

    public static String mestPopulærePizza() {
        int tempPizza = 0;
        int tempCount = 0;
        int count = 1;
        int popular = 0;
        if (popular != 0) {
            for (int i = 0; i < Bestilling.færdiggjorteOrdrer.size(); i++) {
                for (int j = 0; j < Bestilling.færdiggjorteOrdrer.get(i).size(); j++) {
                    tempPizza = Bestilling.færdiggjorteOrdrer.get(i).get(j).getNummer();
                    tempCount = 0;

                    if (tempPizza == Bestilling.færdiggjorteOrdrer.get(j).get(j).getNummer())
                        tempCount++;
                }
                if (tempCount > count) {
                    popular = tempPizza;
                    count = tempCount;
                }
            }
            return "nr. " + popular;
        }
        return "ikke afgjort";
    }


    public static void pizzaFrekvensPrinter() {
        for(int p = 1; p <= Pizza.getPizzaMenu().size(); p++){
            int count = 0;

            for (int i = 0; i < Bestilling.færdiggjorteOrdrer.size(); i++) {
                for (int j = 0; j < Bestilling.færdiggjorteOrdrer.get(i).size(); j++) {
                    if (Bestilling.færdiggjorteOrdrer.get(i).get(j).getNummer() == p) {
                        count ++;
                    }

                }

            }
            if(count > 1){
                System.out.println("Pizza nr. " + p + " er blevet købt " + count + " gange.");
            } else if (count == 1) {
                System.out.println("Pizza nr. " + p + " er blevet købt " + count + " gang.");
            }
        }
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