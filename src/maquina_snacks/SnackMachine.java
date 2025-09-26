package maquina_snacks;
import domain.Snacks;
import interaction.messegesExceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import java.time.LocalDateTime;
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
        askForTicket(snack);
    }

    public void askForTicket(Snacks snack){
        while (true) {
            System.out.print("Do you need the ticket YES/NO:  ");
            String op = sc.nextLine().toUpperCase().trim();
            if (op.equals("YES")) {
                generateTicketFile(snack);
                break;
            } else if (op.equals("NO")){
                System.out.println("Thank you for you purchase");
                break;
            }else{
                System.out.println("ERROR. Try again option YES/NO");
            }

        }
    }

    public void generateTicketFile(Snacks snack){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("ticket.txt",false))){
            bw.write("=== Ticket ===");
            bw.newLine();
            bw.write("Date: " + LocalDateTime.now());
            bw.newLine();
            bw.write("Snack: " + snack.getName());
            bw.newLine();
            bw.write("Price: " + snack.getPrice());
        }catch (IOException e){
            e.printStackTrace();
        }
    }










}
