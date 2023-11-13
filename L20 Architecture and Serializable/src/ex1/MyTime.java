package ex1;

import java.io.Serializable;

public class MyTime implements Serializable {
    private int time;

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

    @Override
    public String toString(){
        return "Time: " + time;
    }
}
