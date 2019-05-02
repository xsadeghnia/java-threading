package threading.callbacks;

import java.util.Random;

public class CallbackExample {
    public static void main(String[] args) {
        new Example3().perform();

    }
}

interface Callback{
    void proccess(int number);
}

class Example3 implements Callback{

    public void perform(){
        new Thread(new RandomCounter(this)).start();
    }

    @Override
    public void proccess(int number) {
        System.out.println(number);
    }
}

class RandomCounter implements Runnable{
    private Callback callback;
    public RandomCounter(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int number = random.nextInt();
            if (callback != null) {
                callback.proccess(number);
            }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }

    }













































