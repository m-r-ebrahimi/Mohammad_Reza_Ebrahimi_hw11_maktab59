package Q2;

public class IntSleep implements Runnable {
    @Override
    public void run() {
        while(true){
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
