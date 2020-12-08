package ExercMenin5;

import java.util.Random;

public class Credito implements Runnable {

    private Conta account;

    public Credito(Conta account) {
        this.setAccount(account);
    }

    public void run() {

        try {
            for (int i = 0; i < 5; i++) 
            {
                // Sleep Thread
                Thread.sleep(3000);
                
                Random Randomized = new Random();

                int RandomizedCredit = Randomized.nextInt(10001);
                
                System.out.println("GetAmount Credit: " + getAccount().getSaldo());
                
                getAccount().CreditAdd(Double.valueOf(RandomizedCredit));
                
                System.out.println("Credito aleatório: " + RandomizedCredit);                
                
                System.out.println("Credito Total: " + getAccount().getSaldo());
            }
        } catch (InterruptedException e) {
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
