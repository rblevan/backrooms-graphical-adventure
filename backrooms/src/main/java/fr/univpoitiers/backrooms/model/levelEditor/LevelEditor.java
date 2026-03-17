package fr.univpoitiers.backrooms.model.levelEditor;

public class LevelEditor {

    // [ATTRIBUTES]
    private Level level = new Level();
    private Block selectedPresetBlock = new Block();

    // [METHODS]
    
    //* Gets the LevelEditor's level */
    public Level getLevel()
    {
        return this.level;
    }

    //* Gets the LevelEditor's selected Block */
    public Block getSelectedPresetBlock()
    {
        return this.selectedPresetBlock;
    }

    /**
     * Saves created level into a .json file
     *
     * @param namefile  The name you want to save your level as
     */
    /*
    public void saveLevel(namefile)
    {
        //aaa
    }
    */

    /**
     * Loads created level from a .json file
     *
     * @param namefile  The name you want to save your level as
     */
    /*
    public void loadLevel(namefile)
    {
        //aaa
    }
    */
}
