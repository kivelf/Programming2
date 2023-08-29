package opg3;

public class Test {
    public static void main(String[] args) {
        Vare v1 = new Vare(500, "dress", "");
        Vare v2 = new Fødevare(100, "cheese", "", 45);
        Vare v3 = new ElArtikel(200,"mixer","", 800);
        Vare v4 = new ElArtikel(5, "cheap ElArtikel", "just testin'", 5);
        Vare v5 = new Spiritus(20, "Crabbies", "", 4.6);
        Vare v6 = new Spiritus(400, "nice whiskey", "", 40);

        ShoppingCart cart = new ShoppingCart();
        cart.addVare(v1);
        System.out.println(cart.toString());
        System.out.println();

        cart.addVare(v2);
        cart.addVare(v3);
        cart.addVare(v4);
        cart.addVare(v5);
        cart.addVare(v6);
        System.out.println(cart.toString());
    }
}
