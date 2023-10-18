package ureksempel;

public class TestObserverUr {

    public static void main(String[] args) {
        UrEngine ur = new UrEngine();
        AnalogtUrDisplay analog = new AnalogtUrDisplay();
        DigitaltUrDisplay digital = new DigitaltUrDisplay();
        ur.addUrObserver(analog);
        ur.addUrObserver(digital);

//        // pull generalized
//        analog.setUrEngine(ur);
//        digital.setUrEngine(ur);

        for (int i = 0; i < 4; i++) {
            ur.tiktak();
            System.out.println();
        }
    }
}
