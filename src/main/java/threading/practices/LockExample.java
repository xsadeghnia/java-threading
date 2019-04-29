package threading.practices;

public class LockExample {
    public static void main(String[] args) {
        new Example().start();
        
    }

}

class Example{

    private int x;
    private Object lock;

    public void start() {

        class Test implements Runnable{

            public void run() {
                synchronized (lock){
                     int temp = x;
                     x = temp + 1;
                }
                System.out.println(x);
            }
        }
        lock = new Object();
        x = 1;
        new Thread(new Test()).start();
        new Thread(new Test()).start();
    }
}
