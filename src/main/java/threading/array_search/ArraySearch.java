package threading.array_search;
import java.util.Random;

public class ArraySearch implements Runnable {
    private int start;
    private int end;
    private int key;
    private int[] array;

    public ArraySearch(int start, int end, int key, int[] array) {
        this.start = start;
        this.end = end;
        this.key = key;
        this.array = array;
    }

    public void run() {

                for (int i = start; i <= end; i++) {
                    if (array[i] == key) {
                        System.out.println("Index:"+ i);
                    }
                }

    }


}
