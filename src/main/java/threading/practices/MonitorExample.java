package threading.practices;

public class MonitorExample {
    public static void main(String[] args) {
        new Example2().perform();
    }
}

class Example2{
    private int c;
    private Object monitor;
    public void perform(){
        class Test implements Runnable{
            int turn;

            public Test(int turn) {
                this.turn = turn;
            }

            public void run() {
                synchronized (monitor) {
                    while (c != turn) {
                        try {
                            monitor.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(turn);

               synchronized (monitor) {
                   c++;
                   monitor.notifyAll();
               }
            }
        }
        c = 1;
        monitor = new Object();
        new Thread(new Test(3)).start();
        new Thread(new Test(1)).start();
        new Thread(new Test(2)).start();
    }
}