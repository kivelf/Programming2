package ex5;

public class CreditCardPayment implements Payment{
    private String name;
    private String creditCardNr;

    // constructor
    public CreditCardPayment(String name, String creditCardNr) {
        this.name = name;
        this.creditCardNr = creditCardNr;
    }

    @Override
    public void pay(int amount){
        System.out.println("Paid with credit card: " + amount);
    }
}
