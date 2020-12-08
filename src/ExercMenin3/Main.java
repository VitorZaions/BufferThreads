package ExercMenin3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) 
    {        
        List<Thread> ThreadsToExecute = new ArrayList<Thread>();

        // Cin Quantidade de threads a criar
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("Olá, digite a quantidade de threads a criar");


        String input = scanner.nextLine();
        int threadCount = Integer.parseInt(input);
        
       // String input = scanner.nextLine();
       // int threadCount = Integer.parseInt(input);
        
        
        List<ExercMenin3> Procc = new ArrayList<ExercMenin3>();
        ExecutorService App = Executors.newFixedThreadPool(threadCount);
        
        // Criar Threads Conforme Escolhido
        for (int i = 0; i < threadCount; i++) 
        {            
            int Prior = GetNumberR(1, 10);
            
            ExercMenin3 processor = new ExercMenin3(Prior);
            
            Procc.add(processor);
        }

        Collections.sort(Procc, (o1, o2) -> o1.GetPrioridade() - o2.GetPrioridade());

        for (ExercMenin3 processor : Procc)  // Create Processor Thread
        {
            Thread thread = new Thread(processor);
            
            ThreadsToExecute.add(thread);
            
            thread.start();
            
        }

        for (Thread t : ThreadsToExecute) { // Join nas threads para que todas acabem
            try 
            {
                ///
                t.join();
            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }

    private static int GetNumberR(int min, int max) {

        if (min >= max) 
        {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random GetRandomN = new Random();
        return GetRandomN.nextInt((max - min) + 1) + min;
    }
}
