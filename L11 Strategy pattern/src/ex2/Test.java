package ex2;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Labrador(new NormalDiet(), new PlayfullBark());
        dog.performBark();
        dog.performEating();
        System.out.println();

        dog.setBarkBehaviour(new Growl());
        dog.setEatingBehaviour(new ProteinDiet());
        dog.performBark();
        dog.performEating();
    }
}
