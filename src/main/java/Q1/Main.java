package Q1;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int number = 29;
        List<Integer> complete = new LinkedList<>();
        Thread[] threads = {new Thread(new OddThread(number, complete)), new Thread(new EvenThread(number, complete))};

        for(Thread thread : threads) {
            thread.start();
        }
        for(Thread thread:threads){
            thread.join();
        }

        System.out.println(complete);
    }
}
