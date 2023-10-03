package ex5;

public class PaypalPayment implements Payment{
    private String mail;
    private String password;

    // constructor
    public PaypalPayment(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    @Override
    public void pay(int amount){
        System.out.println("Paid using Paypal: " + amount);
    }
}
