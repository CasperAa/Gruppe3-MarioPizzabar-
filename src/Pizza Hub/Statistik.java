import java.util.ArrayList;
import java.util.Scanner;

public class Statistik {

    //Dataen bliver hentet fra afsluttede ordrer, så der kan først laves statistik, når der er blevet slettet ordrer
    //fra alleOrdrer.


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
        int count2 = 0;
        for (int p = 1; p <= Pizza.getPizzaMenu().size(); p++) {
            int count = 0;

            for (int i = 0; i < Bestilling.færdiggjorteOrdrer.size(); i++) {
                for (int j = 0; j < Bestilling.færdiggjorteOrdrer.get(i).size(); j++) {
                    if (Bestilling.færdiggjorteOrdrer.get(i).get(j).getNummer() == p) {
                        count++;
                        count2++;
                    }

                }

            }
            if (count > 1 && !Pizza.getPizzaMenu().get(p).getKategori().contains("Sandwich")) {
                System.out.println("Pizza nr. " + p + " er blevet købt " + count + " gange.");
            } else if (count == 1 && !Pizza.getPizzaMenu().get(p).getKategori().contains("Sandwich")) {
                System.out.println("Pizza nr. " + p + " er blevet købt " + count + " gang.");
            } else if (count > 1 && Pizza.getPizzaMenu().get(p).getKategori().contains("Sandwich")) {
                System.out.println("Sandwich nr. " + p + " er blevet købt " + count + " gange.");
            } else if (count == 1 && Pizza.getPizzaMenu().get(p).getKategori().contains("Sandwich")) {
                System.out.println("Sandwich nr. " + p + " er blevet købt " + count + " gang.");
            }
        }
        System.out.println("I alt er der blevet solgt " + count2 + " pizzaer/sandwich.");
    }

    public static void statsistikEfterDato() {
        System.out.println("Se ordrer fra /enet bestemt\n1: år\n2: måned\n3: dato");
        Scanner userInput = new Scanner(System.in);
        String valg;
        String år;
        String måned;
        String dag;
        valg = userInput.nextLine();

        switch (valg) {

            case "1":
                System.out.println("Hvilket år ønsker du at se data fra?");
                år = userInput.nextLine();
                System.out.println("Alle ordrer fra år " + år + ":");
                for (ArrayList<Pizza> ordre : Bestilling.færdiggjorteOrdrer) {
                    if (ordre.get(ordre.size() - 1).getKommentar().substring(6, 10).contains(år)) {
                        System.out.println(ordre.toString());
                    }
                }
                break;
            case "2":               //opret ny order
                System.out.println("Hvilket år ønsker du at se data fra?");
                år = userInput.nextLine();
                System.out.println("Hvilken måned ønsker du at se data fra?");
                måned = userInput.nextLine();
                for (ArrayList<Pizza> ordre : Bestilling.færdiggjorteOrdrer) {
                    if (ordre.get(ordre.size() - 1).getKommentar().substring(6, 10).contains(år) && ordre.get(ordre.size() - 1).getKommentar().substring(3, 5).contains(måned)) {
                        System.out.println(ordre.toString());
                    }
                }
                break;

            case "3":                //vis forberedelserækkefølge
                System.out.println("Hvilket år ønsker du at se data fra? (YYYY)");
                år = userInput.nextLine();
                System.out.println("Hvilken måned ønsker du at se data fra? (MM)");
                måned = userInput.nextLine();
                System.out.println("Hvilken dato ønsker du at se data fra? (DD)");
                dag = userInput.nextLine();
                for (ArrayList<Pizza> ordre : Bestilling.færdiggjorteOrdrer) {
                    if (ordre.get(ordre.size() - 1).getKommentar().substring(6, 10).contains(år) && ordre.get(ordre.size() - 1).getKommentar().substring(3, 5).contains(måned) && ordre.get(ordre.size() - 1).getKommentar().substring(0, 2).contains(dag)) {
                        System.out.println(ordre.toString());
                    }
                }

                break;
        }


    }

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