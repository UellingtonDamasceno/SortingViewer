package model;

import algorithms.BubbleSort;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import util.Algorithm;

/**
 *
 * @author Uellington Damasceno
 * @since 29/05/2020
 */
public class Visualizator extends DrawableApplication {

    private final Algorithm algorithm;

    public Visualizator(String name, double vertexLenght, Algorithm algorithm){
        this(name, vertexLenght, vertexLenght, algorithm);
    }
    
    public Visualizator(String name, double width, double height,Algorithm algorithm) {
        super(name, width, height);
        this.algorithm = algorithm;
    }

    @Override
    public void update() {
        if (!this.algorithm.isComplete()) {
            this.algorithm.nextStep();
            this.algorithm.render(graphic);
        }
    }

}
