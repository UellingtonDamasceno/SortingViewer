package model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Uellington Conceição
 * @since 29/05/2020
 * @version 0.4
 */
public abstract class DrawableApplication {

    private final String name;

    protected final double WIDTH;
    protected final double HEIGHT;

    private final Canvas canvas;
    protected GraphicsContext graphic;

    public DrawableApplication(String name, double width, double height) {
        this.name = name;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.canvas = new Canvas(WIDTH, HEIGHT);
        this.graphic = this.canvas.getGraphicsContext2D();
    }

    public final String getName() {
        return this.name;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public abstract void update();

    public final void clear() {
        this.graphic.setFill(Color.BLACK);
        this.graphic.fillRect(0, 0, WIDTH, HEIGHT);
    }
}
