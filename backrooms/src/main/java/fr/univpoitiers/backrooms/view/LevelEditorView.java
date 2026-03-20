package fr.univpoitiers.backrooms.view;

import fr.univpoitiers.backrooms.controller.LevelEditorController;
import fr.univpoitiers.backrooms.model.enumeration.BlockType;
import fr.univpoitiers.backrooms.model.levelEditor.LevelEditor;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import mvc.View;

public class LevelEditorView implements View {
    private Stage stage;
    private LevelEditorController controller;
    private LevelEditor editorModel;

    private Rectangle[][] visualGrid;

    public LevelEditorView(Stage stage, LevelEditorController controller, LevelEditor editorModel) {
        this.stage = stage;
        this.controller = controller;
        this.editorModel = editorModel;

        int sizeX = editorModel.getLevel().getSizeX();
        int sizeY = editorModel.getLevel().getSizeY();
        this.visualGrid = new Rectangle[sizeX][sizeY];

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
                Rectangle rect = new Rectangle(20, 20);
                rect.setFill(Color.LIGHTGRAY);
                rect.setStroke(Color.BLACK);

                visualGrid[x][y] = rect;

                int finalX = x;
                int finalY = y;
                rect.setOnMouseClicked(e -> {
                    controller.changeBlockType(finalX, finalY);
                });

                grid.add(rect, x, y);
            }
        }
        root.setCenter(grid);

        // --- 2. LA PALETTE D'OUTILS À DROITE ---
        VBox palette = new VBox(10);
        palette.setPadding(new Insets(15));
        palette.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #cccccc; -fx-border-width: 0 0 0 1;");

        Button btnVoid = new Button("Gomme (VOID)");
        btnVoid.setOnAction(e -> controller.selectBrush(BlockType.VOID));

        Button btnGround = new Button("Sol (GROUND)");
        btnGround.setOnAction(e -> controller.selectBrush(BlockType.GROUND));

        Button btnWall = new Button("Mur (WALL)");
        btnWall.setOnAction(e -> controller.selectBrush(BlockType.WALL));

        palette.getChildren().addAll(btnVoid, btnGround, btnWall);
        root.setRight(palette);

        // --- 3. CREATION SCENE ---
        Scene scene = new Scene(root, 900, 700);
        stage.setTitle("Backrooms - Level Editor");
        stage.setScene(scene);
    }

    public void updateGridCell(int x, int y, BlockType newType) {
        Rectangle rect = visualGrid[x][y];
        switch (newType) {
            case WALL:
                rect.setFill(Color.DARKSLATEGRAY);
                break;
            case GROUND:
                rect.setFill(Color.BEIGE);
                break;
            case VOID:
            default:
                rect.setFill(Color.LIGHTGRAY);
                break;
        }
    }

    public void show() {
        this.stage.show();
    }

    public void hide() {
        this.stage.hide();
    }
}