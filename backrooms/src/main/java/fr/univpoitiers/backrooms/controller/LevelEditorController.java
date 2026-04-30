package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.levelEditor.Block;
import fr.univpoitiers.backrooms.model.levelEditor.Level;
import fr.univpoitiers.backrooms.model.levelEditor.LevelEditor;
import fr.univpoitiers.backrooms.view.LevelEditorView;
import javafx.scene.Parent;
import javafx.stage.Stage;
import mvc.Controller;
import mvc.Model;
import mvc.View;

public class LevelEditorController extends Controller {

    private LevelEditor editorModel;
    private LevelEditorView editorView;
    private Stage stage;
    private MenuController menuController;

    public LevelEditorController(Model model, View view, Stage stage) {
        super(model, view);
        this.stage = stage;
    }

    public void createLevel() {
        this.editorModel = new LevelEditor();
        this.editorView = new LevelEditorView(this.stage, this, this.editorModel);
        this.editorView.show();
        // The creation of MenuController might be starting the video again. We should defer it or use the existing one
        // this.menuController = MenuController.create();
    }

    // Add a setter for MenuController so we can reuse the existing one
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public View getView() {
        return this.editorView;
    }

    public void updateSelection(Block SelectedBlock) {
        editorModel.updateSelectedPresetBlock(SelectedBlock);
    }

    public void editLevelBlock(Level level, int destinationBlockIndexX, int destinationBlockIndexY, Block sourceBlock) {
        level.setBlock(destinationBlockIndexY, destinationBlockIndexY, sourceBlock);
    }

    public void saveLevel(String levelname) {
        editorModel.saveLevel(levelname, LevelEditor.CUSTOM_DIR);
    }

    public void backMenu() {
        if (menuController == null) {
            menuController = MenuController.create();
        } else {
            // Re-initialize the video if coming back to an existing menu
            menuController.restartVideo();
        }
        
        stage.getScene().setRoot((Parent) menuController.getView());

        // Dimensions du stage de MenuView + centrer
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.centerOnScreen();
    }
}