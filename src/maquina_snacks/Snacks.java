package maquina_snacks;

import java.util.Objects;
import java.util.UUID;

public class Snacks {
    private String name;
    private String id;
    private double price;
    private int countSnack;

    public Snacks(String name, double price, int countSnack){
        this.name=name;
        this.price=price;
        this.countSnack = countSnack;
        this.id = generateId();

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCountSnack() {
        return countSnack;
    }

    public void setCountSnack(int countSnack) {
        this.countSnack = countSnack;
    }

    @Override
    public String toString(){
        return String.format("%-15s %-15.2f %-15d", this.name, this.price,this.countSnack);
    }

    @Override
    public boolean equals(Object o){
        Snacks snacks = (Snacks) o;
        return this.id.equals(snacks.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String generateId (){
        return id = UUID.randomUUID().toString();
    }
}
