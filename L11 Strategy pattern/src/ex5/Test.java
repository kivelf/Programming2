package ex5;

public class Test {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Sugar", 10));
        cart.addItem(new Item("Beers", 40));
        // pay by credit card
        cart.pay(new CreditCardPayment("John Doe", "1234567890123456"));
        // pay by Paypal
        cart.pay(new PaypalPayment("johndoe@example.com", "MyPassword"));
    }
}
