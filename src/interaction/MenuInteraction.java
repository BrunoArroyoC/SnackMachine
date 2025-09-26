package interaction;
import maquina_snacks.SnackMachine;

import java.util.InputMismatchException;
import java.util.Scanner;
public class MenuInteraction implements messegesExceptions {
    final Scanner sc;
    public MenuInteraction (){
        sc = new Scanner(System.in);
    }



    public void menuInteraction(SnackMachine snackMachine){
        int option = 0;
        while(option != 4){

            System.out.println("""
                    \t ===Snack Machine === 
                    \t 1. Show the Snacks 
                    \t 2. Buy Snacks
                    \t 3. Find Snacks
                    \t 4. Exit
                    \n""");
            do {
                try {
                    System.out.print("Choose the option: ");
                    System.out.println();
                    option = sc.nextInt();
                    sc.nextLine();
                    break;
                }catch (InputMismatchException e){
                    incorrectOption();
                    sc.nextLine();
                }
            }while(true);

            switch (option){
                case 1:
                    snackMachine.showStock();
                break;
                case 2:
                    snackMachine.showStock();
                    System.out.print("Type the snack ID:  ");
                    String idAux = sc.nextLine();
                    snackMachine.buySnack(idAux);
                    break;
                case 3:
                    snackMachine.showStock();
                    System.out.print("Type the snack ID:  ");
                    String idAux2 = sc.nextLine();
                    snackMachine.findStock(idAux2);
                    break;


                case 4:
                    System.out.println("Exit ...");
                break;

            }

        }
    }

}
