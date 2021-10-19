package Q4;

import java.util.List;

public class Producer implements Runnable {
    private List<Book> list;

    public Producer(List<Book> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (list) {
                Book book = new Book((int) (Math.random() * 1000), (int) (Math.random() * 100000));
                System.out.println("add: " + book);
                list.add(book);
                list.notify();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
