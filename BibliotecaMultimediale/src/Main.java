import it.its.bibliotecaMultimediale.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int scelta;

        Biblioteca biblioteca = Main.caricaBiblioteca();
        GestionePrestiti gestionePrestiti = new GestionePrestiti();
        GestioneUtenti gestioneUtenti = new GestioneUtenti();

    do {
        System.out.println("Benvenuto nel menù Seleziona: " +
                "\n1. Aggiungi materiale" +
                "\n2. Aggiungi utente" +
                "\n3. Ricerca materiale" +
                "\n4. Richiedi prestito" +
                "\n5. Restituisci prestito" +
                "\n6. Ricerca utente" +
                "\n0. Esci");

        scelta = scanner.nextInt();
        scanner.nextLine();

        switch (scelta) {
            case 1:
                Main.aggiungiMateriale(biblioteca, scanner);
                break;
            case 2:
                Main.aggiungiUtente(gestioneUtenti, scanner);
                break;
            case 3:
                Main.ricercaMateriale(biblioteca, scanner);
                break;
            case 4:
                Main.richiediPrestito(biblioteca, gestioneUtenti, gestionePrestiti, scanner);
                break;
            case 5:
                Main.restituzionePrestito(biblioteca, gestioneUtenti, gestionePrestiti, scanner);
                break;
            case 6:
                Main.ricercaUtente(gestioneUtenti, scanner);
                break;
            case 0:
                System.out.println("Ciao, arrivederci!");
                break;
            default:
                System.out.println("Scelta non valida");
            }
        }while(scelta != 0);
    Main.salvaBiblioteca(biblioteca);
    }

    private static void salvaBiblioteca(Biblioteca biblioteca) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:/JavaPrograms/BibliotecaMultimediale/resource/biblioteca.txt"))){
            for(MaterialeBiblioteca materialeBiblioteca : biblioteca.getCollezioneMateriali()){
                outputStream.writeObject(materialeBiblioteca);
            }
        }catch (IOException ex){
            System.out.println("Eccezione in scrittura");
            ex.printStackTrace();
        }

    }

    private static Biblioteca caricaBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:/JavaPrograms/BibliotecaMultimediale/resource/biblioteca.txt"))){
            MaterialeBiblioteca materialeBiblioteca = null;
            while((materialeBiblioteca = (MaterialeBiblioteca) inputStream.readObject()) != null){
                biblioteca.aggiungiMateriale(materialeBiblioteca);
            }
            System.out.println("Caricati: " + biblioteca.getCollezioneMateriali().size());
            return biblioteca;
        } catch(EOFException eofException){
            System.out.println("End of file raggiunta");
        }catch(IOException | ClassNotFoundException ex){
            System.out.println("Eccezione");
            ex.printStackTrace();
        }finally {
            System.out.println("Questo lo eseguo sempre");
        }
        return biblioteca;
    }

    private static void ricercaUtente(GestioneUtenti gestioneUtenti, Scanner scanner) {
    }

    private static void richiediPrestito(Biblioteca biblioteca, GestioneUtenti gestioneUtenti, GestionePrestiti gestionePrestiti, Scanner scanner) {
    }

    private static void restituzionePrestito(Biblioteca biblioteca, GestioneUtenti gestioneUtenti, GestionePrestiti gestionePrestiti, Scanner scanner) {
    }

    private static void ricercaMateriale(Biblioteca biblioteca, Scanner scanner){
        System.out.println("Per cosa vuoi ricercare il materiale? Seleziona: " +
                "\n1. Titolo" +
                "\n2. Autore" +
                "\n3. Tipo");
        int scelta = scanner.nextInt();
        scanner.nextLine();
        switch(scelta){
            case 1:
                System.out.println("Inserisci il titolo:");
                String titolo = scanner.nextLine();
                try {
                    List<MaterialeBiblioteca> risultato = biblioteca.ricercaElementi(titolo);
                    System.out.println("Risultato: " + risultato);
                } catch (Exception e) {
                    System.out.println("Non ci sono elementi con titolo: " + titolo);
                }
                break;
            case 2:
                System.out.println("Inserisci l'autore/regista");
                Autore autore = Main.acquisisciAutore(scanner);
                try {
                    List<MaterialeBiblioteca> risultato = biblioteca.ricercaElementi(autore);
                    System.out.println("Risultato: " + risultato);
                }catch(Exception e){
                    System.out.println("Non ci sono elementi con autore: " + autore);
                }
                break;
            case 3:
                Map<String, Class<? extends MaterialeBiblioteca>> TIPO_MAP = new HashMap<>();
                TIPO_MAP.put("libro", Libro.class);
                TIPO_MAP.put("dvd", DVD.class);
                TIPO_MAP.put("rivista", Rivista.class);
                System.out.println("Inserisci il tipo da cercare: ");
                String tipo = scanner.nextLine();
                if(tipo == null)
                    throw new IllegalArgumentException("Tipo nullo");
                tipo = tipo.toLowerCase();
                Class<? extends MaterialeBiblioteca> tipoClass = TIPO_MAP.get(tipo);
                if(tipoClass == null)
                    throw new IllegalArgumentException("Tipo non valido");
                List<MaterialeBiblioteca> risultato =  biblioteca.ricercaElementi(tipoClass);
                System.out.println("Risultato: " + risultato + "\n");
                break;
            default:

                break;
        }
    }

    private static void aggiungiUtente(GestioneUtenti gestioneUtenti, Scanner scanner) {
    }

    private static void aggiungiMateriale(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("""
                Cosa vuoi aggiungere? Seleziona:
                1. Libro
                2. DVD
                3. Rivista
                """);

        int scelta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Inserisci id:");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Inserisci il titolo: ");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci l'anno di rilascio: ");
        int annoRilascio = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci la disponibilità: ");
        int disponibilita = scanner.nextInt();
        scanner.nextLine();
        switch(scelta){
            case 1:
                System.out.println("Hai selezionato Libro");
                System.out.println("Inserisci l'ISBN: ");
                String ISBN = scanner.nextLine();
                System.out.println("Inserisci il numero di pagine: ");
                int pagine = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci il nome dell'autore: ");
                Autore autore = Main.acquisisciAutore(scanner);
                Libro libro = new Libro(id, titolo, annoRilascio, disponibilita, ISBN, pagine, autore);
                biblioteca.aggiungiMateriale(libro);
                break;
            case 2:
                System.out.println("Hai selezionato DVD");
                System.out.println("Inserisci il regista: ");
                Autore regista = Main.acquisisciAutore(scanner);
                System.out.println("Inserisci la durata (minuti): ");
                int durata = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci genere");
                String genere = scanner.nextLine();
                DVD.Genere genereEnum = DVD.Genere.lookUp(genere);
                DVD dvd = new DVD(id, titolo, annoRilascio, disponibilita, regista, durata, genereEnum);
                biblioteca.aggiungiMateriale(dvd);
                break;
            case 3:
                System.out.println("Hai selezionato Rivista");
                System.out.println("Inserisci il numero di uscita");
                int numeroUscita = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci periodicità");
                String periodicita = scanner.nextLine();
                Rivista.Periodicita periodicitaEnum = Rivista.Periodicita.lookUp(periodicita);
                Rivista rivista = new Rivista(id, titolo, annoRilascio, disponibilita, numeroUscita, periodicitaEnum);
                biblioteca.aggiungiMateriale(rivista);
                break;

        }
    }

    private static Autore acquisisciAutore(Scanner scanner) {
        System.out.println("Inserisci il nome: ");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il cognome: ");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci la data di nascita nel formato dd/MM/yyyy: ");
        String dataDiNascita = scanner.nextLine();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate dataFormattata = LocalDate.parse(dataDiNascita, format);
            return new Autore(nome, cognome, dataFormattata);
        }catch (DateTimeParseException e) {
            System.out.println("Data non valida");
            return new Autore(nome, cognome, null);
        }
    }
}