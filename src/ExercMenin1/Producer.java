package ExercMenin1;

// A classe Producer representa a thread Produtora em um relacionamento
// Produtor/Consumidor
import java.util.Random;

// O método run de Producer armazena os valores de 1 a 10 no buffer
public class Producer implements Runnable {

    private static Random generator = new Random(); // gerador de números aleatórios
    private Buffer sharedLocation;  // referência a objeto compartilhado

    // construtor
    public Producer(Buffer shared) {
        sharedLocation = shared;
    } // fim do construtor Producer

    // armazena os valores de 1 a 10 em sharedLocation
    @Override
    public void run() {
        int sum = 0;

        for (int count = 1; count <= 10; count++) {
            try // dorme de 0 a 3 segundos, então coloca valor no buffer
            {
                // a thread dorme... espera sincronizada
                Thread.sleep(generator.nextInt(3000));

                //Atividade exercicio 1
                int randomValue = generator.nextInt(10);

                sharedLocation.set(randomValue);

                if (Services.isPair(count)) {
                    count = count * -1;
                }

                sharedLocation.set(count);// configura o valor no buffer
                sum += count; // incrementa a soma dos valores
                //System.out.printf("\t\t%2d\n", sum); // imprime o somatório
            } // fim do try
            // se a thread adormecida é interrompida, imprime rastreamento de pilha
            catch (InterruptedException exception) {
                exception.printStackTrace();
            } // fim do catch
        } // fim do for

        System.out.printf("\n%s\n%s\n",
                "Produtor terminou a produção de dados",
                "Fim do Produtor!\n");
    } // fim do método run
} // fim classe Producer
