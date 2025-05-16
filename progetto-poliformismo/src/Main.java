import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Key, Animale> zoo = new HashMap<>();
        Animale leone1 = new Leone("Simba");
        Animale leone2 = new Leone("Mufasa");
        Animale giraffa = new Giraffa("Giraffa");
        Animale cavallo = new Cavallo("Cavallo");

        zoo.put(new Key("Leone1"), leone1);
        zoo.put(new Key("Leone1"), leone2);
        zoo.put(new Key("Giraffa"), giraffa);
        zoo.put(new Key("Cavallo"), cavallo);

        for(Map.Entry<Key, Animale> entry: zoo.entrySet()){
            System.out.println("Key: " + entry.getKey() + " -> " + entry.getValue());

        }

    }
}