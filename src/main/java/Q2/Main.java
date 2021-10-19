package Q2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new IntSleep());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        if(thread.isInterrupted()){
            thread.stop();
        }
        System.out.println("Interrupted");
    }
}
