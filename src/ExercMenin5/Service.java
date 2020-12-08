package ExercMenin5;

import java.util.Random;

public class Service {

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    public static int getRandomNumberPairInRange(int min, int max) {
        int random = getRandomNumberInRange(min, max);

        if ((random % 2) != 0) {
            if (random == max) {
                random = random - 1;
            } else if (random == min) {
                random = random + 1;
            } else {
                random = random + 1;
            }
        }

        return random;
    }
}
