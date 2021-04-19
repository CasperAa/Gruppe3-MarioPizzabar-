import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class PizzaMenu {
    private static final ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();
    private static final ArrayList<EkstraIngredienser> ingredienserListe = EkstraIngredienser.getIngredienseListe();

    //Pizza menuen er printet
    public static void printPizzaMenu() {
        for (Pizza temp : pizzaMenu) {
                System.out.println(temp);
            }
        }

    //Tilberednings rækkefølgen er printet
    public static void printTilberedningsRækkefølge(ArrayList<ArrayList<Pizza>> alleOrdre) {
        int i = 1;
        int j = 0;
        for (ArrayList<Pizza> ordre : alleOrdre) {
            System.out.println("\nOrdre nr. " + i);
            Bestilling.printTime(j);
            i++;
            j++;
            for (Pizza tingIOrdre : ordre) { //Denne skal ændres, så tidspizzaen printes for sig på en logisk måde
                if (!tingIOrdre.getType().contains("Tid")) {
                    System.out.println("    Nummer: " + tingIOrdre);
                } else {
                    System.out.println("       " + tingIOrdre);
                }
            }
        }
    }
    public static void sorterListe(ArrayList<ArrayList<Pizza>> alleOrdre) throws ParseException {
        Collections.sort(Bestilling.alleOrdrer, new Comparator<ArrayList<Pizza>>() {

            @Override
            public int compare(ArrayList<Pizza> o1, ArrayList<Pizza> o2) {
                Date date1= null;
                try {
                    date1 = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(o1.get(o1.size()-1).getKommentar());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Date date2= null;
                try {
                    date2 = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(o2.get(o2.size()-1).getKommentar());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (date1.after(date2)) {
                    return 1;
                }

                if (date1.before(date2)) {
                    return -1;
                }

                return date1.compareTo(date2);
            }
        });
    }



    //Ekster ingredienser er printet
    public static void printStandardEkstraIngredienser() {
        for (EkstraIngredienser ingrediens : ingredienserListe) {
            System.out.println( ingrediens.getNummer() +": " + ingrediens.getNavn() + "..... " + ingrediens.getAlm_pris() +" kr");
        }
    }
    public static void printFamilieEkstraIngredienser() {
        for (EkstraIngredienser ingrediens : ingredienserListe) {
            System.out.println(ingrediens.getNummer() +": " + ingrediens.getNavn() + "..... " + ingrediens.getFam_pris() +" kr");
        }
    }





}

