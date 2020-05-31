package algorithms;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import util.Algorithm;

/**
 *
 * @author Uellington Damasceno
 * @since 30/05/2020 :: 23:26
 */
public class SelectionSort extends Algorithm {

    private int currentIndex;
    private int lowestValuePosition;

    public SelectionSort(int max) {
        super(max);
        this.currentIndex = 0;
        this.lowestValuePosition = 0;
    }

    @Override
    public boolean isComplete() {
        return this.currentIndex >= this.values.length - 1;
    }

    @Override
    public void nextStep() {
        this.lowestValuePosition = this.currentIndex;
        for (int temp = this.currentIndex + 1; temp < this.values.length; temp++) {
            if (this.values[temp] < this.values[this.lowestValuePosition]) {
                this.lowestValuePosition = temp;
            }
        }
        int aux = this.values[this.lowestValuePosition];
        this.values[this.lowestValuePosition] = this.values[this.currentIndex];
        this.values[this.currentIndex] = aux;
        this.currentIndex++;
    }

    @Override
    public void render(GraphicsContext graphic) {
        Color color;
        for (int i = 0; i < values.length; i++) {
            if (i == this.currentIndex) {
                color = Color.RED;
            } else if (i == this.lowestValuePosition) {
                color = Color.BLUE;
            } else {
                color = Color.WHITE;
            }
            graphic.setStroke(color);
            graphic.strokeLine(i, 0, i, this.values[i]);
        }
    }

}
