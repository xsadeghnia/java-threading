package threading.array_search;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        final int[] array = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt(20);
        }

        final int key = random.nextInt(20);
        System.out.println("Key:"+ key);
        for (int j = 0; j < 100 ; j++){
            System.out.print(array[j]+",");
        }
        System.out.println();

        for (int i = 0 ; i <10 ; i++){

            new Thread(new ArraySearch((10*i) , ((10*i)+9) ,key, array)).start();

        }


    }
}
