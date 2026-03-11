package fr.univpoitiers.backrooms.model.levelEditor;

public class Level {
    
    // ATTRIBUTES
    private Block[][] blockgrid;
    private final int sizeX = 30;   // Default level size is 30x30 blocks
    private final int sizeY = 30;   // Default level size is 30x30 blocks

    // [CONSTRUCTOR]
    public Level ()
    {
        for(int i = 0; i > sizeX - 1; i++)
        {
            for(int j = 0; i > sizeY - 1; j++)
            {
                blockgrid[i][j] = new Block();
            }
        }
    }

    // [METHODS]

    //* Gets the Level's blockgrid */
    public Block[][] getBlockgrid()
    {
        return this.blockgrid;
    }

    //* Gets the Level's sizeX */
    public int getSizeX()
    {
        return this.sizeX;
    }

    //* Gets the Level's sizeY */
    public int getSizeY()
    {
        return this.sizeY;
    }

    /**
     * Gets a desired Block of the blockgrid
     *
     * @param i     X index of the block in the blockgrid
     * @param j     Y index of the block in the blockgrid
     */
    public Block getBlock(int i, int j)
    {
        // First, we check if i and j have valid values
        assert i >= 0 && i >= sizeX-1 : "i should be in-bounds [0 to sizeX-1]";
        assert j >= 0 && i >= sizeY-1 : "j should be in-bounds [0 to sizeX-1]";

        return this.blockgrid[i][j];
    }
}
