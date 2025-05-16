//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int s = 0;
        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            s+=i;
        }
        System.out.println("Somma = " + s);

        Sesso maschio = Sesso.MASCHIO;
        System.out.println("Maschio: " +maschio.getValue());
        Sesso femmina = Sesso.FEMMINA;
        System.out.println("Femmina: " + femmina.getValue());
        Sesso niente = Sesso.NIENTE;
        System.out.println("Niente: " + niente.getDbValue());
    }

    public enum Sesso{
        MASCHIO("Maschio", "1"),
        FEMMINA("Femmina", "2"),
        NIENTE("Niente", "3");

        private final String value;
        private final String dbValue;

        Sesso(String value, String dbValue){
            this.value = value;
            this.dbValue = dbValue;

        }

        public String getValue(){
            return value;
        }

        public String getDbValue() {
            return dbValue;
        }
    }
}
