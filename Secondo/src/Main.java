import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 0. Main
    // 1. calcolatrice
    // 2. inizializzazione e ordinamento array
    // 3. inizializzazione e ricerca in array sequenziale
    // 4. inizializzazione e ricerca in array binario

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Calcolatrice");
        System.out.println("2. Ordinamento");
        System.out.println("3. Ricerca sequenziale");
        System.out.println("4. Ricerca binaria");
        System.out.println("Inserisci una scelta");
        int valoreTastiera = scanner.nextInt();
        scanner.nextLine();

        switch(valoreTastiera) {
            case 1:
                Main.calcolatrice(scanner);
                break;
            case 2:
                Main.ordinamentoArray(scanner);
                break;
            case 3:
                Main.ricercaSequenziale(scanner);
                break;
            case 4:
                Main.ricercaBinaria(scanner);
                break;
            default:
                throw new IllegalArgumentException("Valore non valido");
        }

        scanner.close();
    }

    public static void calcolatrice(Scanner scanner){
        System.out.println("1. addizione");
        System.out.println("2. sottrazione");
        System.out.println("3. moltiplicazione");
        System.out.println("4. divisione");
        System.out.println("Inserisci una scelta");
        int scelta = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci primo numero");
        float n1 = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Inserisci secondo numero");
        float n2 = scanner.nextFloat();
        scanner.nextLine();

        switch(scelta){
            case 1:
                float add = n1 + n2;
                System.out.printf("Somma = %.2f\n", add);
                break;
            case 2:
                float sott = n1 - n2;
                System.out.printf("Sottrazione = %.2f\n", sott);
                break;
            case 3:
                float molt = n1 * n2;
                System.out.printf("Moltiplicazione = %.2f\n", molt);
                break;
            case 4:
                if(n2 == 0)
                    throw new IllegalArgumentException("Divisione per 0");

                float div = n1 / n2;
                System.out.printf("La divisione è %.2f\n", div);
                break;
            default:
                throw new IllegalArgumentException("Valore non valido");
        }
    }

    public static void ordinamentoArray(Scanner scanner) {
        System.out.println("Inserisci dimensione");
        int n = scanner.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = Math.round(Math.random()*100);
        }

        System.out.println("Stampa iniziale");
        for (long val:array){
            System.out.print(val + " ");
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                long minVal = array[i];
                if (minVal > array[j]) {
                    long temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println();
        System.out.println("Array ordinato");
        for (long val:array){
            System.out.print(val + " ");
        }
    }

    public static void ricercaSequenziale(Scanner scanner){
        System.out.println("Inserisci dimensione");
        int n = scanner.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = Math.round(Math.random()*1000);
        }
        System.out.println("Inserisci valore da cercare");
        long valoreDaCercare = scanner.nextLong();
        boolean trovato = false;
        int i;
        long startTime = System.nanoTime();
        for (i=0; i<n && !trovato; i++){
            if(valoreDaCercare == array[i])
                trovato = true;
        }
        long endTime = System.nanoTime();
        System.out.println("Tempo di esecuzione in ns: " + (endTime - startTime));
        if(trovato)
            System.out.println("Il numero cercato si trova nella posizione " + i);
        else
            System.out.println("Il numero cercato non è presente nell'array");
    }

    public static void ricercaBinaria(Scanner scanner) {
        System.out.println("Inserisci dimensione");
        int n = scanner.nextInt();
        long[] array = new long[n];

        for (int i = 0; i < n; i++) {
            array[i] = Math.round(Math.random() * 1000);
        }

        // Ordina l'array prima della ricerca
        Arrays.sort(array);

        System.out.println("\nArray ordinato:");
        for (long val : array) {
            System.out.print(val + " ");
        }

        System.out.println("\nInserisci valore da cercare");
        long valoreDaCercare = scanner.nextLong();
        scanner.nextLine();

        long startTime = System.nanoTime();

        // Implementazione corretta della ricerca binaria
        int left = 0;
        int right = array.length - 1;
        boolean trovato = false;
        int posizione = -1;

        while (left <= right && !trovato) {
            int mid = left + (right - left) / 2;

            if (array[mid] == valoreDaCercare) {
                trovato = true;
                posizione = mid;
            } else if (array[mid] < valoreDaCercare) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Tempo di esecuzione in ns: " + (endTime - startTime));

        if (trovato) {
            System.out.println("Il numero cercato si trova nella posizione " + posizione);
        } else {
            System.out.println("Il numero cercato non è presente nell'array");
        }
    }
}