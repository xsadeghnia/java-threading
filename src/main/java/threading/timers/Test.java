package threading.timers;

class Printer1 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "> Hello");
    }
}

public class Test {
    public static void main(String[] args) {
        new Timer(1, new Printer1());

        class Printer2 implements Runnable {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "> Bye");
            }
        }
        new Timer(2, new Printer2());

        Runnable r1 = new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "> HELLOOOOOO");
            }
        };
        new Timer(3, r1);

        new Timer(4, new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "> BYEEEEE");
            }
        });

        // Lambda
        new Timer(5, () -> {
            System.out.println(Thread.currentThread().getName() + "> AFIIIIIIIII");
        });
    }
}
