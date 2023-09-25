package ex2;

public abstract class Dog {
    private EatingBehaviour eatingBehaviour;
    private BarkBehaviour barkBehaviour;

    public Dog(){}

    public abstract void display();

    public void setEatingBehaviour(EatingBehaviour eatingBehaviour) {
        this.eatingBehaviour = eatingBehaviour;
    }

    public void setBarkBehaviour(BarkBehaviour barkBehaviour) {
        this.barkBehaviour = barkBehaviour;
    }

    public void performEating(){
        eatingBehaviour.eat();
    }

    public void performBark(){
        barkBehaviour.bark();
    }

    public void playFetch(){
        System.out.println("All dogs like playing fetch!");
    }
}
