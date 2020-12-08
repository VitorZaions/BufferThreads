package ExercMenin2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// SynchronizedBuffer sincroniza acesso a um único inteiro compartilhado
public class SynchronizedBuffer implements Buffer {

    // Bloqueio para controlar a sincronização com esse buffer
    private Lock accessLock = new ReentrantLock();

    // Condições para controlar a leitura e gravação
    private Condition canWrite = accessLock.newCondition();
    private Condition canRead = accessLock.newCondition();

    // compartilhado pelas threads Producer e Consumer
    private int buffer = -1;
    private boolean occupied = false;   // se o buffer estiver ocupado...

    // Coloca o valor inteiro no buffer
    @Override
    public void set(int value) {
        accessLock.lock();  // bloqueia esse objeto

        // envia informações de thread e de buffer para a saída, então espera
        try {
            while (occupied == true) {
                System.out.println("Produtora tentando escrever no buffer");
                displayState("Buffer cheio. Produtora aguarda...");
                canWrite.await();   // espera até que o buffer esteja vazio
            } // fim do while

            buffer = value; // configura novo valor de buffer

            // indica que a produtora não pode armazenar outro valor
            // até a consumidora recuperar valor atual de buffer
            occupied = true;

            displayState("Produtora escreve " + buffer);

            // sinaliza a thread que está esperando para ler a partir do buffer
            canRead.signal();
        } // fim do try
        catch (InterruptedException exception) {
            exception.printStackTrace();
        } // fim do catch
        finally {
            accessLock.unlock(); // desbloqueia esse objeto
        } // fim do finally       
    } // fim do método set

    // Retorna o valor do buffer
    @Override
    public int get() {
        int readValue = 0; // inicializa valor lido a partir do buffer
        accessLock.lock(); // bloqueia esse objeto

        // envia informações  de thread e de buffer para a saída, então espera
        try {
            // enquanto os dados não são lidos, coloca a thread em estado de espera
            while (!occupied) {
                System.out.println("Consumidora tenta ler do buffer");
                displayState("Buffer vazio. Consumidora aguarda...");
                canRead.await(); // espera até o buffer tornar-se cheio
            } // fim do while

            // indica que a produtora pode armazenar outro valor
            // porque a consumidora acabou de recuperar o valor do buffer
            occupied = false;

            readValue = buffer; // recupera o valor do buffer
            displayState("Consumidora lê " + readValue);

            // sinaliza a thread que está esperando o buffer tornar-se vazio
            canWrite.signal();
        } // fim do try
        // se a thread na espera estiver sido interrompida, imprime o 
        // rastreamento da pilha
        catch (Exception exception) {
            exception.printStackTrace();
        } // fim do catch
        finally {
            accessLock.unlock(); // desbloqueia o objeto
        } // fim do finally

        return readValue;
    } // fim do método get

    public void displayState(String operation) {
        System.out.printf("%-40s%d\t\t%b\n\n", operation, buffer, occupied);
    } // fim do método displayState

} // fim da classe SynchronizedBuffer
