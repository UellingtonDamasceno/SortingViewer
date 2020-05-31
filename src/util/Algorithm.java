package util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Uelligton Damasceno
 * @since 30/09/2020
 */
public abstract class Algorithm implements Drawable {

    protected Integer[] values;

    public Algorithm(int max){
        this(0, max);
    }
    
    public Algorithm(int min, int max) {
        this.values = this.getRandomValues(min, max);
    }

    public abstract boolean isComplete();

    public abstract void nextStep();

    private Integer[] getRandomValues(int min, int vectorSize) {
        List<Integer> randomValues = Stream
                .iterate(min, i -> i + 1)
                .limit(vectorSize)
                .collect(Collectors.toList());
        Collections.shuffle(randomValues);
        return randomValues.toArray(new Integer[vectorSize]);
    }
}
