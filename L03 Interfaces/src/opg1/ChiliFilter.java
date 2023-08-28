package opg1;

public class ChiliFilter implements Filter{
    public ChiliFilter() {
    }

    @Override
    public boolean accept(Measurable obj){
        return obj.getMeasure() > 5000;
    }
}
