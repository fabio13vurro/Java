package prova;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainProva {
    public static void main(String[] args) {
        PojoExample pojo = new PojoExample();
        pojo.nome = "Anna";
        pojo.cognome = "Annetta";
        pojo.cf = "WERT345TY6GFDER5";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("pojo_out.txt"))){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(pojo);
            System.out.println("Hai generato questo JSON: \n" +json);
            writer.write(json);
        } catch (IOException ex) {
            System.out.println("Errore io");
            ex.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader("pojo_out.txt"))){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = reader.readLine();
            PojoExample pojoExample = gson.fromJson(json, PojoExample.class);
            System.out.println("Hai generato questo JSON: \n" +json);
            System.out.println("L'oggetto letto è: \n" +pojoExample);
        } catch (IOException ex) {
            System.out.println("Errore io");
            ex.printStackTrace();
        }
    }
}