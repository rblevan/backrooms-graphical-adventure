package fr.univpoitiers.backrooms.model.levelEditor;

public class LevelEditor {

    // [ATTRIBUTES]
    private Level level = new Level();

    // [METHODS]
    
    /**
     * Sets image for selected block
     * 
     * @param i     X index of the block in the blockgrid
     * @param j     Y index of the block in the blockgrid
    */
    public void blockSetImage(int i, int j)
    {
        switch(level.getBlock(i, j).getLevel())
        {
            case 1:
            // aaa
            break;

            case 2:
            // aaa
            break;

            default:
            System.err.println("level.gridblock[i][j].level is not in [1-2] range");
        }
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
