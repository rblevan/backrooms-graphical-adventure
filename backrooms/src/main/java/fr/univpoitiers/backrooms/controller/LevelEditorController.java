package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.enumeration.BlockType;
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

    public void selectBrush(BlockType type) {
        // à changer
        this.editorModel.getSelectedPresetBlock().updateBlock(
                1, type, null, 1, null
        );
        //view.updateGrid();
    }

    public void changeBlockType(int x, int y) {
        Block targetBlock = editorModel.getLevel().getBlock(x, y);

        BlockType currentBrushType = editorModel.getSelectedPresetBlock().getType();

        targetBlock.updateBlock(1, currentBrushType, null, 1, null);

        editorView.updateGridCell(x, y, currentBrushType);
    }


}
