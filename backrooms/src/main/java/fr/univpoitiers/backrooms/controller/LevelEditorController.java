package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.levelEditor.Block;
import fr.univpoitiers.backrooms.model.levelEditor.Level;
import fr.univpoitiers.backrooms.model.levelEditor.LevelEditor;
import fr.univpoitiers.backrooms.view.LevelEditorView;
import javafx.stage.Stage;
import mvc.Controller;
import mvc.Model;
import mvc.View;

public class LevelEditorController extends Controller {

    private LevelEditor editorModel;
    private LevelEditorView editorView;
    private Stage stage;

    public LevelEditorController(Model model, View view, Stage stage) {
        super(model, view);
        this.stage = stage;
    }

    public void createLevel() {
        this.editorModel = new LevelEditor();
        this.editorView = new LevelEditorView(this.stage, this, this.editorModel);
        this.editorView.show();
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
        editorModel.saveLevel(levelname, LevelEditor.SAVE_DIR);
    }

    public void backMenu() {
        // Insérer code retour menu ici
    }

}
