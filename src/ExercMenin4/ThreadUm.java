package ExercMenin4;

public class ThreadUm implements Runnable {

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            int random = Service.getRandomNumberInRange(1, 5);
            System.out.println("Thread 1: " + random);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
