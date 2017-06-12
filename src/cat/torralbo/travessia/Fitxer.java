package cat.torralbo.travessia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Creat per davidtorralbo el 26/5/17.
 */
public class Fitxer {

    public List<Fitxer> ResultatsTravessia = new ArrayList<Fitxer>();
    public File f = new File("src/ResultatsTravessiaEstany.txt");
    public File estadisticaFitxer = new File("src/estadistica.txt");


    private int posicio, dorsal, naixement, classificacioGeneral;
    private String nom, classificacioCategoria, temps, club;
    private double minutsKm;

    public int getPosicio() {
        return posicio;
    }

    public void setPosicio(int posicio) {
        this.posicio = posicio;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getNaixement() {
        return naixement;
    }

    public void setNaixement(int naixement) {
        this.naixement = naixement;
    }

    public int getClassificacioGeneral() {
        return classificacioGeneral;
    }

    public void setClassificacioGeneral(int classificacioGeneral) {
        this.classificacioGeneral = classificacioGeneral;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getClassificacioCategoria() {
        return classificacioCategoria;
    }

    public void setClassificacioCategoria(String classificacioCategoria) {
        this.classificacioCategoria = classificacioCategoria;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public double getMinutsKm() {
        return minutsKm;
    }

    public void setMinutsKm(double minutsKm) {
        this.minutsKm = minutsKm;
    }

    /*
        Passa les dades del text a ArrayList
         */
    public void crear() {

        try {
            //llegim les línies amb Scanner
            Scanner sc = new Scanner(f, "UTF-8");

            //mentre el lector tingui línies...
            while (sc.hasNextLine()) {
                //creem un objecte nou per cada línia.
                Fitxer creaFitxers = new Fitxer();

                String fila = sc.nextLine();
                if (!fila.contains("FI.")) {

                    try {
                        creaFitxers.setPosicio(Integer.parseInt(fila));
                    } catch (Exception e) {
                        creaFitxers.setPosicio(0);
                    }

                    fila = sc.nextLine();

                    try {
                        creaFitxers.setNom(fila);
                    } catch (Exception e) {
                        creaFitxers.setNom(null);
                    }

                    fila = sc.nextLine();

                    try {
                        creaFitxers.setDorsal(Integer.parseInt(fila.substring(2)));
                    } catch (Exception e) {
                        creaFitxers.setDorsal(0);
                    }

                    fila = sc.nextLine();

                    try {
                        creaFitxers.setNaixement(PassaAnysaQuatreXifres(Integer.parseInt(fila)));
                    } catch (Exception e) {
                        creaFitxers.setNaixement(0);
                    }

                    fila = sc.nextLine();

                    try {
                        creaFitxers.setClassificacioGeneral(Integer.parseInt(fila));
                    } catch (Exception e) {
                        creaFitxers.setClassificacioGeneral(0);
                    }

                    fila = sc.nextLine();

                    try {
                        creaFitxers.setClassificacioCategoria(fila);
                    } catch (Exception e) {
                        creaFitxers.setClassificacioCategoria(null);
                    }

                    fila = sc.nextLine();

                    try {
                        creaFitxers.setTemps(fila);
                    } catch (Exception e) {
                        creaFitxers.setTemps(null);
                    }

                    fila = sc.nextLine();

                    try {
                        creaFitxers.setMinutsKm(Double.parseDouble(fila));
                    } catch (Exception e) {
                        creaFitxers.setMinutsKm(0);
                    }

                    fila = sc.nextLine();

                    try {
                        creaFitxers.setClub(fila);
                    } catch (Exception e) {
                        creaFitxers.setClub(null);
                    }

                    ResultatsTravessia.add(creaFitxers);
                }
            }
            //tanquem el fitxer ja que ja no el necessitem...
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
    Passa els anys de dos dígits a quatre dígits.
     */
    public int PassaAnysaQuatreXifres(int dosXifres) {
        int anyquatrexifres = 0;
        int primeraXifra = Integer.parseInt(Integer.toString(dosXifres).substring(0, 1));

        if (primeraXifra != 0) {
            anyquatrexifres = Integer.parseInt("19" + dosXifres);
        } else {
            anyquatrexifres = Integer.parseInt("200" + dosXifres);
        }


        return anyquatrexifres;
    }

    /*
    Mostra tots els resultats de l'arraylist
     */
    public void mostraTotsResultats() {
        System.out.println("==RESULTATS TRAVESSIA ESTANY DE BANYOLES (LOCALS)==");

        for (Fitxer objecte : ResultatsTravessia) {
            System.out.println("\nPOSICIÓ: " + objecte.getPosicio() + "\n" +
                    "NOM: " + objecte.getNom() + "\n" +
                    "DORSAL: " + objecte.getDorsal() + "\n" +
                    "ANY NAIXEMENT: " + objecte.getNaixement() + "\n" +
                    "CLASSIFICACIÓ GENERAL: " + objecte.getClassificacioGeneral() + "\n" +
                    "CLASSIFICACIÓ/CATEGORIA: " + objecte.getClassificacioCategoria() + "\n" +
                    "TEMPS: " + objecte.getTemps() + "\n" +
                    "MINUTS/KM: " + objecte.getMinutsKm() + "\n" +
                    "CLUB: " + objecte.getClub() + "");
        }
    }

    /*
    Mostra els resultats per dorsal
     */
    public void mostraResultatsDorsal() {
        int dorsal = 0;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Quin dorsal vol consultar (0-Sortir)? ");
            dorsal = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Hi ha hagut un error, entri un dorsal...");
            mostraResultatsDorsal();
        }

        if (dorsal != 0) {
            if (consultarDorsal(dorsal)) {
                for (Fitxer objecte : ResultatsTravessia) {
                    if (Integer.parseInt(String.valueOf(objecte.getDorsal())) == dorsal) {
                        System.out.println("\nPOSICIÓ: " + objecte.getPosicio() + "\n" +
                                "NOM: " + objecte.getNom() + "\n" +
                                "DORSAL: " + objecte.getDorsal() + "\n" +
                                "ANY NAIXEMENT: " + objecte.getNaixement() + "\n" +
                                "CLASSIFICACIÓ GENERAL: " + objecte.getClassificacioGeneral() + "\n" +
                                "CLASSIFICACIÓ/CATEGORIA: " + objecte.getClassificacioCategoria() + "\n" +
                                "TEMPS: " + objecte.getTemps() + "\n" +
                                "MINUTS/KM: " + objecte.getMinutsKm() + "\n" +
                                "CLUB: " + objecte.getClub() + "");
                    }
                }
            } else {
                System.out.println("DISCULPI. NO S’HA TROBAT EL DORSAL");
            }
        }

    }

    /*
    Consulta si hi ha un dorsal en concret a l'arraylist
     */
    public boolean consultarDorsal(int dorsal) {
        boolean existeix = false;

        for (Fitxer objecte : ResultatsTravessia) {
            if (Integer.parseInt(String.valueOf(objecte.getDorsal())) == dorsal) {
                existeix = true;
            }
        }

        return existeix;
    }

    public void mostraEstadistiques() {
        System.out.println("\n==ESTADÍSTICA TRAVESSIA ESTANY DE BANYOLES (LOCALS)==\n" +
                "NOMBRE DE PARTICIPANTS: " + ResultatsTravessia.size() + "\n" +
                "1er: " + ResultatsTravessia.get(0).getNom() + " (" + ResultatsTravessia.get(0).getTemps() + ")\n" +
                "2on: " + ResultatsTravessia.get(1).getNom() + " (" + ResultatsTravessia.get(1).getTemps() + ")\n" +
                "3er: " + ResultatsTravessia.get(2).getNom() + " (" + ResultatsTravessia.get(2).getTemps() + ")\n" +
                "Velocitat mitjana: " + calculaVelocitatMitjana() + " minuts/km\n");

        escriureFitxer();
    }

    /*
    Aquest mètode escriu dins el fitxer les estadístiques que segueixen.
     */
    public void estadistiquesaFitxer() {

        try {

                BufferedWriter bw;
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(estadisticaFitxer)));

                bw.write("==ESTADÍSTICA TRAVESSIA ESTANY DE BANYOLES (LOCALS)==\n");
                bw.append("1er: " + ResultatsTravessia.get(0).getNom() + " (" + ResultatsTravessia.get(0).getTemps() + ")\n");
                bw.append("2on: " + ResultatsTravessia.get(1).getNom() + " (" + ResultatsTravessia.get(1).getTemps() + ")\n");
                bw.append("3er: " + ResultatsTravessia.get(2).getNom() + " (" + ResultatsTravessia.get(2).getTemps() + ")\n");
                bw.append("Velocitat mitjana: " + calculaVelocitatMitjana() + " minuts/km");

                bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Comprova que l'arxiu existeixi
     */
    public boolean comprovaExistenciaFitxer(File fitxercomprovar){
        boolean existeix;

        if(fitxercomprovar.exists()){
            existeix = true;
        } else {
            existeix = false;
        }

        return existeix;
    }

    /*
    Preguntarà a l'usuari si vol sobreescriure l'arxiu en cas de que existeixi.
     */
    public void escriureFitxer(){
        Scanner sc = new Scanner(System.in);

        char opcio;

        //si existeix...
        if(comprovaExistenciaFitxer(estadisticaFitxer)){
            try {
                System.out.print("Vols sobreescriure l'arxiu? S/N ");
                opcio = sc.nextLine().toUpperCase().charAt(0);

                switch (opcio) {
                    case 'S':
                        System.out.println("Arxiu sobreescrit!");
                        estadistiquesaFitxer();
                        break;
                    case 'N':
                        System.out.println("L'arxiu no s'ha sobreescrit.");
                        break;
                    default:
                        System.out.println("Seleccioni S o N.");
                        escriureFitxer();
                        break;
                }
            } catch (Exception e){
                escriureFitxer();
            }

        } else {
            estadistiquesaFitxer();
        }
    }

    /*
    Calcula la velocitat mitjana de tots els participants i l'arrodoneix a dos decimals.
     */
    public double calculaVelocitatMitjana() {
        DecimalFormat df = new DecimalFormat(".##", new DecimalFormatSymbols(Locale.US));

        double temps = 0;

        for (Fitxer objecte : ResultatsTravessia) {
            temps = temps + objecte.getMinutsKm();
        }

        //dividim tots els minuts/KM per el nombre de participants
        temps = temps / ResultatsTravessia.size();

        //retornem la mitjana formatada perquè només surtin dos decimals.
        return Double.parseDouble(df.format(temps));
    }


}