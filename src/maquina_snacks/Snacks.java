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
        this.id = UUID.randomUUID().toString();

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
        String shortId = id.length() > 8 ? id.substring(0, 8) : id;
        return String.format("%-15s %-10.2f %-10s %-5d", name, price, shortId, countSnack);
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Snacks otherSnack = (Snacks) o;
        return this.id.equals(otherSnack.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void reduceCount(){
        this.countSnack --;
    }

}
