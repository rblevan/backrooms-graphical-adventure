package fr.univpoitiers.backrooms.model.levelEditor;

public class Level {
    
    // ATTRIBUTES
    private Block[][] blockgrid;
    private final int sizeX = 30;   // Default level size is 30x30 blocks
    private final int sizeY = 30;   // Default level size is 30x30 blocks

    // [CONSTRUCTOR]
    public Level ()
    {
        this.blockgrid = new Block[sizeX][sizeY];

        for(int i = 0; i < sizeX; i++)
        {
            for(int j = 0; i < sizeY; j++)
            {
                this.blockgrid[i][j] = new Block();
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
        assert i >= 0 && i < sizeX : "i should be in-bounds";
        assert j >= 0 && i < sizeY : "j should be in-bounds";

        return this.blockgrid[i][j];
    }
}
