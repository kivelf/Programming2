package extraHanoi;

public class Hanoi {
    public static void main(String[] args) {
            move(5, 1, 3); // 4 diske fra 1 (=A) til 3 (=C)
    }
        // move n disks from ‘from’ to ‘to’
    public static void move(int n, int from, int to) {
        System.out.println("Total moves: " + move(n, from, to, 0));
    }

    public static int move(int n, int from, int to, int count){
        if (n == 1) {
            System.out.println("Move: " + from + " -> " + to);
            count++;
        } else {
            int other = 6 - from - to;
            count = move(n - 1, from, other, count++);
            System.out.println("Move: " + from + " -> " + to);
            count = move(n - 1, other, to, ++count);
        }
        return count;
    }
}
