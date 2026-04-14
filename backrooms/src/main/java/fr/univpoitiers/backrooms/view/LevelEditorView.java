package fr.univpoitiers.backrooms.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fr.univpoitiers.backrooms.controller.LevelEditorController;
import fr.univpoitiers.backrooms.model.levelEditor.Block;
import fr.univpoitiers.backrooms.model.levelEditor.BlockDirectory;
import fr.univpoitiers.backrooms.model.levelEditor.Level;
import fr.univpoitiers.backrooms.model.levelEditor.LevelEditor;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.View;

public class LevelEditorView implements View {
    private final Stage stage;
    private final LevelEditorController controller;
    private final LevelEditor editorModel;
    private final BlockDirectory blockDirectory;

    private final Button[][] visualGrid;
    private final Button[][] paletteBlocksGrid;

    public LevelEditorView(Stage stage, LevelEditorController controller, LevelEditor editorModel) {
        this.stage = stage;
        this.controller = controller;
        this.editorModel = editorModel;
        this.blockDirectory = new BlockDirectory();
        this.blockDirectory.init();

        int sizeX = editorModel.getLevel().getSizeX();
        int sizeY = editorModel.getLevel().getSizeY();
        this.visualGrid = new Button[sizeX][sizeY];

        // En comptant les blocks du level1 et level2, on a 44 blocks donc 4 * 11, de manière très pratique
        int paletteGridColumns = 4;
        int paletteGridRows = 12;
        this.paletteBlocksGrid = new Button[paletteGridColumns][paletteGridRows];

        buildUI();
    }

    private void buildUI() {
        BorderPane root = new BorderPane();

        // --- 1. LA GRILLE AU CENTRE ---
        GridPane grid = new GridPane();
        int sizeX = editorModel.getLevel().getSizeX();
        int sizeY = editorModel.getLevel().getSizeY();

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                ImageView buttonImage = new ImageView(new Image(getClass().getResource("/images/blocks/void.png").toExternalForm()));
                buttonImage.setPreserveRatio(false);

                Button button = new Button(null, buttonImage);
                button.setMinSize(20, 20);
                button.setPrefSize(20, 20);
                button.setMaxSize(20, 20);

                buttonImage.fitWidthProperty().bind(button.widthProperty().multiply(0.9));
                buttonImage.fitHeightProperty().bind(button.heightProperty().multiply(0.9));

                visualGrid[x][y] = button;

                int finalX = x;
                int finalY = y;
                button.setOnAction(e -> {
                    Block selectedBlock = editorModel.getSelectedPresetBlock();
                    Level level = editorModel.getLevel();
                    controller.editLevelBlock(level, finalX, finalY, selectedBlock);
                        
                    ImageView newButtonImage = selectedBlock.getSprite();
                    newButtonImage.setPreserveRatio(false);
                    newButtonImage.fitWidthProperty().bind(button.widthProperty().multiply(0.9));
                    newButtonImage.fitHeightProperty().bind(button.heightProperty().multiply(0.9));
                    button.setGraphic(newButtonImage);
                });

                grid.add(button, x, y);
            }
        }
        root.setCenter(grid);

        // --- 2. LA PALETTE D'OUTILS À DROITE ---
        VBox palette = new VBox(10);
        palette.setPadding(new Insets(15));
        palette.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #cccccc; -fx-border-width: 0 0 0 1;");

        // 2.1 Level Name Label and TextField
        Label levelNameLabel = new Label("Level name : ");
        TextField levelNameTextField = new TextField();
        levelNameTextField.setText(getCurrentDateTime());
        levelNameTextField.setEditable(true);
        levelNameTextField.requestFocus();
        HBox levelNameHBox = new HBox(10);
        levelNameHBox.getChildren().addAll(levelNameLabel, levelNameTextField);

        // 2.3 Grille de preset blocks pour level building
        GridPane paletteGrid = new GridPane();
        // En comptant les blocks du level1 et level2, on a 48 blocks donc 4 * 12, de manière très pratique
        int paletteGridRows = 4;
        int paletteGridColumns = 12;
        for (int x = 0; x < paletteGridRows; x++) {
            for (int y = 0; y < paletteGridColumns; y++) {
                ImageView buttonImage = blockDirectory.getBlock(y * 4 + x).getSprite();
                buttonImage.setPreserveRatio(false);

                Button button = new Button(null, buttonImage);
                button.setMinSize(40, 40);
                button.setPrefSize(40, 40);
                button.setMaxSize(40, 40);

                buttonImage.fitWidthProperty().bind(button.widthProperty().multiply(0.9));
                buttonImage.fitHeightProperty().bind(button.heightProperty().multiply(0.9));

                paletteBlocksGrid[x][y] = button;

                int finalX = x;
                int finalY = y;
                button.setOnAction(e -> {
                    Block newSelectedBlock = blockDirectory.getBlock(finalY * 4 + finalX);
                    controller.updateSelection(newSelectedBlock);
                });

                paletteGrid.add(button, x, y);
            }
        }

        // 2.3 Bouton Save Level
        Button btnSaveLevel = new Button("Save Level");
        btnSaveLevel.setOnAction(e -> {
            String levelName = levelNameTextField.getText();
            controller.saveLevel(levelName);
        });

        // 2.4 Bouton Retour Main Menu 
        Button btnBack2MainMenu = new Button("Main Menu");
        btnBack2MainMenu.setOnAction(e -> controller.backMenu());

        // Intégration des différents éléments dans la palette puis intégration dans root
        palette.getChildren().addAll(levelNameHBox, paletteGrid, btnSaveLevel, btnBack2MainMenu);
        root.setRight(palette);

        // --- 3. CREATION SCENE ---
        Scene scene = new Scene(root, 900, 700);
        stage.setTitle("Backrooms - Level Editor");
        stage.setScene(scene);
    }

    private String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        return now.format(formatter);
    }

    public void show() {
        this.stage.show();
    }

    public void hide() {
        this.stage.hide();
    }
}