package maquina_snacks;

public class test {
    public static void main(String[] args) {

        Snacks s1 = new Snacks("Galletas", 12.23,12);
        Snacks s2 = new Snacks("Papas", 21.43,20);

        SnackMachine m1 = new SnackMachine();
        m1.addSnack(s1);
        m1.addSnack(s2);


        m1.showStock();
    }
}
