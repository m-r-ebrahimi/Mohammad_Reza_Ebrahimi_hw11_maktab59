package Q1;

import java.util.List;

public class EvenThread implements Runnable {
    private int number;
    private List<Integer> list;

    public EvenThread(int number, List<Integer> list) {
        this.number = number;
        this.list = list;
    }


    @Override
    public void run() {
        Finder finder = new Finder(number);
        List<Integer> evens = finder.findEvens();
        synchronized (list) {
            while (!evens.isEmpty()) {
                if (list.size() == 0) {
                    list.add(evens.remove(0));
                    list.notify();
                }
                while (list.get(list.size() - 1) % 2 == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(evens.remove(0));
                list.notify();
            }

        }
    }
}
