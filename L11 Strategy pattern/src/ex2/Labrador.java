package ex2;

public class Labrador extends Dog {
    public Labrador(EatingBehaviour eatingBehaviour, BarkBehaviour barkBehaviour){
        this.setEatingBehaviour(eatingBehaviour);
        this.setBarkBehaviour(barkBehaviour);
    }

    @Override
    public void display(){
        System.out.println("Looks and smells like a lab.");
    }
}
