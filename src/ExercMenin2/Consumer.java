package ExercMenin2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Consumer implements Runnable {

    private static Random generator = new Random();
    private Buffer sharedLocation;

    public Consumer(Buffer shared) {
        sharedLocation = shared;
    }

    @Override
    public void run() {

        int primo = 0;
        
        int somatotal = 0;
        
        ArrayList<Integer> primos = new ArrayList<Integer>(5);

        for (int count = 1; count <= 5; count++) {
            try
            {
                primo = sharedLocation.get();
               
                somatotal += primo;                
                primos.add(primo);                
                Collections.sort(primos);                
                for (Integer prim : primos) {                    
                    System.out.println("Primo ordenado : " + prim);
                }
                System.out.println("Soma total dos primos: " + somatotal);
                Thread.sleep(generator.nextInt(3000));
                
            } catch (InterruptedException exception) 
            {                
                exception.printStackTrace();
            }
        }

        System.out.printf("\n%s %d.\n%s\n", "A soma dos valores lidos pelo Consumidor foi ", somatotal,
                "Fim do Consumidor!\n");
    }
}
