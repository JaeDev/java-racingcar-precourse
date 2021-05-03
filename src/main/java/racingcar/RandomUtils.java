package racingcar;

public class RandomUtils {
    private static int MAX_RANDOM_VALUE = 10;
    public static int getRandomValue() {
        return (int)(Math.random()*MAX_RANDOM_VALUE);
    }
}
