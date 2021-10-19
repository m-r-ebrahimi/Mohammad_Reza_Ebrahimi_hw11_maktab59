package Q4;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Book> list= new LinkedList<>();

        Thread[] threads = {
                new Thread(new Producer(list)),new Thread(new Consumer(list)),
                new Thread(new Producer(list)),new Thread(new Consumer(list))
        };

        for(Thread thread:threads){
            thread.start();
        }

        for(Thread thread:threads){
            thread.join();
        }

        System.out.println("finished, final size: "+list.size());
    }
}
