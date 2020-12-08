package ExercMenin4;

public class ThreadTres implements Runnable {

    @Override
    public void run() {
        try {

            Thread.sleep(1000);
            int random = Service.getRandomNumberPairInRange(20, 50);
            System.out.println("Thread 3: " + random);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
