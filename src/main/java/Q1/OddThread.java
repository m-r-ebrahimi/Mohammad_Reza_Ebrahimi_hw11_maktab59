package Q1;

import java.util.List;

public class OddThread implements Runnable {
    private int number;
    private List<Integer> list;

    public OddThread(int number, List<Integer> list) {
        this.number = number;
        this.list = list;
    }


    @Override
    public void run() {
        Finder finder = new Finder(number);
        List<Integer> odds = finder.findOdds();
        synchronized (list) {
            while (!odds.isEmpty()) {
                if (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (list.get(list.size() - 1) % 2 != 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(odds.remove(0));
                list.notify();
            }
        }
    }
}
