package opg1;

public class App {
    public static void main(String[] args) {
        Chili c1 = new Chili("Sweet paprika", 1);
        Chili c2 = new Chili("Chimayo chili", 5);
        Chili c3 = new Chili("Ancho chili", 3);
        Chili c4 = new Chili("Tabasco chili", 9);
        Chili c5 = new Chili("Cayenne chili", 6);

        Measurable[] measurableObjects1 = new Measurable[]{c1, c2, c3, c4, c5};
        System.out.println("The strongest chili is " + ((Chili)max(measurableObjects1)).getName());
        System.out.println("The average strength is " + average(measurableObjects1));

        Beer b1 = new Beer("Shumensko Dark", 5.5);
        Beer b2 = new Beer("Crabbies", 4.8);
        Beer b3 = new Beer("Staropramen", 5);
        Beer b4 = new Beer("Red Erik", 3.5);
        Beer b5 = new Beer("Guinness", 4.2);
        Measurable[] measurableObjects2 = new Measurable[]{b1, b2, b3, b4, b5};

        Measurable[] blackFridayMeal = blackFridayMeal(measurableObjects1, measurableObjects2);
        System.out.println("Black Friday meal: " + ((Chili)blackFridayMeal[0]).getName()
                + " and " + ((Beer)blackFridayMeal[1]).getName());

        ChiliFilter filteringChilies = new ChiliFilter();
        System.out.println("The average strength above 5000 is " + average(measurableObjects1, filteringChilies));
    }

    /** Pre: the array is not empty. */
    public static double average(Measurable[] objects) {
        double total = 0;
        int count = 0;
        for (Measurable m : objects){
            total += m.getMeasure();
            count++;
        }
        return total / count;
    }

    /** Pre: the array is not empty. */
    public static double average(Measurable[] objects, ChiliFilter cf) {
        double total = 0;
        int count = 0;
        for (Measurable m : objects){
            if (cf.accept(m)){              // if the chili is accepted by the filter
                total += m.getMeasure();
                count++;
            }
        }
        return total / count;
    }

    /** Pre: the array is not empty. */
    public static Measurable max(Measurable[] objects) {
        Measurable max = objects[0];
            for (int i = 1; i < objects.length; i++) {
                if (objects[i].getMeasure() > max.getMeasure()) {
                    max = objects[i];
                }
            }
        return max;
    }

    /** Pre: the arrays are not empty. */
    public static Measurable[] blackFridayMeal(Measurable[] chilies, Measurable[] beers) {
        return new Measurable[]{max(chilies), max(beers)};
    }
}
