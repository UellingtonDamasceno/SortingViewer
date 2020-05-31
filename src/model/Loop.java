package model;

import javafx.application.Platform;

/**
 *
 * @author Uellington Conceição
 * @since 09/05/2020
 * @version 0.3
 */
public class Loop implements Runnable {

    private final double FRAMES;
    private final double INTERVAL;
    private final Thread thread;
    private boolean isRunning;

    private final DrawableApplication application;

    public Loop(DrawableApplication application){
        this(application, 60);
    }
    
    public Loop(DrawableApplication application, double frames) {
        this.FRAMES = frames;
        this.thread = new Thread(this);
        this.application = application;
        this.isRunning = false;
        this.INTERVAL = 1000000000 / FRAMES;
    }

    public synchronized void start() {
        this.thread.start();
    }

    public synchronized void stop() {
        this.isRunning = false;
    }

    @Override
    public void run() {
        this.isRunning = true;

        double delta = 0;
        long lastTime = System.nanoTime();

        long now;

        while (isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / INTERVAL;
            lastTime = now;
            if (delta >= 1) {
                Platform.runLater(() -> {
                    this.application.clear();
                    this.application.update();
                });
                delta--;
            }
        }
    }

}
