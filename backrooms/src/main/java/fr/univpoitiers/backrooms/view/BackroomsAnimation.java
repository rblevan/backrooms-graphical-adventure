package fr.univpoitiers.backrooms.view;

import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BackroomsAnimation {

    private StackPane root;
    private ImageView background;
    private ImageView sprite;
    private Label dialogueBox;
    private Stage stage;

    // Interface pour savoir quand l'animation se termine
    public interface AnimationFinishedListener {
        void onFinished();
    }

    public BackroomsAnimation(Stage stage, AnimationFinishedListener listener) {
        this.stage = stage;
        this.root = new StackPane();

        initContent();

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();

        runScratchLogic(listener);
    }

    private void initContent() {
        // Chargement des ressources avec getResourceAsStream
        background = new ImageView(new Image(getClass().getResourceAsStream("/images/introAnimation/city_night.png")));
        background.setFitWidth(800);
        background.setFitHeight(600);

        sprite = new ImageView(new Image(getClass().getResourceAsStream("/images/introAnimation/steph.png")));
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
    }

    private RotateTransition createRotation(double durationSeconds) {
        RotateTransition rt = new RotateTransition(Duration.seconds(durationSeconds), sprite);
        rt.setByAngle(360 * 3);
        rt.setInterpolator(Interpolator.LINEAR);
        return rt;
    }

    private void runScratchLogic(AnimationFinishedListener listener) {
        // 1. Mouvement et dialogues
        TranslateTransition moveInitial = new TranslateTransition(Duration.seconds(1), sprite);
        moveInitial.setByX(200);

        PauseTransition thinkOh = new PauseTransition(Duration.seconds(1));
        thinkOh.setOnFinished(e -> showDialogue("Oh...", true));

        PauseTransition sayNo = new PauseTransition(Duration.seconds(1));
        sayNo.setOnFinished(e -> showDialogue("NOOOON !", false));

        TranslateTransition glideDown = new TranslateTransition(Duration.seconds(0.2), sprite);
        glideDown.setToX(50);
        glideDown.setToY(600);

        // 2. Transition Tunnel
        PauseTransition changeToTunnel = new PauseTransition(Duration.millis(100));
        changeToTunnel.setOnFinished(e -> {
            background.setImage(new Image(getClass().getResourceAsStream("/images/introAnimation/neon_tube.png")));
            sprite.setTranslateX(0);
            sprite.setTranslateY(0);
            showDialogue("AAAAH !", false);
        });
        ParallelTransition tunnelStep = new ParallelTransition(changeToTunnel, createRotation(1.5));

        // 3. Transition Galaxie
        PauseTransition changeToGalaxy = new PauseTransition(Duration.seconds(0.1));
        changeToGalaxy.setOnFinished(e -> background.setImage(new Image(getClass().getResourceAsStream("/images/introAnimation/cosmos.png"))));
        ParallelTransition galaxyStep = new ParallelTransition(changeToGalaxy, createRotation(1.5));

        // 4. Transition Stars
        PauseTransition changeToStars = new PauseTransition(Duration.seconds(0.1));
        changeToStars.setOnFinished(e -> background.setImage(new Image(getClass().getResourceAsStream("/images/introAnimation/stars.png"))));
        ParallelTransition starsStep = new ParallelTransition(changeToStars, createRotation(1.5));

        // 5. Écran Final
        PauseTransition finalScreen = new PauseTransition(Duration.seconds(1));
        finalScreen.setOnFinished(e -> {
            background.setImage(new Image(getClass().getResourceAsStream("/images/title_backrooms.png")));
            sprite.setRotate(0);
            sprite.setTranslateX(-300);
            sprite.setTranslateY(200);
            dialogueBox.setVisible(false);
        });

        // Séquence globale
        SequentialTransition sequence = new SequentialTransition(
                moveInitial, thinkOh, sayNo, glideDown,
                new PauseTransition(Duration.seconds(1)),
                tunnelStep,
                galaxyStep,
                starsStep,
                finalScreen,
                new PauseTransition(Duration.seconds(2)) // Petite pause à la fin
        );

        // Quand TOUTE la séquence est finie, on appelle le listener
        sequence.setOnFinished(e -> {
            if (listener != null) listener.onFinished();
        });

        sequence.play();
    }

    private void showDialogue(String text, boolean isThink) {
        dialogueBox.setText(text);
        dialogueBox.setVisible(true);
        Timeline hide = new Timeline(new KeyFrame(Duration.seconds(1.5), e -> dialogueBox.setVisible(false)));
        hide.play();
    }
}