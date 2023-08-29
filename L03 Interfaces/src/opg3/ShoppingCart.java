package opg3;

import java.util.ArrayList;

public class ShoppingCart {
    ArrayList<Vare> varer = new ArrayList<>();

    public ShoppingCart() {
    }

    public void addVare(Vare vare) {
        varer.add(vare);
    }

    public double getTotalPrice(){
        double total = 0;
        for (Vare v : varer){
            total += v.getTotalPrice();
        }
        return total;
    }

    @Override
    public String toString(){
        String cartString = "Shopping cart\n";
        cartString += "------------------------------\n";
        for (Vare v : varer){
            cartString += "\t" + v.toString() + "\n";
        }
        cartString += "------------------------------\n";
        cartString += "Total: " + getTotalPrice() + " kr.";
        return cartString;
    }
}
