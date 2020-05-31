package algorithms;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import util.Algorithm;

/**
 *
 * @author Uellington Damasceno
 * @since 31/05/2020 :: 00:48
 */
public class InsertionSort extends Algorithm{
    private int separator, pp, value;
    public InsertionSort(int max) {
        super(max);
    }

    @Override
    public boolean isComplete() {
        return this.separator == this.values.length;
    }

    @Override
    public void nextStep() {
        this.value = this.values[separator];
        this.pp = separator - 1;
        while(pp>=0 && this.values[pp] < this.value){
            this.values[pp+1] = this.values[pp];
            this.pp = pp - 1;
        }
        this.values[pp + 1] = this.value;
        this.separator++;
    }

    @Override
    public void render(GraphicsContext graphic) {
       Color color;
        for (int k = 0; k < values.length; k++) {
            if(k == separator){
                color = Color.RED;
            }else if(k == pp){
                color = Color.BLUE;
            }else if(k == value){
                color = Color.BLUEVIOLET;
            }else if(k < separator){
                color = Color.GREEN;
            }else{
                color = Color.WHITE;
            }
            graphic.setStroke(color);
            graphic.strokeLine(k, 0, k, this.values[k]);
        }
    }
    
}
