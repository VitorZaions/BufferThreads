package ExercMenin2;

import java.util.Random;

public class Producer implements Runnable {

    private static Random generator = new Random();
    private Buffer sharedLocation;

    // construtor
    public Producer(Buffer shared) {
        sharedLocation = shared;
    }

    @Override
    public void run() {
        for (int count = 1; count <= 5;) {
            try {
                
                Random CreateRandom = new Random();
                
                int RandomGenerated = CreateRandom.nextInt(101);   
                
                System.out.println("O randomNumber é: " + RandomGenerated);
              
                Boolean IsPrimo = isPrimo(RandomGenerated);

                if (IsPrimo) {
                    // É Primo, então continua                    
                    sharedLocation.set(RandomGenerated);                    
                    count++;                    
                    Thread.sleep(generator.nextInt(3000));
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

        System.out.printf("\n%s\n%s\n", "Produtor terminou a produção de dados", "Fim do Produtor!\n");
    }

    public Boolean isPrimo(int primo) {
        boolean isPrimo = true;
        int divisor = 0;
        for (int i = 2; i <= primo; i++) {
            if (((primo % i) == 0) && (i != primo)) {
                isPrimo = false;
                divisor = i;
                break;
            }
        }
        if (isPrimo) {
            System.out.println(" Primo");
        } else {
            System.out.println("Não é Primo --> " + divisor);
        }
        return isPrimo;
    }
}
