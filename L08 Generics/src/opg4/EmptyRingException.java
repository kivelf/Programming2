package opg4;

public class EmptyRingException extends RuntimeException {
    public EmptyRingException(String s, Throwable cause){
        // call the constructor of parent Exception class with error message and cause
        super(s, cause);
    }

    public EmptyRingException(String s){
        // call the constructor of parent Exception class
        super(s);
    }
}
