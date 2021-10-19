package Q1;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Finder {
    private final int number;

    public Finder(int number) {
        this.number = number;
    }

    public List<Integer> findOdds() {
        List<Integer> integers = new LinkedList<>();
        for (int i = 1; i <= number; i += 2) {
            integers.add(i);
        }
        return integers;
    }

    public List<Integer> findEvens() {
        List<Integer> integers = new LinkedList<>();
        for (int i = 0; i <= number; i += 2) {
            integers.add(i);
        }
        return integers;
    }
}
