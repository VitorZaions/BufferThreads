package ExercMenin5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int TOTALLIMIT = 2;

    public static void main(String[] args) {
        
        List<Integer> Ordered = listShuffler(TOTALLIMIT );
       
        // Print Ordered
        System.out.println(Ordered);
        
        ExecutorService App = Executors.newFixedThreadPool(TOTALLIMIT );
        
        // Create Account With 20k
        Conta conta = new Conta(20000.0);
        
        synchronized (App) 
        {
            synchronized (conta) 
            {
                for (int i = 0; i < TOTALLIMIT ; i++) 
                {
                    if (Ordered.get(i) % 2 == 0) 
                    {
                        App.execute(new Credito(conta));
                    } 
                    else if (Ordered.get(i) % 2 == 1) {
                        App.execute(new Debito(conta));
                    }
                }
            }
        }
    }

    public static List<Integer> listShuffler(int limit) 
    {
        List<Integer> Ordered = new ArrayList<Integer>();

        for (int i = 1; i <= limit; i++) 
        {
            Ordered.add(i);
        }
        Collections.shuffle(Ordered);

        return Ordered;
    }
}
