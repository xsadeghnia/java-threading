package threading.practices;

public class BusyWaitExample {
    public static void main(String[] args) {
        new CounterExample().start();

    }
}
    class CounterExample{
       private int c;

        public void start(){

            class Counter implements Runnable{
                private int turn;

                public Counter(int turn) {
                    this.turn = turn;
                }

                public void run() {
                    while (c != turn){
                        System.out.println("(" + turn +")" + "waiting...");
                    }
                    System.out.println(turn);
                    c++;

                }
            }
            c = 1;
            new Thread(new Counter(3)).start();
            new Thread(new Counter(1)).start();
            new Thread(new Counter(2)).start();
        }
    }

