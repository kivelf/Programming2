package sizewithinterface;

public class SizeApp {

    public static void main(String[] args) {
        Dog[] dogs = { new Dog(45), new Dog(30), new Dog(50), new Dog(20) };
        int maxDogSize = max(dogs);
        System.out.println(maxDogSize);

        Country[] countries = { new Country(450), new Country(700), new Country(500) };
        int maxCountrySize = max(countries);
        System.out.println(maxCountrySize);
    }

    /** Pre: Param arr is not empty. */
    static int max(Sizeable[] arr) {
        Sizeable max = arr[0];
        for (Sizeable obj : arr) {
            if (obj.getSize() > max.getSize())
                max = obj;
        }
        return max.getSize();
    }
}

interface Sizeable {
    int getSize();
}

class Dog implements Sizeable {
    private int height;

    public Dog(int height) {
        this.height = height;
    }

    @Override
    public int getSize() {
        return height;
    }
}

class Country implements Sizeable {
    private int area;

    public Country(int area) {
        this.area = area;
    }

    @Override
    public int getSize() {
        return area;
    }
}
