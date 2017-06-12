package cat.torralbo.travessia;

import java.util.Scanner;

/**
 * Creat per davidtorralbo el 26/5/17.
 */
public class Menu {
    public Scanner sc = new Scanner(System.in);
    public Fitxer fitxer = new Fitxer();

    public boolean inicialitza(){
        boolean inicialitzar;

        try {
            fitxer.crear();
            inicialitzar = true;
        } catch(Exception e) {
            inicialitzar = false;
        }

        return inicialitzar;

    }

    public int principal(){
        int seleccio = 0;

        System.out.print("\nMENÚ\n" +
                "————————————————————————————————————————————————\n" +
                "1-Mostrar tots resultats\n" +
                "2-Mostrar resultat per dorsal\n" +
                "3-Estadístiques\n" +
                "\n0-Sortir" +
                "\n————————————————————————————————————————————————\n\n" +
                "Selecció: ");
        try {
            seleccio = Integer.parseInt(sc.nextLine());
        }catch (Exception e){
            System.out.println("Hi ha hagut un problema, seleccioni un nombre.\n");
            subMenus(principal());
        }

        return seleccio;

    }

    public void subMenus(int seleccio){

        switch(seleccio){
            case 1:
                fitxer.mostraTotsResultats();
                subMenus(principal());
                break;
            case 2:
                fitxer.mostraResultatsDorsal();
                subMenus(principal());
                break;
            case 3:
                fitxer.mostraEstadistiques();
                subMenus(principal());
                break;
            case 0:
                System.out.println("Copyright David Torralbo. Gràcies per utilitzar el programa Travessia 1.0");
                System.exit(0);
                break;
            default:
                System.out.println("Error! Ha de seleccionar un nombre del menú.\n");
                subMenus(principal());
                break;
        }
    }
}
