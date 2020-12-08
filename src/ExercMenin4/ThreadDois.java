package ExercMenin4;

public class ThreadDois implements Runnable {

    @Override
    public void run() {
        try {

            Thread.sleep(1000);
            int random = Service.getRandomNumberInRange(5, 10);
            System.out.println("Thread 2: " + random);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
