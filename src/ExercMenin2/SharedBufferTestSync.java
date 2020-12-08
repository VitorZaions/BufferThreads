package ExercMenin2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTestSync {

    public static void main(String[] args) {
        // cria novo pool de threads com duas threads
        ExecutorService application = Executors.newFixedThreadPool(2);

        // cria SynchronizedBuffer par armazenar inteiros
        Buffer sharedLocation = new SynchronizedBuffer();

        System.out.printf("%-40s%s\t\t%s\n%-40s%s\n\n", "Operação",
                "Buffer", "Ocupado", "----------", "-------\t\t---------");

        // tenta iniciar a produtora e a consumidora
        try {
            application.execute(new Producer(sharedLocation));
            application.execute(new Consumer(sharedLocation));
        } // fim do try
        catch (Exception exception) {
            exception.printStackTrace();
        } // fim do catch

        application.shutdown();

    } // fim do main
} // fim da classe SharedBufferTestSync
