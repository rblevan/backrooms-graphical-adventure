package fr.univpoitiers.backrooms.view;

import fr.univpoitiers.backrooms.controller.GameController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class MenuWindow extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GameController controller = new GameController(stage);
        controller.prepareGame(); // On crée le monde et le perso

        StackPane menu = new StackPane();

        controller.setVideoBackground(menu, "/video/menu_backrooms.mp4");

        String imagePath = Objects.requireNonNull(getClass().getResource("/images/title_backrooms.png")).toExternalForm();
        ImageView title = new ImageView(new Image(imagePath));
        title.setFitWidth(400);
        title.setFitHeight(200);
        title.setPreserveRatio(true);

        VBox menuPrincipal = new VBox(100);
        menuPrincipal.setAlignment(Pos.CENTER);

        HBox menuButtons = new HBox(150);
        menuButtons.setAlignment(Pos.BOTTOM_CENTER);

        Button btnText = new Button("Mode Textuel");
        btnText.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles/menu.css")).toExternalForm());

        Button btnWorld = new Button("Mode OpenWorld");
        btnWorld.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles/menu.css")).toExternalForm());

        menuButtons.getChildren().addAll(btnText, btnWorld);

        menuPrincipal.getChildren().addAll(title,menuButtons);

        menu.getChildren().add(menuPrincipal);

        btnText.setOnAction(e -> controller.startTextMode());
        btnWorld.setOnAction(e -> controller.startWorldMode());


        Scene scene = new Scene(menu, 800, 600);
        stage.setTitle("Starting Menu");
        stage.setScene(scene);
        stage.show();
    }
}
