package threading.timers;

public class Timer implements Runnable {

    private Runnable task;
    private int intervalSec;

    public Timer(int intervalSec, Runnable task) {
        if (task == null) {
            throw new IllegalArgumentException("Task should not be null");
        }
        if (intervalSec <= 0) {
            throw new IllegalArgumentException("Invalid interval");
        }
        this.intervalSec = intervalSec;
        this.task = task;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                task.run();
                Thread.sleep(intervalSec * 1000);
            } catch (Throwable throwable) {
                break;
            }
        }
    }
}
