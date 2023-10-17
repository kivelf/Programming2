package ex4;

public class NumberEvaluator implements Evaluator {
    /** Returns true, if s contains a valid integer or decimal number. */
    @Override
    public boolean isValid(String s) {
        boolean isValid = false;
        try{
            double number = Double.parseDouble(s);
            isValid = true;
        }
        catch (NullPointerException n){
            System.out.println("Unexpected error: " + n);
            System.out.println("The string is empty!");
        }
        catch (NumberFormatException nb){
            System.out.println("Unexpected error: " + nb);
            System.out.println("The string does not contain a parsable number!");
        }
        return isValid;
    }
}
