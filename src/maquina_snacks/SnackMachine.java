package maquina_snacks;
import java.util.Scanner;
import java.util.HashMap;

public class SnackMachine implements messegesExceptions {
    private final HashMap<String, Snacks> stock;
    final Scanner sc;
    public SnackMachine(){
        this.stock = new HashMap<>();
        sc = new Scanner(System.in);
    }

    public void showStock(){
        System.out.printf("%-15s %-10s %-10s %-5s%n", "Nombre", "Precio", "ID", "Cant");
        stock.values().forEach(snack -> System.out.println(snack));
    }

    public void addStock(Snacks snacks){
       stock.put(snacks.getId(),snacks);
    }

    public Snacks removeStock(String id){
        if(stock.isEmpty()){
            showNoSnack();
            return null;
        }
        Snacks snack = stock.get(id);
        stock.remove(id);
        System.out.println("Snack eliminated");   //Todavia falta que pasaria si no se encunetra el id
        return snack;

    }

    public String findStock(String id){
        if(stock.isEmpty()){
            showNoSnack();
            return null;
        }
        Snacks s = stock.get(id);
        System.out.println("Snack found it"); //Todavia falta que pasaria si no se encunetra el id
        return s.toString();
    }

    public void buySnack(String id){
        if(stock.isEmpty()){
            showNoSnack();
        }
        Snacks snack = stock.get(id);
        if(snack == null){
            notFoundSnack();   //Todavia falta que pasaria si no se encunetra el id
        }else{
            System.out.println("El total es de: " + snack.getPrice());
            snack.reduceCount();
        }
        while (snack != null) {
            try {
                System.out.println("Le gustaria el ticket? ");
                String op = sc.nextLine().toUpperCase().trim();
                if (op.equals("SI")) {
                    snack.toString();
                    break;
                } else {
                    System.out.println("Thank you for you purchase");
                    break;
                }
            }catch (IllegalArgumentException e){
                System.out.println("Wrong option. Try again");
                sc.nextLine();
            }
        }
    }







}
