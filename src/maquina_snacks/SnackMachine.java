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
        if(!stock.containsKey(id)){
            notFoundSnack();
            return null;
        }

        showStock();
        System.out.println();

        Snacks snack = stock.get(id);
        stock.remove(id);
        System.out.println("Snack eliminated");
        return snack;

    }

    public String findStock(String id){
        if(stock.isEmpty()){
            showNoSnack();
            return null;
        }
        if(!stock.containsKey(id)){
            notFoundSnack();
            return "";
        }

        Snacks s = stock.get(id);
        System.out.println("Snack found it");
        return s.toString();
    }

    public void buySnack(String id){
        if(stock.isEmpty()){
            showNoSnack();
            return;
        }

        System.out.println();
        Snacks snack = stock.get(id);

        if(!stock.containsKey(id)){
            notFoundSnack();
            return;
        }

        if(snack.getCountSnack()<= 0){
            stock.remove(snack.getId());
            System.out.println("Sorry this snack is out of stock");
            return;
        }
        System.out.println("Your total is: $"+snack.getPrice());
        snack.reduceCount();
        while (true) {
            try {
                System.out.print("Do you need the ticker YES/NO:  ");
                String op = sc.nextLine().toUpperCase().trim();
                if (op.equals("YES")) {
                    System.out.println(snack.getName() + " " + snack.getPrice());
                    break;
                } else if (op.equals("NO")){
                    System.out.println("Thank you for you purchase");
                    break;
                }
            }catch (Exception e){
                System.out.println("Wrong option. Try again");
                sc.nextLine();
            }
        }
    }









}
