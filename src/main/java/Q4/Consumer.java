package Q4;

import java.util.List;

public class Consumer implements Runnable {
    private final List<Book> list;

    public Consumer(List<Book> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (list) {
                while (list.isEmpty()) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Book book = list.remove(0);
                System.out.println("Fetch: " + book);
            }
        }
    }
}
