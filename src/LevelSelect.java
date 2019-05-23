import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

/**
 * The LevelSelect class
 * This class represents the LevelSelect window where the user will choose which level they want to play.
 * @author Maria Yampolsky and Vansh Juneja
 * @version 1 05.20.2019
 */
public class LevelSelect extends Window {

    /**
     * The choice selected for the game level that the user wishes to play.
     */
    private int choice;

    /**
     * @param stg The JavaFX Stage to display to.
     */
    public LevelSelect(Stage stg) {
        super(stg, "Level Select");
        choice = 0;
    }

    /**
     * @return The level that the user has chosen to play.
     */
    public int getChoice() {
        display();
        showAndWait();
        refresh();
        return choice;
    }

    /**
     * This method will display all the graphics of the LevelSelect window
     */
    public void display()
    {
        Image background = (Image)(Resources.get("menuBackground"));
        Image playTitle = (Image)(Resources.get("playTitle"));
        Image menuBackgroundLog = (Image)(Resources.get("backLog"));
        ImageView lakeOntario = (ImageView)(Resources.get("lakeOntario"));
        ImageView lakeErie = (ImageView)(Resources.get("lakeErie"));
        ImageView lakeSuperior = (ImageView)(Resources.get("lakeSuperior"));
        ImageView backButton = (ImageView)(Resources.get("backButton"));

        // Listeners for MouseClick
        backButton.setOnMouseClicked(e -> {
            refresh();
            choice = -1;
        });
        lakeOntario.setOnMouseClicked(e -> {
            refresh();
            choice = 1;
        });
        lakeErie.setOnMouseClicked(e -> {
            refresh();
            choice = 2;
        });
        lakeSuperior.setOnMouseClicked(e -> {
            refresh();
            choice = 3;
        });
        // Listeners for MouseEnter
        backButton.setOnMouseEntered(e -> {
            setCursor(true);
        });
        lakeOntario.setOnMouseEntered(e -> {
            setCursor(true);
        });
        lakeErie.setOnMouseEntered(e -> {
            setCursor(true);
        });
        lakeSuperior.setOnMouseEntered(e -> {
            setCursor(true);
        });
        // Listeners for MouseExit
        backButton.setOnMouseExited(e -> {
            setCursor(false);
        });
        lakeOntario.setOnMouseExited(e -> {
            setCursor(false);
        });
        lakeErie.setOnMouseExited(e -> {
            setCursor(false);
        });
        lakeSuperior.setOnMouseExited(e -> {
            setCursor(false);
        });

        drawImage(lakeOntario, -30, 100);
        drawImage(lakeErie, 170, 100);
        drawImage(lakeSuperior, 370, 100);
        drawImage(backButton, -380, -160);

        AnimatedImage standing = (AnimatedImage)(Resources.get("standing"));

        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 300000000.0;

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                // background image clears canvas
                drawImage(background, 0, 0);
                drawImage(menuBackgroundLog, 0, 690);
                drawImage(playTitle, 40, 30);
                drawImage(standing.getFrame(t), -90, 275);

                if (choice != 0) {
                    stop();
                    hideStage();
                }
            }
        }.start();
    }

}
