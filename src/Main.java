import Lab1.Lab1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var arr = new ArrayList<Integer>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(3);
        arr.add(6);
        arr.add(7);
        arr.add(0);

        IO.println(Lab1.removeElementInplace(arr, 0));
    }
}