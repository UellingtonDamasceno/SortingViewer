package view;

import algorithms.InsertionSort;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Visualizator;
import model.Loop;
import util.Algorithm;

/**
 *
 * @author Uellington Damasceno
 * @since 29/05/2020
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Algorithm algorithm = new InsertionSort(400);
        Visualizator app = new Visualizator("Algorithms Visualizator", 400, algorithm);
        Loop gameLoop = new Loop(app, 30);

        Scene scene = new Scene(new Pane(app.getCanvas()));
        primaryStage.setScene(scene);
        primaryStage.setTitle(app.getName());
        primaryStage.show();
        gameLoop.start();
        primaryStage.setOnCloseRequest(event -> gameLoop.stop());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
