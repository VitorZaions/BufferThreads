package ExercMenin5;

import java.util.Random;

public class Debito implements Runnable {

    private Conta account;

    public Debito(Conta account) {
        this.setAccount(account);
    }

    public void run() {

        try {
            for (int i = 0; i < 5; i++) 
            {
                // Sleep Thread
                Thread.sleep(3000);
                
                Random Randomized = new Random();
                int randomdebit = Randomized.nextInt(10001);
                
                System.out.println("Valor Saldo Debito Total: " + getAccount().getSaldo());
                
                getAccount().CreditRemove(Double.valueOf(randomdebit));
                
                System.out.println("Debito Aleatório: " + randomdebit);
                
                System.out.println("Total value Debit: " + getAccount().getSaldo());
                
            }
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }

    }

    public Conta getAccount() 
    {
        return account;
    }

    public void setAccount(Conta account) 
    {
        this.account = account;
    }

}
