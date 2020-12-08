package ExercMenin4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int LIMITETHREAD = 3;

    public static void main(String[] args) {
      
        List<Integer> ThreadOrder = listShuffler(LIMITETHREAD);

        
        // Out Order
        System.out.println(ThreadOrder);
        ExecutorService application = Executors.newFixedThreadPool(LIMITETHREAD);

        synchronized (application) {
            for (int i = 0; i < LIMITETHREAD; i++) 
            {              
                if (ThreadOrder.get(i) == 1) 
                {
                    application.execute(new ThreadUm());
                } 
                else if (ThreadOrder.get(i) == 2) 
                {
                    application.execute(new ThreadDois());
                } 
                else if (ThreadOrder.get(i) == 3) 
                {
                    application.execute(new ThreadTres());
                }
            }
        }

    }

    public static List<Integer> listShuffler(int limit) 
    {        
        List<Integer> ThreadOrders = new ArrayList<Integer>();

        for (int i = 1; i <= limit; i++) 
        {
            // Add Order
            ThreadOrders.add(i);
        }
        Collections.shuffle(ThreadOrders);
        return ThreadOrders;
    }
}
