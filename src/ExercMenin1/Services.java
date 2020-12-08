package ExercMenin1;

public class Services {

    public static boolean isOdd(int value) {
        return (value % 2) != 0 ? true : false;
    }

    public static boolean isPair(int value) {
        return (value % 2) == 0 ? true : false;

    }

    public static boolean isPositive(int value) {
        return value > 0 ? true : false;
    }

    public static boolean isNegative(int value) {
        return value < 0 ? true : false;
    }
}
