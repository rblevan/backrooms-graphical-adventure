package fr.univpoitiers.backrooms.view;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BackroomsAnimation extends Application {

    private StackPane root;
    private ImageView background;
    private ImageView sprite;
    private Label dialogueBox;

    @Override
    public void start(Stage primaryStage) {
        root = new StackPane();

        // Initialisation du fond (Night City)
        background = new ImageView(new Image(getClass().getResourceAsStream("/images/city_night.png")));
        background.setFitWidth(800);
        background.setFitHeight(600);

        // Initialisation du personnage (Steph)
        sprite = new ImageView(new Image(getClass().getResourceAsStream("/images/steph.png")));
        sprite.setFitHeight(200);
        sprite.setPreserveRatio(true);
        sprite.setTranslateX(-180);
        sprite.setTranslateY(100);

        dialogueBox = new Label("");
        dialogueBox.setStyle("-fx-background-color: white; -fx-padding: 5; -fx-border-color: black;");
        dialogueBox.setVisible(false);
        StackPane.setAlignment(dialogueBox, Pos.CENTER);
        dialogueBox.setTranslateY(100);

        root.getChildren().addAll(background, sprite, dialogueBox);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Backrooms Animation");
        primaryStage.setScene(scene);
        primaryStage.show();

        runScratchLogic();
    }

    // Crée une rotation continue
    private RotateTransition createRotation(double durationSeconds) {
        RotateTransition rt = new RotateTransition(Duration.seconds(durationSeconds), sprite);
        rt.setByAngle(360 * 3); // Fait 3 tours complets
        rt.setInterpolator(Interpolator.LINEAR);
        return rt;
    }

    private void runScratchLogic() {
        // 1. Mouvement et dialogues de départ
        TranslateTransition moveInitial = new TranslateTransition(Duration.seconds(1), sprite);
        moveInitial.setByX(200);

        PauseTransition thinkOh = new PauseTransition(Duration.seconds(1));
        thinkOh.setOnFinished(e -> showDialogue("Oh...", true));

        PauseTransition sayNo = new PauseTransition(Duration.seconds(1));
        sayNo.setOnFinished(e -> showDialogue("NOOOON !", false));

        TranslateTransition glideDown = new TranslateTransition(Duration.seconds(0.2), sprite);
        glideDown.setToX(50);
        glideDown.setToY(600);

        // 2. Transition Tunnel (Changement image + Rotation en parallèle)
        PauseTransition changeToTunnel = new PauseTransition(Duration.millis(100));
        changeToTunnel.setOnFinished(e -> {
            background.setImage(new Image(getClass().getResourceAsStream("/images/neon_tube.png")));
            sprite.setTranslateX(0);
            sprite.setTranslateY(0);
            showDialogue("AAAAH !", false);
        });
        ParallelTransition tunnelStep = new ParallelTransition(changeToTunnel, createRotation(1.5));

        // 3. Transition Galaxie (Changement image + Rotation en parallèle)
        PauseTransition changeToGalaxy = new PauseTransition(Duration.seconds(0.1));
        changeToGalaxy.setOnFinished(e -> background.setImage(new Image(getClass().getResourceAsStream("/images/cosmos.png"))));
        ParallelTransition galaxyStep = new ParallelTransition(changeToGalaxy, createRotation(1.5));

        // 4. Transition Stars (Changement image + Rotation en parallèle)
        PauseTransition changeToStars = new PauseTransition(Duration.seconds(0.1));
        changeToStars.setOnFinished(e -> background.setImage(new Image(getClass().getResourceAsStream("/images/stars.png"))));
        ParallelTransition starsStep = new ParallelTransition(changeToStars, createRotation(1.5));

        // 5. Écran Final (Positionnement en bas à droite)
        PauseTransition finalScreen = new PauseTransition(Duration.seconds(1));
        finalScreen.setOnFinished(e -> {
            background.setImage(new Image(getClass().getResourceAsStream("/images/title_backrooms.png")));
            sprite.setRotate(0);
            // Positionne le personnage en bas à droite (300, 200 sur une scène 800x600)
            sprite.setTranslateX(-300);
            sprite.setTranslateY(200);
            sprite.setVisible(true); // Assure qu'il est visible s'il avait été caché
            dialogueBox.setVisible(false);
        });

        // Séquence globale
        SequentialTransition sequence = new SequentialTransition(
                moveInitial, thinkOh, sayNo, glideDown,
                new PauseTransition(Duration.seconds(1)),
                tunnelStep,
                galaxyStep,
                starsStep,
                finalScreen
        );
        sequence.play();
    }

    private void showDialogue(String text, boolean isThink) {
        dialogueBox.setText(text);
        dialogueBox.setVisible(true);
        Timeline hide = new Timeline(new KeyFrame(Duration.seconds(1.5), e -> dialogueBox.setVisible(false)));
        hide.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}