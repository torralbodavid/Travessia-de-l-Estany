package cat.torralbo.travessia;

/**
 * Creat per davidtorralbo el 26/5/17.
 */
public class Travessia {
    public static void main(String[] args) {

        Menu menu = new Menu();

        //Si al passar l'arxiu a l'ArrayList no hi ha hagut cap problema, el programa s'inicialitzarà.
        if(menu.inicialitza()) {
            menu.subMenus(menu.principal());
        } else {
            System.out.println("Hi ha hagut un error i el programa no pot continuar.");
            System.exit(0);
        }
    }
}
