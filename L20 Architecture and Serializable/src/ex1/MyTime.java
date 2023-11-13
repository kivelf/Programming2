package ex1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyTime implements Serializable {
    private int time;
    // opg. 2
    private List<String> times = new ArrayList<>();

    // constructor
    public MyTime() {
        this.time = 0;
    }

    public void increase(){
        time++;
    }

    public void reset(){
        time = 0;
    }

    // getter method
    public int getTime() {
        return time;
    }

    // opg.2 gemmer nuværende time i times
    public void saveTime(){
        times.add(this.toString());
    }

    @Override
    public String toString(){
        return "Time: " + time;
    }
}
