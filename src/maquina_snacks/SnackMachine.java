package maquina_snacks;

import java.util.HashMap;

public class SnackMachine implements messegesExceptions {
    private final HashMap<String, Snacks> stock;

    public SnackMachine(){
        this.stock = new HashMap<>();
    }

    public void showStock(){
        for(Snacks valor : stock.values()){
            valor.toString();
        }
    }





    public void addSnack (Snacks s){
        stock.put(s.getId(),s);
    }

    public Snacks findSnack(String id){
        if(stock.isEmpty()){
            showNoSnack();
        }else{
            return stock.get(id);
        }
        return null;
    }





}
