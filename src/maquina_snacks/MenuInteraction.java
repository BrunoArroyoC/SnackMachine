package maquina_snacks;
import java.sql.SQLOutput;
import java.util.Scanner;
public class MenuInteraction implements messegesExceptions {
    private final SnackMachine snackMachine;
    final Scanner sc;
    public MenuInteraction (){
        this.snackMachine = new SnackMachine();
        sc = new Scanner(System.in);
    }



    public void menuInteraction(){
        while(true){

            System.out.println("""
                    \t ===Snack Machine === 
                    \t 1. Show the Snacks 
                    \t 2. Buy Snacks
                    \t 3. Find Snacks
                    \t 4. Exit
                    """);
            int option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:
                    this.snackMachine.showStock();
                break;
                case 2:
                    do{
                        try {
                            this.snackMachine.showStock();
                            System.out.print("Type the snack ID:  ");
                            String idAux = sc.nextLine();
                            this.snackMachine.buySnack(idAux);
                            break;
                        }catch (Exception e){
                            notFoundSnack();
                            sc.nextLine();
                        }
                    }while (true);
                case 3:
                    do{
                        try {
                            this.snackMachine.showStock();
                            System.out.print("Type the snack ID:  ");
                            String idAux2 = sc.nextLine();
                            this.snackMachine.findStock(idAux2);
                            break;
                        }catch (Exception e){
                            notFoundSnack();
                            sc.nextLine();
                        }
                    }while (true);
                case 4:
                    System.out.println("Exit ...");

            }

        }
    }







}
