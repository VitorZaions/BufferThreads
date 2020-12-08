package ExercMenin3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExercMenin3 implements Runnable {

    private int Prior;

    public ExercMenin3(int prioridade) {
        this.Prior = prioridade;
    }

    @Override
    public void run() {
        try {
            
            // Pegar data hora hoje
            LocalDateTime DateNow = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            
            // System Out Info Threads
            System.out.println("Meu funcionamento foi em " + dtf.format(DateNow) + ", e minha prioridade foi  " + this.GetPrioridade());
            Thread.currentThread().setPriority(this.GetPrioridade());
            
        } catch (Exception e) 
        {
            //Get Exception
            System.out.println(e.getMessage());
        }
    }

    public int GetPrioridade() {
        return Prior;
    }

}
