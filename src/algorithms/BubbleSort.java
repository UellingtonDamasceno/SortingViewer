package algorithms;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import util.Algorithm;

/**
 *
 * @author Uellington Damasceno
 * @since 30/05/2020
 */
public class BubbleSort extends Algorithm {

    private int i, j;

    public BubbleSort(int max) {
        super(max);
        this.i = 0;
        this.j = 0;
    }

    @Override
    public void render(GraphicsContext graphic) {
        graphic.setStroke(Color.WHITE);
        graphic.setLineWidth(1);
        for (int current = 0; current < values.length; current++) {
            graphic.setStroke((current == j) ? Color.RED : Color.WHITE);
            graphic.strokeLine(current, 0, current, this.values[current]);
        }
    }

    @Override
    public boolean isComplete() {
        return (this.i >= this.values.length - 1);
    }

    @Override
    public void nextStep() {
        j++;
        if (j == (values.length - i) - 1) {
            j = 0;
            i++;
        }
        if (values[j] < values[j + 1]) {
            values[j] += values[j + 1];
            values[j + 1] = values[j] - values[j + 1];
            values[j] -= values[j + 1];
        }
    }

}
