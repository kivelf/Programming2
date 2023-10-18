package ureksempel;

// Observer
public class DigitaltUrDisplay implements UrEngineObserver {

    @Override
    public void update(int tid) { // push
        System.out.println("Digitalt " + tid);
    }

//    @Override
//    public void update(UrEngine ur) { // pull
//        int tid = ur.getTid();
//        System.out.println("Digitalt " + tid);
//    }

//    private UrEngine ur;
//
//    public void setUrEngine(UrEngine ur) {
//        this.ur = ur;
//    }
//
//    @Override
//    public void update() { // pull generalized
//        int tid = ur.getTid();
//        System.out.println("Digitalt " + tid);
//    }
}
