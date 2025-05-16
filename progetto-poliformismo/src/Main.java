import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animale> zoo = new ArrayList<>();
        Animale leone1 = new Leone("Simba");
        Animale leone2 = new Leone("Mufasa");
        Animale giraffa = new Giraffa("Giraffa");
        Animale cavallo = new Cavallo("Cavallo");

        zoo.add(leone1);
        zoo.add(leone2);
        zoo.add(giraffa);
        zoo.add(cavallo);


        for(Animale animale : zoo){
            System.out.println(animale.getNomeAnimale());
            animale.faiVerso();
            if(animale instanceof Predatore)
                ((Predatore)animale).vaiACaccia();

        }
    }
}