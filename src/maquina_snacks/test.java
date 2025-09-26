package maquina_snacks;

import domain.Snacks;
import interaction.MenuInteraction;

public class test {
    public static void main(String[] args) {

        Snacks s1 = new Snacks("Galletas", 12.23,12);
        Snacks s2 = new Snacks("Papas", 21.43,20);

        SnackMachine m1 = new SnackMachine();

        m1.addStock(s1);
        m1.addStock(s2);

        MenuInteraction menu = new MenuInteraction();
        menu.menuInteraction(m1);



    }
}
